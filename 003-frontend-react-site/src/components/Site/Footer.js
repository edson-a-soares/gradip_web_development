import React from 'react';


const Footer = ({ info }) =>
    <footer className="site-footer">
        <div className="container">
            <div className="colophon">{info.copyright}</div>
        </div>
    </footer>


export default function ({info}) {
    return Footer({info});
};
