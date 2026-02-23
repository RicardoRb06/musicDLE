export function changeSearchBarView(){
    const searchMode = document.getElementById("searchMode");
    const selectedMode = document.getElementById("selectedMode");

    const hidden = getComputedStyle(selectedMode).display === "none";

    selectedMode.style.display = hidden ? "flex" : "none";
    searchMode.style.display = hidden ? "none" : "flex";
}

export function createSelectedMode(gameData){
    document.getElementById(`selectedImg`).setAttribute(`src`, gameData[1]);
    document.getElementById(`selectedName`).textContent = gameData[2];
}

export function createArtistList(response){
    return `<li>
                <button id="${response.id}" picture="${response.picture}" name="${response.name}">
                    <img src="${response.picture}">
                    ${response.name}
                </button>
            </li>`
}

export function createAlbumList(response){
    return `<li>
                <button id="${response.id}" picture="${response.cover}" name="${response.title}">
                    <img src="${response.cover}">
                    ${response.title}
                </button>
            </li>`
}

export function createTrackList(response){
    return `<li>
                <button id="${response.id}" picture="${response.cover}" name="${response.title}">
                    <img src="${response.cover}">
                    ${response.title}
                </button>
            </li>`
}