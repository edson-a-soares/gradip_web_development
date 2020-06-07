import React, {useState, useEffect} from 'react';
import MoviesRepository from "./MoviesRepository";
import Error from '../../components/Common/Error';
import Preloader from '../../components/Common/Preloader';
import MovieCard from '../../components/Movies/MovieCard';

const MoviesCardsList = () => {

    const [data, setData]         = useState([]);
    const [error, setError]       = useState(null);
    const [isLoading, setLoading] = useState(false);

    useEffect(() => {
        MoviesRepository.all(setData, setError, setLoading);
    }, [])

    return <div className="movie-list">
        {
            error ? <Error message={error} /> :
                    isLoading ? <Preloader /> :
                        data.map(movie => <MovieCard key={movie.id} info={movie} />)
        }
    </div>

}

export default MoviesCardsList;
