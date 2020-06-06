import React from 'react';
import Error from '../../components/Common/Error';
import Preloader from '../../components/Common/Preloader';
import MovieCard from '../../components/Movies/MovieCard';
import useListMovies from '../../hooks/Movies/useListMovies';

const MoviesCardsList = () => {
    const [movies, isLoading, error] = useListMovies();
    return <div className="movie-list">
        {
            error ? <Error message={error} /> :
                    isLoading ? <Preloader /> :
                        movies.map(movie => <MovieCard key={movie.id} info={movie} />)
        }
    </div>

}

export default MoviesCardsList;
