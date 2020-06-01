import React from 'react';
import MovieCard from '../../components/Movies/Movie';

let movies = [
    {
        "id" : "123456",
        "text" : "Movie Title",
        "link" : "single.html",
        "description" : "Sed ut perspiciatis unde omnis iste natus error voluptatem doloremque."
    },
    {
        "id" : "1234567",
        "text" : "Movie Title",
        "link" : "single.html",
        "description" : "Sed ut perspiciatis unde omnis iste natus error voluptatem doloremque."
    }
]

const MoviesList = () =>
    <div className="movie-list">
        { movies.map(movie => <MovieCard key={movie.id} info={movie} />) }
    </div>


export default MoviesList;
