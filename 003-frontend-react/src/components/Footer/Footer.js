import React from 'react';

const info = {
        "copyright" : "Copyright 2020. All rights reserved"
    };

const Footer = () =>
    <footer className="site-footer">
        <div className="container">
            <div className="colophon">{info.copyright}</div>
        </div>
    </footer>


export default function () {
    return Footer();
};
