import API from "../components/Common/API";
import {useCallback, useEffect, useState} from 'react';

export default (URI) => {

  const [data, setData] = useState([]);
  const [error, setError] = useState(null);
  const [isLoading, setIsLoading] = useState(false);

  const fetchList = useCallback(() => {

    setIsLoading(true);
    const onSuccess = (response) => {
      setIsLoading(false);
      setData(response.data);
    }

    const onError = (error) => {
      console.error(error);
      setIsLoading(false);
      setError({ message: 'Unable to load data.' });
    }

    (() => {
      API.get(`${URI}`)
          .then(onSuccess)
          .catch(onError);
    })();

  }, [URI]);

  useEffect(() => fetchList(), [fetchList]);

  return [data, isLoading, error, fetchList];

}