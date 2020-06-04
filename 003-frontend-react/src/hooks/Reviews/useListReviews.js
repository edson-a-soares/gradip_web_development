import axios from 'axios';
import { useEffect, useState } from 'react';

export default ({ movieId }) => {

  const [error, setError] = useState(null);
  const [reviews, setReviews] = useState([]);
  const [isLoading, setIsLoading] = useState(false);

  const fetchReviews = () => {

    setIsLoading(true);
    const onSuccess = (response) => {
      setIsLoading(false);
      setReviews(response.data);
    }

    const onError = (error) => {
      console.error(error);
      setIsLoading(false);
      setError({ message: 'Unable to load reviews.' });
    }

    (() => {
      axios.get(`http://localhost:8080/movies/${movieId}/reviews`)
          .then(onSuccess)
          .catch(onError);
    })();

  };

  useEffect(() => fetchReviews(), []);

  return [reviews, isLoading, error, fetchReviews];

}