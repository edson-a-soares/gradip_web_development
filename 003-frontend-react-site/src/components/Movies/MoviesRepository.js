import Application from "../../components/Common/Application";

const MoviesRepository = {

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
