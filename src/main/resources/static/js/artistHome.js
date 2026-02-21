document.querySelectorAll("button").forEach(button => {
    button.addEventListener("click", function() {
        window.location.href = window.location.href + "/" + button.value;
    });
});