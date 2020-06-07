import Rating from 'react-rating';
import Error from "../Common/Error";
import {Link} from "react-router-dom";
import Preloader from "../Common/Preloader";
import React, {useState, useEffect} from 'react';
import MoviesRepository from "./MoviesRepository";
import ReviewingForm from "../Reviews/ReviewingForm";
import CommentsSection from "../Reviews/CommentsSection";


const Figure = ({ file }) =>
    <figure className="movie-poster">
        <img src={file} alt="#" />
    </figure>


const PlotSummary = ({ text }) =>
    <p className="movie-summary">
        {text}
    </p>


const PlotSynopsis = ({ text }) =>
    <p className="entry-content">{text}</p>


const SingleMoviePage = (Figure, PlotSummary, PlotSynopsis, {movieId}) => {

    const [movie, setMovie]       = useState({});
    const [error, setError]       = useState(null);
    const [isLoading, setLoading] = useState(false);

    useEffect(() => {
        MoviesRepository.fetchOne(setMovie, setError, setLoading, {movieId});
    }, [movieId]);

    return error ? <Error message={error} /> :
        isLoading ? <Preloader /> :
            <div>
                <div className="breadcrumbs">
                    <Link to="/">Home</Link>
                    <span>{movie.title}</span>
                </div>
                <div className="content">
                    <div className="row">
                        <div className="col-md-6">
                            <Figure file={"/assets/images/single-image.jpg"}/>
                        </div>
                        <div className="col-md-6">
                            <h2 className="movie-title">{movie.title}</h2>
                            <PlotSummary text={movie.plot_summary}/>
                            <ul className="movie-meta">
                                <li>
                                    <strong>Rating: </strong>
                                    <span title={`Rated ${movie.average_rating} out of 5`}>
                                        <Rating
                                            readonly
                                            initialRating={movie.average_rating}
                                            emptySymbol={<img src="/assets/images/star-grey.png" className="rating" alt="#"/>}
                                            fullSymbol={<img src="/assets/images/star-yellow.png" className="rating" alt="#"/>}
                                        />
                                    </span>
                                </li>
                                <li><strong>Length:</strong> {movie.length} min</li>
                                <li><strong>Release Year:</strong> {movie.release_year}</li>
                                <li>
                                    <strong>Category: </strong>
                                    {
                                        (Array.isArray(movie.categories) && movie.categories.length)
                                            ?
                                                movie.categories.map(function (item, index) {
                                                    return (index ? '/' : '') + item;
                                                })
                                            :
                                                ''
                                    }
                                </li>
                            </ul>

                            <ul className="starring">
                                <li>
                                    <strong>Directors: </strong>
                                    {
                                        (Array.isArray(movie.directors) && movie.directors.length)
                                            ?
                                                movie.directors.map(function (item, index) {
                                                    return (index ? ', ' : '') + item;
                                                })
                                            :
                                                ''
                                    }
                                </li>
                                <li>
                                    <strong>Writers: </strong>
                                    {
                                        (Array.isArray(movie.writers) && movie.writers.length)
                                            ?
                                                movie.writers.map(function (item, index) {
                                                    return (index ? ', ' : '') + item;
                                                 })
                                            :
                                                ''
                                    }
                                </li>
                                <li>
                                    <strong>Stars: </strong>
                                    {
                                        (Array.isArray(movie.stars) && movie.stars.length)
                                            ?
                                                movie.stars.map(function (item, index) {
                                                    return (index ? ', ' : '') + item;
                                                })
                                            :
                                                ''
                                    }
                                </li>
                            </ul>
                        </div>
                    </div>
                    <PlotSynopsis text={movie.plot_synopsis}/>
                    <hr/>
                    <ReviewingForm movieId={movieId}/>
                    <hr/>
                    <CommentsSection movieId={movieId}/>
                </div>
            </div>

}


export default function ({movieId}) {

    return SingleMoviePage(Figure, PlotSummary, PlotSynopsis, {movieId});
}
