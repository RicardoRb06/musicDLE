const inputText = document.getElementById(`text`);
const select = document.getElementById(`typeText`);
let time

inputText.addEventListener(`input`, async function() {
    const text = inputText.value;
    clearTimeout(time);
    if(text.length > 2){
        time = setTimeout(search, 500);
    }else{
        document.getElementById(`searchResults`).innerHTML = ``;
    }
});

select.addEventListener(`change`, function(){
    inputText.dispatchEvent(new Event(`input`));
});


async function search(){
    const text = inputText.value;
    const type = select.value;
    let url = `api/`;

    
    switch (type) {
        case `artist`:
            url += `searchArtist` 
            break;
    }
        

    const res = await fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            text: text
        })
    });
    const response = await res.json();
    console.log(response)

    if(text !== inputText.value) return;
    if(response.status === `FOUND`){
        const searchList = document.getElementById(`searchResults`);
        let lista = ``;

        response.results.forEach(artist => {
            lista += 
                    `<li>
                        <button value="${artist.id}">
                            <img src="${artist.picture}">
                            ${artist.name}
                        </button>
                    </li>`
        });

        searchList.innerHTML = lista;
        return;
    }
    document.getElementById(`searchResults`).innerHTML = `Nenhum resultado encontrado`;
}