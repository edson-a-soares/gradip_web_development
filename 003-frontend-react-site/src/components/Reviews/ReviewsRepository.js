import Application from "../../components/Common/Application";

const ReviewsRepository = {

    add : (onSuccess, data) => {
        fetch(Application.getURL(`/movies/${data.movieId}/reviews`), {
            method : 'POST',
            headers : Application.getHeaders(),
            body: JSON.stringify(data.payload)
        })
            .then((response) => response.json())
            .then((response) => onSuccess(response))
            .catch((error) => console.log(error));
    },

    all : (setData, setError, setLoading, {movieId}) => {
        fetch(Application.getURL(`/movies/${movieId}/reviews`), {
            method : 'GET',
            headers : Application.getHeaders()
        })
            .then((response) => response.json())
            .then((json) => setData(json))
            .catch((error) => setError(error))
            .finally(() => setLoading(false));
    }

}

export default ReviewsRepository;
