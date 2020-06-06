import API from "../../components/Common/API";
import { useEffect, useCallback, useState } from 'react';

export default ({ movieId }) => {

  const [movie, setMovie] = useState([]);
  const [error, setError] = useState(null);
  const [isLoading, setIsLoading] = useState(false);

  const fetchSingleMovie = useCallback(() => {

    setIsLoading(true);
    const onSuccess = (response) => {
      setIsLoading(false);
      setMovie(response.data);
    }

    const onError = (error) => {
      console.error(error);
      setIsLoading(false);
      setError({ message: 'Unable to load movie.' });
    }

    (() => {
      API.get(`/movies/${movieId}`)
          .then(onSuccess)
          .catch(onError);
    })();

  }, [movieId]);

  useEffect(() => fetchSingleMovie(), [fetchSingleMovie]);

  return [movie, isLoading, error, fetchSingleMovie];

}