import React from 'react';
import Rating from "react-rating";


const ReviewingForm = () =>
    <div className="row">
        <div className="col-md-6" />
        <div className="col-md-6">
            <div className="card card-6">
                <div className="card-heading">
                    <h2 className="title">Add a review</h2>
                </div>
                <div className="card-body">
                    <form>
                        <div className="form-row">
                            <div className="name">Rating</div>
                            <div className="value">
                                <Rating
                                    name='rating'
                                    emptySymbol={ <img src="/assets/images/star-empty.png" className="rating" alt="#" /> }
                                    fullSymbol={ <img src="/assets/images/star-full.png" className="rating" alt="#" /> }
                                    // onChange={this.handleRatingChange}
                                    // value={this.state.form.facilityRate}
                                />
                            </div>
                        </div>                        <div className="form-row">
                            <div className="name">Full name</div>
                            <div className="value">
                                <input className="input--style-6" type="text" name="full_name" />
                            </div>
                        </div>
                        <div className="form-row">
                            <div className="name">Comment</div>
                            <div className="value">
                                <div className="input-group js-input-file">
                                    <textarea className="textarea--style-6" name="message" placeholder="what is your review ?" />
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div className="card-footer">
                    <button className="btn btn--radius-2 btn--blue-2" type="submit">Comment</button>
                </div>
            </div>
        </div>
    </div>


export default ReviewingForm;
