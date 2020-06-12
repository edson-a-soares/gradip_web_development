import Autocomplete from "./Autocomplete";
import React, {useEffect, useState} from 'react';
import ActingRolesRepository from "../Roles/ActingRolesRepository";
import ActorsRepository from "../Actors/ActorsRepository";


const CastComponentItem = ({index, roles, handlers, payload, autoCompleteOptions}) => {

    const onInputChange = (optionId, optionText) => {
        let member = payload[index];
        member.actor_id   = optionId;
        member.actor_name = optionText;

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


const CastComponent = (params) => {

    const [roles, setRoles]             = useState([]);
    const [actors, setActors]           = useState([]);
    const [error, setError]             = useState(null);
    const [isLoading, setLoading]       = useState(false);
    const [castMembers, setCastMember]  = useState([
            { role_id: '', "actor_id": '', role_name: '', actor_name: '' },
            { role_id: '', "actor_id": '', role_name: '', actor_name: '' }
        ]);

    useEffect(() => {
        ActorsRepository.all(setActors, setError, setLoading);
        ActingRolesRepository.all(setRoles, setError, setLoading);
    }, []);

    const addCastMember = () => {
        setCastMember([...castMembers, { role_id: '', actor_id: '', role_name: '', actor_name: '' }]);
    }

    const removeCastMember = index => {
        const filtered = castMembers.filter((value, key) => key !== index);
        setCastMember(filtered);
        updateMainPayload();
    }

    const updateMainPayload = () => {
        params.onChange(castMembers);
    }

    const onInputChange = (optionId, optionText) => {
        let member = castMembers[0];
        member.actor_id   = optionId;
        member.actor_name = optionText;

        updateMainPayload();
    }

    const onSelectLoading = role => {
        for (const member of castMembers) {
            member.role_id   = role.id;
            member.role_name = role.name;
        }
        updateMainPayload();
    }

    const updatePayloadOnSelectOption = event => {
        event.preventDefault();
        const selectedOption   = event.target.selectedOptions.item(0);
        let member = castMembers[event.target.id];

        member.role_id   = selectedOption.value;
        member.role_name = selectedOption.text;
        updateMainPayload();
    }

    return <div id="cast_container">
        <div className="input-group mb-3">
            <div className="input-group-prepend">
                <button type="button" className="btn btn-outline-info" onClick={addCastMember}>Add member</button>
            </div>
            <select className="custom-select" id="0" onChange={event => updatePayloadOnSelectOption(event)} onLoad={onSelectLoading}>
                {
                    error ? 'Refresh the page, please.'  :
                        isLoading ? 'Loading roles ...' :
                            roles.map((role, index) => {
                                if (index === 0)
                                    onSelectLoading(role);

                                return <option key={role.id} value={role.id}>{role.name}</option>
                            })
                }
            </select>
            <Autocomplete options={actors} handlers={{onInputChange}} />
        </div>
        {
            castMembers.slice(1).map(
                (member, index) =>
                {
                    const actualIndex = ++index;
                    return <CastComponentItem
                        roles={roles}
                        key={actualIndex}
                        index={actualIndex}
                        payload={castMembers}
                        autoCompleteOptions={actors}
                        handlers={{updatePayloadOnSelectOption, updateMainPayload, removeCastMember}}
                    />
                }
            )
        }
    </div>

}

export default function (params) {
    return CastComponent(params);
}
