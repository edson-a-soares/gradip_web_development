import React from 'react';
import {
    Route,
    Link,
    BrowserRouter as Router,
    Switch
} from 'react-router-dom';
import SingleMoviePage from '../Movies/SingleMoviePage'


const Image = ({ file }) =>
    <figure className="movie-poster">
        <img src={file} alt="#" />
    </figure>


const HyperTitle = ({ text, link }) =>
    <div className="movie-title">
        <Link to={link}>{text}</Link>
    </div>


const MovieCard = (Icon, HyperTitle, { info }) =>
    <div className="movie">
        <Icon file={"/assets/images/thumb.jpg"} />
        <Router>
            <HyperTitle text={info.text} link={`/movies/${info.id}`} />
            <Switch>
                <Route path="/movies/:id" >
                    <SingleMoviePage />
                </Route>
            </Switch>
        </Router>
        <p>{info.description}</p>
    </div>


export default function({ info }) {
  return MovieCard(Image, HyperTitle, {info});
};
