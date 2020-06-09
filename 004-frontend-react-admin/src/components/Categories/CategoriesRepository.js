import Application from "../../components/Application";

const CategoriesRepository = {

    all : (setData, setError, setLoading) => {
        fetch(Application.getURL('/categories'), {
            method : 'GET',
            headers : Application.getHeaders()
        })
            .then((response) => response.json())
            .then((json) => setData(json))
            .catch((error) => setError(error))
            .finally(() => setLoading(false));
    }

}

export default CategoriesRepository;
