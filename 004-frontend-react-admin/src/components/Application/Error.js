import React from 'react';

const Error = (props) => {
    const { message } = props;
    return (
        <h3>
            {message}
        </h3>
    );
}

export default Error;
