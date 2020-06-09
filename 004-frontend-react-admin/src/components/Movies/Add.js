import React, {useState} from 'react';
import CastComponent from "./CastComponent";
import CrewComponent from "./CrewComponent";
import Categories from "../Categories/Categories";
import MoviesRepository from "./MoviesRepository";

const Add = () => {

    const [data, setData] = useState({
        title : "",
        length : "",
        description : "",
        release_year : "",
        plot_summary : "",
        plot_synopsis : "",
        cast: [],
        crew: [],
        categories: []
    });

    const handleSubmit = event => {
        event.preventDefault();
        console.log('Adding a new movie ...');
        console.log(data);

        MoviesRepository.add(response => {
            console.log('Response ...');
            console.log(response);
        }, data);
    }

    const setCrew = (crew) =>
        data.crew = crew;

    const setCast = (cast) =>
        data.cast = cast;

    const setCategories = (categories) =>
        data.categories = categories;

    const handleChanges = (key, value) =>
        setData({...data, [key]: value});

    return <form onSubmit={handleSubmit}>
        <div className="form-row">
            <div className="form-group col-md-6">
                <label htmlFor="title">Title</label>
                <input
                    id="title"
                    type="text"
                    value={data.title}
                    className="form-control"
                    placeholder="Type the movie title"
                    onChange={e => handleChanges("title", e.target.value)}
                />
            </div>
            <div className="form-group col-md-4">
                <Categories onSelect={setCategories}/>
            </div>
            <div className="form-group col-md-2">
                <label htmlFor="length">Length</label>
                <input
                    id="length"
                    type="text"
                    value={data.length}
                    className="form-control"
                    placeholder="Time in minutes."
                    onChange={e => handleChanges("length", e.target.value)}
                />
            </div>
        </div>
        <div className="form-row">
            <div className="form-group col-md-6">
                <label htmlFor="summary">Summary</label>
                <textarea
                    rows="5"
                    id="summary"
                    className="form-control"
                    value={data.plot_summary}
                    placeholder="Write the summary of the movie page."
                    onChange={e => handleChanges("plot_summary", e.target.value)}>
                </textarea>
            </div>
            <div className="form-group col-md-4">
                <label htmlFor="description">Description</label>
                <textarea
                    rows="5"
                    id="description"
                    value={data.description}
                    className="form-control"
                    placeholder="Add a short description to the movie."
                    onChange={e => handleChanges("description", e.target.value)}>
                </textarea>
            </div>
            <div className="form-group col-md-2">
                <label htmlFor="release_year">Release Year</label>
                <input
                    id="release_year"
                    type="text"
                    value={data.release_year}
                    className="form-control"
                    placeholder="0000"
                    onChange={e => handleChanges("release_year", e.target.value)}
                />
            </div>
        </div>
        <div className="form-group">
            <label htmlFor="synopsis">Synopsis</label>
            <textarea
                rows="5"
                id="synopsis"
                className="form-control"
                value={data.plot_synopsis}
                placeholder="Write the main text of the movie page."
                onChange={e => handleChanges("plot_synopsis", e.target.value)}>
            </textarea>
        </div>
        <div className="form-row">
            <div className="form-group col-md-6">
                <label htmlFor="input_synopsis">Cast</label>
                <CastComponent onChange={setCast} />
            </div>
            <div className="form-group col-md-6">
                <label htmlFor="input_synopsis">Crew</label>
                <CrewComponent onChange={setCrew} />
            </div>
        </div>
        <div className="form-group">
            <button type="submit" className="btn btn-primary float-md-right">Add Movie</button>
        </div>
    </form>

}

export default Add;
