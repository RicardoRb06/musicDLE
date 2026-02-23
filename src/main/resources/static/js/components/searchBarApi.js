const apiEndPoint = "search/";

export async function search(type, text){
    const url = apiEndPoint + type;
    const res = await fetch(url, jsonCreate(text));
    return await res.json();
}

function jsonCreate(data){
    return {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            text: data
        })
    };
}