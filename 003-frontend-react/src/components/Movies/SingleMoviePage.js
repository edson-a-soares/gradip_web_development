import React from 'react';
import Rating from 'react-rating';


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


const SingleMoviePage = (Figure, PlotSummary, PlotSynopsis, {movie}) =>
    <div>
        <div className="breadcrumbs">
            <a href="/">Home</a>
            <span>{movie.title}</span>
        </div>
        <div className="content">
            <div className="row">
                <div className="col-md-6">
                    <Figure file={"/assets/images/single-image.jpg"} />
                </div>
                <div className="col-md-6">
                    <h2 className="movie-title">{movie.title}</h2>
                    <PlotSummary text={movie.plot_summary} />
                    <ul className="movie-meta">
                        <li>
                            <strong>Rating: </strong>
                            <span title={`Rated ${movie.rating} out of 5`}>
                                <Rating
                                    readonly
                                    initialRating={movie.rating}
                                    emptySymbol={ <img src="/assets/images/star-grey.png" className="rating" /> }
                                    fullSymbol={ <img src="/assets/images/star-yellow.png" className="rating" /> }
                                />
                            </span>
                        </li>
                        <li><strong>Length:</strong> {movie.length} min</li>
                        <li><strong>Release Year:</strong> {movie.release_year}</li>
                        <li>
                            <strong>Category: </strong>
                            {
                                movie.categories.map(function(item, index) {
                                    return (index ? '/' : '') + item;
                                })
                            }
                        </li>
                    </ul>

                    <ul className="starring">
                        <li>
                            <strong>Directors: </strong>
                            {
                                movie.directors.map(function(item, index) {
                                    return (index ? ', ' : '') + item;
                                })
                            }
                        </li>
                        <li>
                            <strong>Writers: </strong>
                            {
                                movie.writers.map(function(item, index) {
                                    return (index ? ', ' : '') + item;
                                })
                            }
                        </li>
                        <li>
                            <strong>Stars: </strong>
                            {
                                movie.stars.map(function(item, index) {
                                    return (index ? ', ' : '') + item;
                                })
                            }
                        </li>
                    </ul>
                </div>
            </div>

            <PlotSynopsis text={movie.plot_synopsis} />
        </div>
    </div>


export default function ({movie}) {
    return SingleMoviePage(Figure, PlotSummary, PlotSynopsis, {movie});
}
