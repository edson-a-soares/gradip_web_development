import React from 'react';


const Brand = ({ info }) =>
    <div id="branding">
        <img src={info.image} alt="#" className="logo" />
        <div className="logo-copy">
            <h1 className="site-title">{info.company}</h1>
            <small className="site-description">{info.description}</small>
        </div>
    </div>


const Header = (Brand, { info }) =>
    <header className="site-header">
        <div className="container">
            <Brand info={info} />
        </div>
    </header>


export default function ({ info }) {
    return Header(Brand, { info });
};
