const apiUrl = "/api"

function submit(){
    const text = document.getElementById(`text`).value;

    fetch(apiUrl, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            text: text
        })
    })
}