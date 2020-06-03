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
    <#include "parts/forTeam/teamNavbar.ftlh">
    <div class="container">
        <div class="row mt-3">
            <div class="col-12">
                <h1 class="text-center">${post.header}</h1>
            </div>
        </div>
        <form action="/team/${teamIdOfCurrentAdmin}/post/${post.id}/update" method="post"
              enctype="multipart/form-data">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="hidden" name="id" value="${post.id}">
            <div class="form-group">
                <label for="exampleFormControlInput1">Başlıq</label>
                <input required type="text" name="header" value="${post.header}" class="form-control">
            </div>
            <div class="form-group">
                <label for="exampleFormControlTextarea1">İçərik</label>
                <textarea required name="context" class="form-control" rows="3">${post.context}</textarea>
            </div>
            <select name="catId" class="custom-select">
                <option selected value="${post.categorieByCatId.id}">
                    ${post.categorieByCatId.catName}
                </option>
                <option disabled><b>#DİGƏR KATEQORİYALAR#</b></option>
                <#list categories as category>
                    <option value="${category.id}">
                        ${category.catName}
                    </option>
                </#list>
            </select>
            <select name="userId" class="custom-select mt-3">
                <option selected value="${post.userByAuthorId.id}">
                    ${post.userByAuthorId.name} ${post.userByAuthorId.surname}
                </option>
                <option disabled><b>#DİGƏR ÜZVLƏR#</b></option>
                <#list users as user>
                    <option value="${user.id}">${user.name} ${user.surname}</option>
                </#list>
            </select>
            <a href="/files/update/${post.id}">
                <button type="button" class="btn btn-warning mt-3">FAYLLAR</button>
            </a>
            <button type="submit" class="btn btn-success mt-3">YADDA SAXLA</button>
        </form>
    </div>
    </@c.page>
