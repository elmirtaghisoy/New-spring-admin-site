$("#menu-toggle").click(function (e) {
    e.preventDefault();
    $("#wrapper").toggleClass("toggled");
});

$(document).ready(function () {
    CKEDITOR.replace('context');
    CKEDITOR.replace('teamDesc');
});
