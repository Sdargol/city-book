const host = "http://localhost:8080"

export const getAllCities = () => {
    fetch(host + '/api/v1/cities',
        {
            method: "GET",
            headers: { 'Content-Type': 'application/json;charset=utf-8' }
        })
        .then(response => response.json())
        .then(data => {
            console.log(data);  
        })
        .catch(e => console.log(e));
}

export const getAllSortedCities = () => {
    fetch(host + '/api/v1/cities/sorted',
        {
            method: "GET",
            headers: { 'Content-Type': 'application/json;charset=utf-8' }
        })
        .then(response => response.json())
        .then(data => {
            console.log(data);  
        })
        .catch(e => console.log(e));
}

export const getAllSortedDistrictNameCities = () => {
    fetch(host + '/api/v1/cities/sorted-district-name',
        {
            method: "GET",
            headers: { 'Content-Type': 'application/json;charset=utf-8' }
        })
        .then(response => response.json())
        .then(data => {
            console.log(data);  
        })
        .catch(e => console.log(e)); 
}

export const getMaxPopulationCity = () => {
    fetch(host + '/api/v1/cities/max-population',
        {
            method: "GET",
            headers: { 'Content-Type': 'application/json;charset=utf-8' }
        })
        .then(response => response.json())
        .then(data => {
            console.log(data);  
        })
        .catch(e => console.log(e));
}

export const getPopulationRegion = () => {
    fetch(host + '/api/v1/cities/population-region',
        {
            method: "GET",
            headers: { 'Content-Type': 'application/json;charset=utf-8' }
        })
        .then(response => response.json())
        .then(data => {
            console.log(data);  
        })
        .catch(e => console.log(e));
}