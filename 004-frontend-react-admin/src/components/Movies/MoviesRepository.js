import Application from "../../components/Application";

const MoviesRepository = {

    add : (onSuccess, data) => {
        fetch(Application.getURL('/movies'), {
            method : 'POST',
            headers : Application.getHeaders(),
            body: JSON.parse(
                JSON.stringify(data)
            )
        })
            .then((response) => response.json())
            .then((response) => onSuccess(response))
            .catch((error) => console.log(error));
    },

    all : (setData, onError, setLoading) => {
        fetch(Application.getURL('/movies'), {
            method : 'GET',
            headers : Application.getHeaders()
        })
            .then((response) => response.json())
            .then((json) => setData(json))
            .catch((error) => onError(error))
            .finally(() => setLoading(false));
    },

    fetchOne : (setData, setError, setLoading, {movieId}) => {
        fetch(Application.getURL(`/movies/${movieId}`), {
            method : 'GET',
            headers : Application.getHeaders()
        })
            .then((response) => response.json())
            .then((json) => setData(json))
            .catch((error) => setError(error))
            .finally(() => setLoading(false));
    }

}

export default MoviesRepository;
