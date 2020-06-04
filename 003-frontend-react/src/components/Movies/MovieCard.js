import React from 'react';
import {
    BrowserRouter as Router,
} from 'react-router-dom';


const Image = ({ file }) =>
    <figure className="movie-poster">
        <img src={file} alt="#" />
    </figure>


const HyperTitle = ({ text, link }) =>
    <div className="movie-title">
        <a href={link}>{text}</a>
    </div>

const MovieCard = (Icon, HyperTitle, { info }) =>
    <div className="movie">
        <Icon file={"/assets/images/thumb.jpg"} />
        <Router>
            <HyperTitle text={info.title} link={`/movies/${info.id}`} />
        </Router>
        <p>{info.description}</p>
    </div>


export default function({ info }) {
  return MovieCard(Image, HyperTitle, {info});
};
