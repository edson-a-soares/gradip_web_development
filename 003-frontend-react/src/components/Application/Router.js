import React from 'react';
import {
    Route,
    BrowserRouter,
    Switch,
    useParams
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
                <LayoutContainer component={ <SingleMoviePageWrapper /> } />
            </Route>
            <Route path='*' exact>
                <LayoutContainer component={ <PageNotFound /> } />
            </Route>
        </Switch>
    </BrowserRouter>


const SingleMoviePageWrapper = () => {
    const { id } = useParams();
    return <SingleMoviePage movieId={id} />
}

export default Router;
