<#import "parts/common.ftlh" as c>
<@c.page>
    <#include "parts/navbar.ftlh">
    <div id="page-content-wrapper">
    <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <#--                        <i class="fas fa-ellipsis-v"></i>-->
        <button class="btn btn-primary" id="menu-toggle"><i class="fas fa-bars"></i></button>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                <#--                    <li class="nav-item active">-->
                <#--                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>-->
                <#--                    </li>-->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${adminInfo}
                    </a>
                    <div class="dropdown-menu dropdown-menu-right text-center" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <@l.logout />
                    </div>
                </li>
            </ul>
        </div>
    </nav>
    <div class="container">
        <#include "parts/forResponse/response.ftlh">
        <h1><b>${user.name} ${user.surname}</b> şifrəsinin yenilənməsi</h1>
        <form class="form-signin col-4 mx-auto" action="/users/user/${user.id}/profile" method="post">
            <h1 class="h3 mb-3 font-weight-normal">İstifadəçi məlumatları</h1>
            <label for="inputEmail" class="sr-only">Username</label>
            <input type="text" class="form-control" name="username" disabled value="${user.username}" required=""
                   autofocus="">
            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="email" class="form-control mt-2" name="email" value="${user.email!''}" required=""
                   autofocus="">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input class="btn btn-lg btn-primary btn-block mt-2" type="submit" value="GÖNDƏR"/>
        </form>
    </div>
</@c.page>