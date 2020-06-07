import settings from './settings.json';

const Application = () => {}

Application.getURL = URI => {
    return settings.baseURL + URI;
}

Application.getHeaders = () => {
    return settings.headers
}

export default Application;
