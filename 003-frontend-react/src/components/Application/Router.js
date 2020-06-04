import React from 'react';
import {
    Route,
    BrowserRouter,
    Switch
} from 'react-router-dom';
import MovieCardsList from "../Movies";
import PageNotFound from "../Site/PageNotFound";
import LayoutContainer from "../Site/LayoutContainer";
import SingleMoviePage from "../Movies/SingleMoviePage";


const Router = () =>
    <BrowserRouter>
        <Switch>
            <Route exact path="/" >
                <LayoutContainer component={ <MovieCardsList /> } />
            </Route>
            <Route exact path="/movies/:id" >
                <LayoutContainer component={ <SingleMoviePage /> } />
            </Route>
            <Route path='*' exact>
                <LayoutContainer component={ <PageNotFound /> } />
            </Route>
        </Switch>
    </BrowserRouter>


export default Router;
