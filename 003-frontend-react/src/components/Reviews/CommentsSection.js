import React from 'react';
import Rating from "react-rating";
import Error from "../Common/Error";
import Preloader from "../Common/Preloader";
import useListReviews from "../../hooks/Reviews/useListReviews";


const CommentsSection = ({ movieId }) => {
    const [reviews, isLoading, error] = useListReviews({movieId});
    return <div>
    {
        error ? <Error message={error} /> :
            isLoading ? <Preloader /> :
                reviews.map((review, index) => {
                    return <div key={index} className="row align-items-center">
                        <div className="col-md-2"></div>
                        <div className="col-md-10">
                            <p>
                                <span className="float-left"><strong>{review.reviewerName}</strong></span>
                                <Rating
                                    className="float-right"
                                    readonly
                                    initialRating={review.rating}
                                    emptySymbol={ <img src="/assets/images/star-grey.png" className="rating" alt="#" /> }
                                    fullSymbol={ <img src="/assets/images/star-yellow.png" className="rating" alt="#" /> }
                                />
                            </p>
                            <p>{review.comment}</p>
                        </div>
                    </div>
        })
    }
    </div>

}


export default function({ movieId }) {
  return CommentsSection({ movieId });
};
