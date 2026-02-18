const inputText = document.getElementById(`text`);
const select = document.getElementById(`typeText`);
const searchBar = document.getElementById(`searchInput`);
const searchResults = document.getElementById(`searchResults`);

let selectPreviousValue = select.value;
let gameData = null;


// --- funçöes relacionadas a placeholder --- //
let artists = [`Travis Scott...`, `Imagine Dragons...`, `The Weekend...`];
let album = [`AstroWorld...`, `Evolve...`, `After Hours...`];
let time;

setInterval(changePlaceholder, 3000);

function changePlaceholder(){
    let placeholder = inputText.placeholder;
        switch (select.value) {
            case `artist`:
                if(placeholder !== ``) artists.push(placeholder);
                inputText.placeholder = artists.shift();
                break;
        
            case `album`:
                if(placeholder !== ``) album.push(placeholder);
                inputText.placeholder = album.shift();
                break;
    }
}

select.addEventListener(`change`, function(){
    inputText.dispatchEvent(new Event(`input`));

    switch (selectPreviousValue){
        case `artist`:
            artists.push(inputText.placeholder);
            break;
        case `album`:
            album.push(inputText.placeholder);
            break;
    }

    changePlaceholder();
    selectPreviousValue = select.value;
});



// --- funções relacionadas com botões --- //
searchResults.addEventListener(`click`, function (event){
    const button = event.target.closest(`button`);
    if (!button) return;

    searchBar.innerHTML = `
        <img src="${button.getAttribute("picture")}">
        ${button.getAttribute("name")}
        <button id="clearButton"></button>
        <button id="startButton"></button>
    `;

    gameData = [button.getAttribute("id"), button.getAttribute("picture"), button.getAttribute("name")];
});

searchBar.addEventListener("click", function(event) {
    if (event.target.id === "clearButton") {
        searchBar.innerHTML = `
            <select id="typeText">
                <option value="artist">Artista</option>
                <option value="album">Álbum</option>
            </select>
            <input type="text" id="text" placeholder="">
            <button id="startButton"></button>
        `;
        gameData = null;
    }

    if (event.target.id === "startButton") {
        if (!gameData) return;
        console.log(gameData);
    }
});



// --- funções relacionadas a pesquisa da api --- //
inputText.addEventListener(`input`, async function() {
    const text = inputText.value;
    clearTimeout(time);
    if(text.length > 2){
        time = setTimeout(search, 500);
    }else{
        document.getElementById(`searchResults`).style.display = 'none';
    }
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
    
    const searchList = document.getElementById(`searchResults`);
    searchList.style.display = 'block';
    if(text !== inputText.value) return;
    if(response.status === `FOUND`){
        let lista = ``;

        response.results.forEach(artist => {
            lista += 
                    `<li>
                        <button id="${artist.id}" picture="${artist.picture}" name="${artist.name}">
                            <img src="${artist.picture}">
                            ${artist.name}
                        </button>
                    </li>`
        });

        searchList.innerHTML = lista;
        return;
    }
    searchList.innerHTML = `<li style="text-align: center; border-bottom: 0; margin-bottom: 0; padding-bottom: 0;">Nenhum resultado encontrado</li>`;
}