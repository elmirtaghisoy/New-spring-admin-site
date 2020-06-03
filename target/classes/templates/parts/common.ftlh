<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <title>ColorBrain Admin</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <base href="/">
        <!-- My CSS -->
        <link rel="stylesheet" type="text/css" href="/static/Admin-Resources/css/style.css">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
              integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
              crossorigin="anonymous"/>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
                integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
                crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
                integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
                crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
                integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
                crossorigin="anonymous"></script>
        <#--ReCaptcha-->
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <#--Font Awesome-->
        <script src="https://kit.fontawesome.com/506c18375d.js" crossorigin="anonymous"></script>

        <#--CK Editor-->
        <script type="text/javascript" src="/static/Admin-Resources/ckeditor/ckeditor.js"></script>

    </head>
    <body>
    <div class="d-flex" id="wrapper">
        <#nested>
    </div>

    <#--My Javascript-->
    <script type="text/javascript" src="/static/Admin-Resources/js/admin.js"></script>
    <#--My jQuerry-->
    <script type="text/javascript" src="/static/jQuerry/jquery-3.4.1.js"></script>
    </body>
    </html>
</#macro>