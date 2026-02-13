const apiUrl = "/api"

async function submit(){
    const text = document.getElementById(`text`).value;

    const response = await fetch("api/searchArtist", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            text: text
        })
    }).then(res => res.json())

    console.log(response)
}