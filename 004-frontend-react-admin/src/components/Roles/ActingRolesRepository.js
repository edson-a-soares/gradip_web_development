import Application from "../../components/Application";

const ActingRolesRepository = {

    all : (setData, setError, setLoading) => {
        fetch(Application.getURL('/acting/roles'), {
            method : 'GET',
            headers : Application.getHeaders()
        })
            .then((response) => response.json())
            .then((json) => setData(json))
            .catch((error) => setError(error))
            .finally(() => setLoading(false));
    }

}

export default ActingRolesRepository;
