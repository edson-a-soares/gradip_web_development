import React, {Fragment, useState} from 'react';


const Autocomplete = ({handlers, options}) => {

    const [searchResults, setSearchResult]  = useState({
        // The active selection's index
        activeSuggestion: 0,
        // The suggestions that match the user's input
        filteredSuggestions: [],
        // Whether or not the suggestion list is shown
        showSuggestions: false,
        // What the user has entered
        userInput: ""
    });

    const filterSuggestions = value => {
        const inputValue = value.trim().toLowerCase();
        const inputLength = inputValue.length;

        const found = options.filter(item => {
            return item.name.toLowerCase().slice(0, inputLength) === inputValue;
        })

        return inputLength === 0 ? [] : found;
    }

    const onChange = event => {
        event.preventDefault();
        setSearchResult(
            {
                // The active selection's index
                activeSuggestion: 0,
                // The suggestions that match the user's input
                filteredSuggestions: filterSuggestions(event.target.value),
                // Whether or not the suggestion list is shown
                showSuggestions: true,
                // What the user has entered
                userInput: event.target.value
            }
        );
    }

    const onClick = event => {
        event.preventDefault();
        setSearchResult({
            activeSuggestion: 0,
            filteredSuggestions: [],
            showSuggestions: false,
            userInput: event.currentTarget.innerText
        })

        handlers.onInputChange(event.target.id, event.currentTarget.innerText);
    }

    const onKeyDown = event => {
        /*
        // User pressed the enter key.
        // Update the input and close the suggestions
        if (event.keyCode === 13) {
            const item = searchResults.filteredSuggestions[searchResults.activeSuggestion];
            setSearchResult({
                activeSuggestion: 0,
                filteredSuggestions: [],
                showSuggestions: false,
                userInput: item.name
            })
        }

        // User pressed the up arrow, decrement the index
        else if (event.keyCode === 38) {
            if (searchResults.activeSuggestion === 0)
                return;

            const result = searchResults;
            result.activeSuggestion = searchResults.activeSuggestion - 1;
            setSearchResult(result);
        }

        // User pressed the down arrow, increment the index
        else if (event.keyCode === 40) {
            if (searchResults.activeSuggestion - 1 === searchResults.filteredSuggestions.length)
                return;

            const result = searchResults;
            result.activeSuggestion = searchResults.activeSuggestion + 1;
            setSearchResult(result);
        }
        */
    }

    const buildOptionsBox = () => {

        let suggestionsListComponent;
        if (searchResults.showSuggestions && searchResults.userInput) {

            if (searchResults.filteredSuggestions.length) {

                suggestionsListComponent = (
                    <ul className="list-group suggestions position-absolute">
                        {
                            searchResults.filteredSuggestions.map((suggestion, index) => {
                                let className;

                                if (index === searchResults.activeSuggestion)
                                    className = "active";

                                return (
                                    <li id={suggestion.id}
                                        key={suggestion.id}
                                        onClick={event => onClick(event)}
                                        className={`list-group-item ${className}`}
                                    >
                                            {suggestion.name}
                                    </li>
                                );

                            })

                        }
                    </ul>
                );

            } else {
                suggestionsListComponent = (
                    <div className="no-suggestions"></div>
                );
            }

            return suggestionsListComponent;
        }

    }

    return <div>
        {
            <Fragment>
                <input
                    id="0"
                    type="text"
                    required
                    className="form-control"
                    placeholder="Search for ..."
                    value={searchResults.userInput}
                    onChange={event => onChange(event)}
                    onKeyDown={event => onKeyDown(event)}
                    aria-label="Text input with segmented dropdown button"
                />
                { buildOptionsBox() }
            </Fragment>
        }
    </div>

}


export default function ({handlers, options}) {
    return Autocomplete({handlers, options});
}
