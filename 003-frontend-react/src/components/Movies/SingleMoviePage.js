import React from 'react';
import Rating from 'react-rating';
import CommentsSection from "../Reviews/CommentsSection";
import ReviewingForm from "../Reviews/ReviewingForm";


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

const movie =
    {
        'id' : '123456',
        'rating' : '3',
        'title' : 'The Incredible Hulk',
        'length' : '98',
        'stars' : [ 'Nicolas Cage', 'Ryan Reynolds', 'Emma Stone' ],
        'writers' : [ 'Chris Sanders (screenplay)', 'Kirk De Micco (screenplay)' ],
        'directors' : [ 'Kirk de Mico (as Kirk DeMico).', 'Chris Sanders' ],
        'categories' : [ 'Animation' , 'Adventure', 'Comedy' ],
        'release_year' : '2013',
        'plot_summary' : 'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit sed.',
        'plot_synopsis' : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum ac pharetra libero. Integer in suscipit diam, sit amet eleifend nunc. Curabitur egestas nunc nulla, in aliquet risus efficitur quis. Vivamus facilisis est libero, vitae iaculis nulla cursus in. Suspendisse potenti. In et fringilla ipsum, quis varius quam. Morbi eleifend venenatis diam finibus vehicula. Suspendisse eu blandit metus. Sed feugiat pellentesque turpis, in lacinia ipsum. Vivamus nec luctus orci. Aenean vehicula eget risus sit amet posuere. Maecenas id risus maximus, malesuada leo eget, pellentesque arcu. Phasellus vitae leo rhoncus, consectetur mauris vitae, lacinia quam. Nunc turpis erat, accumsan eget justo quis, auctor ultricies magna. Mauris sodales, risus sit amet hendrerit tincidunt, erat ante facilisis sapien, sit amet maximus neque massa a felis. Nullam consectetur justo massa, vel commodo metus gravida in. Aliquam erat volutpat. Nullam a lorem sed lorem euismod gravida a eu velit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec venenatis ac ligula vel pharetra. Aenean vitae nulla sed dui volutpat euismod. Nam ex quam, consequat id rutrum sed, porttitor id lectus. Vestibulum venenatis consectetur justo ut sagittis. Duis dignissim tincidunt quam, nec pulvinar libero luctus nec. Morbi blandit nec lorem in ullamcorper. Vestibulum et odio massa. Integer at odio ipsum. Proin vitae tristique nibh. Aenean semper ante sit amet ante ultricies tincidunt. Curabitur cursus, urna non ultricies posuere, dolor lacus cursus lorem, a dapibus nibh ex eget sem. Aliquam semper sagittis sapien a fermentum. Nullam sed iaculis lacus, et imperdiet risus. Praesent quis turpis ac nunc sodales tincidunt. Aliquam at leo odio. Sed a tempor nisl, et mattis felis. Nam mauris nunc, commodo ac orci ut, auctor viverra mauris. Quisque nec justo vitae metus consectetur ultrices. Duis venenatis lorem massa, eu pulvinar quam faucibus sed. Nulla fringilla lorem sit amet sagittis mattis. Nunc in leo a odio mollis consectetur. Etiam ac nisl eget diam ullamcorper porta. Aliquam consectetur neque eget metus egestas sollicitudin. Curabitur ultrices urna et feugiat malesuada. Nulla facilisi. Fusce sed dapibus leo, eu lobortis ante. Duis luctus mauris in ante semper, ut feugiat nisi condimentum. Nullam a odio et justo suscipit tempus. Vestibulum placerat dapibus quam, a egestas turpis efficitur id. Integer suscipit placerat placerat. Phasellus in lorem quis leo egestas accumsan. Nam et euismod ligula. Duis nec erat aliquam, sollicitudin diam non, ornare leo. Pellentesque augue leo, faucibus in nunc nec, tincidunt ullamcorper tortor. Phasellus aliquam condimentum elit. Nulla facilisi. Donec magna libero, bibendum eu faucibus et, mattis at felis. Integer turpis nibh, blandit nec elit vel, euismod laoreet quam. Donec vel ante nisi. Nunc luctus a tellus non.'
    }

const comments = [
    {
        "id" : "",
        "rating" : "1",
        "name" : "Maniruzzaman Akash",
        "comment" : "Lorem Ipsum is simply dummy text of the pr make but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
    },
    {
        "id" : "",
        "rating" : "2",
        "name" : "Maniruzzaman Akash",
        "comment" : "Lorem Ipsum is simply dummy text of the pr make but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
    },
    {
        "id" : "",
        "rating" : "3",
        "name" : "Maniruzzaman Akash",
        "comment" : "Lorem Ipsum is simply dummy text of the pr make but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
    },
    {
        "id" : "",
        "rating" : "4",
        "name" : "Maniruzzaman Akash",
        "comment" : "Lorem Ipsum is simply dummy text of the pr make but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
    },
    {
        "id" : "",
        "rating" : "5",
        "name" : "Maniruzzaman Akash",
        "comment" : "Lorem Ipsum is simply dummy text of the pr make but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
    }

]


const SingleMoviePage = (Figure, PlotSummary, PlotSynopsis) =>
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
                                    initialRating={"5"}
                                    emptySymbol={ <img src="/assets/images/star-grey.png" className="rating" alt="#" /> }
                                    fullSymbol={ <img src="/assets/images/star-yellow.png" className="rating" alt="#" /> }
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
            <hr /><ReviewingForm />
            <hr /><CommentsSection comments={comments} />
        </div>
    </div>


export default function () {
    return SingleMoviePage(Figure, PlotSummary, PlotSynopsis);
}
