var voltarPagina = function() {
    window.history.back();
}

$(document).ready(function() {
    $("#backButton").on('click', voltarPagina);

    $(".logo-area").on('click', function() {
        window.location.href = "index.html";
    });
});