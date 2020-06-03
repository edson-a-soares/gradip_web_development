import React from 'react';
import Rating from "react-rating";


const CommentsSection = ({ comments }) => {
    return <p>
    {
        comments.map((review, index) => {
            return <div className="row align-items-center">
                <div className="col-md-2"></div>
                <div className="col-md-10">
                    <p>
                        <span className="float-left"><strong>{review.name}</strong></span>
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
    </p>
}

export default function({ comments }) {
  return CommentsSection({ comments });
};
