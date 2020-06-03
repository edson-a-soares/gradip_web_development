import React from 'react';
import Header from './Header';
import Footer from './Footer';
import MoviesCardsList from "../Movies";
import MoviesSinglePage from "../Movies/SingleMoviePage";

const SiteIndexPage = () =>
    <div>
        <Header />
        <main className="main-content">
            <div className="container">
                <div className="page">
                    <MoviesSinglePage />
                </div>
            </div>
        </main>
        <Footer />
    </div>

export default SiteIndexPage;
