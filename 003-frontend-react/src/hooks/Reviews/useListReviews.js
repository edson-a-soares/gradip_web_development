import API from "../../components/Common/API";
import { useEffect, useCallback, useState } from 'react';

export default ({ movieId }) => {

    const [error, setError] = useState(null);
    const [reviews, setReviews] = useState([]);
    const [isLoading, setIsLoading] = useState(false);

  const fetchReviews = useCallback(() => {

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
        API.get(`/movies/${movieId}/reviews`)
          .then(onSuccess)
          .catch(onError);
    })();

  }, [movieId]);

  useEffect(() => fetchReviews(), [fetchReviews]);

  return [reviews, isLoading, error, fetchReviews];

}
