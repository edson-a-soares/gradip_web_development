import React from 'react';
import MovieCard from '../../components/Movies/MovieCard';

let movies = [
    {
        "id" : "ca4c06e6a8624e2e950d16191e011c68",
        "text" : "Movie One Title",
        "description" : "Sed ut perspiciatis unde omnis iste natus error voluptatem doloremque."
    },
    {
        "id" : "99c93e86a9214bc1b547b905807bf4b0",
        "text" : "Movie Two Title",
        "description" : "Sed ut perspiciatis unde omnis iste natus error voluptatem doloremque."
    }
]

const MoviesCardsList = () =>
    <div className="movie-list">
        { movies.map(movie => <MovieCard key={movie.id} info={movie} />) }
    </div>


export default MoviesCardsList;
