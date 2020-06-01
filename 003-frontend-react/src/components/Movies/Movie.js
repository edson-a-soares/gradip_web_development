import React from 'react';

const Image = ({ file }) =>
    <img src={file} alt="#" />


const Title = ({ text, address }) =>
    <div className="movie-title">
        <a href={`http://${address}`}>{text}</a>
    </div>

const MovieCard = (Icon, HyperTitle, { info }) =>
      <div className="movie">
          <figure className="movie-poster">
              <Icon file={"/assets/images/thumb.jpg"} />
          </figure>
          <HyperTitle text={info.text} link={info.link} />
          <p>{info.description}</p>
      </div>

export default function({ info }) {
  return MovieCard(Image, Title, {info});
};
