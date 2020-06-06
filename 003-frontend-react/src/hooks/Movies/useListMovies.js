import { useEffect, useState } from 'react';
import API from "../../components/Common/API";

export default () => {

  const [error, setError] = useState(null);
  const [movies, setMovies] = useState([]);
  const [isLoading, setIsLoading] = useState(false);

  const fetchMovies = () => {

    setIsLoading(true);
    const onSuccess = (response) => {
      setIsLoading(false);
      setMovies(response.data);
    }

    const onError = (error) => {
      console.error(error);
      setIsLoading(false);
      setError({ message: 'Unable to load movies.' });
    }

    (() => {
      API.get('/movies')
          .then(onSuccess)
          .catch(onError);
    })();

  };

  useEffect(() => fetchMovies(), []);

  return [movies, isLoading, error, fetchMovies];

}