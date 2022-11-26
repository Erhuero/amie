import fetch from 'unfetch';

const checkStatus = response => {
    if (response.ok) {
        return response;
    }
    // convert non-2xx HTTP responses into errors:
    const error = new Error(response.statusText);
    error.response = response;
    return Promise.reject(error);
}

export const getAllEmployee = () =>
    fetch("getallemployees")
        .then(checkStatus);

export const deleteEmployee = employeeId =>
    fetch(`"removeemployee/${employeeId}"`, {
        method: 'DELETE'
    }).then(checkStatus);

export const addNewEmployee = employee =>
    fetch("addemployee", {
        headers: {
            'Content-Type': 'application/json'
            },
            method: 'POST',
            body: JSON.stringify(employee)
        }
    );
