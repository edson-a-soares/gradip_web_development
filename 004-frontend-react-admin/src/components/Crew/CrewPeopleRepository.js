import Application from "../../components/Application";

const CrewPeopleRepository = {

    all : (setData, setError, setLoading) => {
        fetch(Application.getURL('/film-crew/people'), {
            method : 'GET',
            headers : Application.getHeaders()
        })
            .then((response) => response.json())
            .then((json) => setData(json))
            .catch((error) => setError(error))
            .finally(() => setLoading(false));
    }

}

export default CrewPeopleRepository;
