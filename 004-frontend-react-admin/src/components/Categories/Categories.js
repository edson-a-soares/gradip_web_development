import React, {useEffect, useState} from 'react';
import CategoriesRepository from "./CategoriesRepository";

const Categories = (params) => {

    const [categories, setCategories]   = useState([]);
    const [error, setError]             = useState(null);
    const [isLoading, setLoading]       = useState(false);

    useEffect(() => {
        CategoriesRepository.all(setCategories, setError, setLoading);
    }, []);

    const handleSelect = event => {
        event.preventDefault();
        const selected          = [];
        const selectedOptions   = event.target.selectedOptions;

        for (const option of selectedOptions)
            selected.push({"id" : option.value, "name": option.text});

        params.onSelect(selected);
    }

    return <div>
        <label htmlFor="input_categories">Categories</label>
        <select multiple={true} className="custom-select" id="input_categories" onChange={event => handleSelect(event)}>
            {
                error ? 'Refresh the page, please.'  :
                    isLoading ? 'Loading categories ...' :
                        categories.map(option => <option key={option.id} value={option.id}>{option.name}</option>)
            }
        </select>
    </div>

}

export default function (params) {
    return Categories(params);
}
