import React from 'react';
import {
    Route,
    BrowserRouter,
    Switch,
    // useParams
} from 'react-router-dom';
import AddMovie from "../Movies/Add";
import PageNotFound from "./PageNotFound";

const Router = () =>
    <BrowserRouter>
        <Switch>
            <Route exact path="/" >
                <AddMovie />
            </Route>
            <Route path='*' exact>
                <PageNotFound />
            </Route>
        </Switch>
    </BrowserRouter>

/*
const SingleMoviePageWrapper = () => {
    const { id } = useParams();
    return <SingleMoviePage movieId={id} />
}
*/

export default Router;
