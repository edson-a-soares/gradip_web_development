import React from 'react';

const Brand = ({ info }) =>
    <div id="branding">
        <img src={info.image} alt="#" className="logo" />
        <div className="logo-copy">
            <h1 className="site-title">{info.company}</h1>
            <small className="site-description">{info.description}</small>
        </div>
    </div>

const info = {
        "image" : "/assets/images/logo.png",
        "company" : "Company Name",
        "description" : "Tagline goes here"
    };

const Header = (Brand) =>
    <header className="site-header">
        <div className="container">
            <Brand info={info} />
        </div>
    </header>


export default function () {
    return Header(Brand);
};
