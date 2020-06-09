import Autocomplete from "./Autocomplete";
import React, {useEffect, useState} from 'react';
import FilmCrewRolesRepository from "../Roles/FilmCrewRolesRepository";
import CrewPeopleRepository from "../Crew/CrewPeopleRepository";


const CrewComponentItem = ({index, roles, handlers, payload, autoCompleteOptions}) => {

    const onInputChange = (optionId, optionText) => {
        let member = payload[index];
        member.person_id   = optionId;
        member.person_name = optionText;

        handlers.updateMainPayload();
    }

    return <div className="input-group mb-3">
        <div className="input-group-prepend">
            <button type="button" className="btn btn-outline-danger" onClick={() => handlers.removeCastMember(index)}>Remove member</button>
        </div>
        <select id={index} onChange={event => handlers.updatePayloadOnSelectOption(event)} className="custom-select">
            {
                roles.map(role => <option key={role.id} value={role.id}>{role.name}</option>)
            }
        </select>
        <Autocomplete options={autoCompleteOptions} handlers={{onInputChange}} />
    </div>

}


const CrewComponent = (params) => {

    const [roles, setRoles]             = useState([]);
    const [crewPeople, setCrewPerson]   = useState([]);
    const [error, setError]             = useState(null);
    const [isLoading, setLoading]       = useState(false);
    const [crewMembers, setCrewMember]  = useState([
            { "role_id": "", "person_id": "", "role_name": "", "person_name": "" },
            { "role_id": "", "person_id": "", "role_name": "", "person_name": "" }
        ]);

    useEffect(() => {
        FilmCrewRolesRepository.all(setRoles, setError, setLoading);
        CrewPeopleRepository.all(setCrewPerson, setError, setLoading);
    }, []);

    const addCrewMember = () => {
        setCrewMember([...crewMembers, { "role_id": "", "person_id": "", "role_name": "", "person_name": "" }]);
    }

    const removeCastMember = index => {
        const filtered = crewMembers.filter((value, key) => key !== index);
        setCrewMember(filtered);
        params.onChange(filtered);
    }

    const updateMainPayload = () => {
        params.onChange(crewMembers);
    }

    const onInputChange = (optionId, optionText) => {
        let member = crewMembers[0];
        member.person_id   = optionId;
        member.person_name = optionText;

       updateMainPayload();
    }

    const updatePayloadOnSelectOption = event => {
        event.preventDefault();
        const selectedOption   = event.target.selectedOptions.item(0);
        let member = crewMembers[event.target.id];

        member.role_id   = selectedOption.value;
        member.role_name = selectedOption.text;
        params.onChange(crewMembers);
    }

    return <div id="cast_container">
        <div className="input-group mb-3">
            <div className="input-group-prepend">
                <button type="button" className="btn btn-outline-info" onClick={addCrewMember}>Add member</button>
            </div>
            <select className="custom-select" id="0" onChange={event => updatePayloadOnSelectOption(event)}>
                {
                    error ? 'Refresh the page, please.'  :
                        isLoading ? 'Loading roles ...' :
                            roles.map(role => <option key={role.id} value={role.id}>{role.name}</option>)
                }
            </select>
            <Autocomplete options={crewPeople} handlers={{onInputChange}} />
        </div>
        {
            crewMembers.slice(1).map(
                (member, index) =>
                {
                    const actualIndex = ++index;
                    return <CrewComponentItem
                        roles={roles}
                        key={actualIndex}
                        index={actualIndex}
                        payload={crewMembers}
                        autoCompleteOptions={crewPeople}
                        handlers={{updatePayloadOnSelectOption, updateMainPayload, removeCastMember}}
                    />
                }
            )
        }
    </div>

}

export default function (params) {
    return CrewComponent(params);
}
