import Rating from "react-rating";
import React, {useState} from 'react';
import ReviewsRepository from "./ReviewsRepository";

const ReviewingForm = ({movieId}) => {

    const [review, setReview] = useState({
        reviewerName: "",
        rating: "",
        comment: ""
    });

    const handleSubmit = event => {
        event.preventDefault();
        ReviewsRepository.add(
            response => {
                if (response.hasOwnProperty('rating'))
                    window.location.reload();
            },
            {
                "movieId" : movieId,
                "payload" : review
            }
        )
    }

    const handleOnChange = (key, value) =>
        setReview({ ...review, [key]: value });

    return <div className="row">
        <div className="col-md-6"/>
        <div className="col-md-6">
            <div className="card card-6">
                <div className="card-heading">
                    <h2 className="title">Add a review</h2>
                </div>
                <form onSubmit={handleSubmit}>
                    <div className="card-body">
                            <div className="form-row">
                                <div className="name">Rating</div>
                                <div className="value">
                                    <Rating
                                        onChange = {
                                            (rate) => {
                                                if ( rate !== undefined )
                                                    review.rating = rate.toString();
                                            }
                                        }
                                        emptySymbol={<img src="/assets/images/star-empty.png" className="rating" alt="#"/>}
                                        fullSymbol={<img src="/assets/images/star-full.png" className="rating" alt="#"/>}

                                    />
                                </div>
                            </div>
                            <div className="form-row">
                                <div className="name">Full name</div>
                                <div className="value">
                                    <input className="input--style-6" type="text" name="reviewerName"
                                       value={review.reviewerName}
                                       onChange={e => handleOnChange("reviewerName", e.target.value)}
                                    />
                                </div>
                            </div>
                            <div className="form-row">
                                <div className="name">Comment</div>
                                <div className="value">
                                    <div className="input-group js-input-file">
                                        <textarea className="textarea--style-6" name="comment"
                                                  value={review.comment}
                                                  onChange={e => handleOnChange("comment", e.target.value)}
                                                  placeholder="what is your review ?"/>
                                    </div>
                                </div>
                            </div>
                    </div>
                    <div className="card-footer">
                        <button className="btn btn--radius-2 btn--blue-2" type="submit">Comment</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

}

export default function ({movieId}) {
    return ReviewingForm({movieId});
}
