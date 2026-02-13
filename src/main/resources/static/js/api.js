async function submit(){
    const text = document.getElementById(`text`).value;
    const type = document.getElementById(`typeText`).value;
    let url = `api/`;

    switch (type) {
        case `artist`:
            url += `searchArtist` 
            break;
    }

    const response = await fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            text: text
        })
    }).then(res => res.json());
    console.log(response)

    if(response.status === `FOUND`){
        const searchList = document.getElementById(`searchResults`);
        let lista = ``;

        response.results.forEach(artist => {
            lista += 
                    `<li>
                        <button>
                            <img src="${artist.picture}">
                            ${artist.name}
                        </button>
                    </li>`
        });

        searchList.innerHTML = lista;
    }
    if(response.status === `NOT_FOUND`){
        const searchList = document.getElementById(`searchResults`).innerHTML = `Nenhum resultado encontrado`;
    }
}