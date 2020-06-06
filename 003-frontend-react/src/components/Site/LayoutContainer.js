import React from 'react';
import Header from './Header';
import Footer from './Footer';

const headerInfo = {
        "image" : "/assets/images/logo.png",
        "company" : "Company Name",
        "description" : "Tagline goes here"
    };

const LayoutContainer = ({ component }) =>
    <div id="site-content">
        <Header info={headerInfo} />
        <main className="main-content">
            <div className="container">
                <div className="page">
                    {component}
                </div>
            </div>
        </main>
        <Footer info={'Copyright 2020. All rights reserved'}/>
    </div>


export default LayoutContainer;
