const inputText = document.getElementById(`text`);
const select = document.getElementById(`typeText`);
let time

inputText.addEventListener(`input`, async function() {
    const text = inputText.value;
    clearTimeout(time);
    if(text.length > 2){
        time = setTimeout(search, 500);
    }else{
        document.getElementById(`searchResults`).style.display = 'none';
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
    
    const searchList = document.getElementById(`searchResults`);
    searchList.style.display = 'block';
    if(text !== inputText.value) return;
    if(response.status === `FOUND`){
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
    searchList.innerHTML = `<li style="text-align: center; border-bottom: 0; margin-bottom: 0; padding-bottom: 0;">Nenhum resultado encontrado</li>`;
}