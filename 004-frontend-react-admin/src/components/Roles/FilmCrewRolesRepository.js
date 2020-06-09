import Application from "../../components/Application";

const FilmCrewRolesRepository = {

    all : (setData, setError, setLoading) => {
        fetch(Application.getURL('/film-crew/roles'), {
            method : 'GET',
            headers : Application.getHeaders()
        })
            .then((response) => response.json())
            .then((json) => setData(json))
            .catch((error) => setError(error))
            .finally(() => setLoading(false));
    }

}

export default FilmCrewRolesRepository;
