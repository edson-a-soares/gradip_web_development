import Application from "../../components/Application";

const ActorsRepository = {

    all : (setData, setError, setLoading) => {
        fetch(Application.getURL('/actors'), {
            method : 'GET',
            headers : Application.getHeaders()
        })
            .then((response) => response.json())
            .then((json) => setData(json))
            .catch((error) => setError(error))
            .finally(() => setLoading(false));
    }

}

export default ActorsRepository;
