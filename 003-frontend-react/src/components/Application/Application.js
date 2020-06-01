import React from 'react';
import Header from '../Header';
import Footer from '../Footer';
import MoviesList from "../Movies";

function Application() {
  return (
      <div>
          <Header />
          <main className="main-content">
              <div className="container">
                  <div className="page">
                      <MoviesList />
                  </div>
              </div>
          </main>
          <Footer />
      </div>
  );
}

export default Application;
