import axios from 'axios';
import { useEffect, useState } from 'react';

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
      axios.get('http://localhost:8080/movies')
          .then(onSuccess)
          .catch(onError);
    })();

  };

  useEffect(() => fetchMovies(), []);

  return [movies, isLoading, error, fetchMovies];

}