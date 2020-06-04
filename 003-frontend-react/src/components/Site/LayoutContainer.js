import React from 'react';
import Header from './Header';
import Footer from './Footer';


const LayoutContainer = ({ component }) =>
    <div id="site-content">
        <Header />
        <main className="main-content">
            <div className="container">
                <div className="page">
                    {component}
                </div>
            </div>
        </main>
        <Footer />
    </div>


export default LayoutContainer;
