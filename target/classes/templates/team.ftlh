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
            <#if isAdmin==true>
                <div class="row mt-3">
                    <div class="col-12">
                        <button type="button" class="btn btn-success" data-toggle="modal"
                                data-target=".bd-example-modal-xl">
                            Əlavə et
                        </button>
                    </div>
                </div>
            </#if>
            <div class="row mt-3">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Koordinatorluq</th>
                        <th scope="col">Üzv</th>
                        <th scope="col">Paylaşım</th>
                        <th scope="col">Layihə</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list team as teamInfo>
                        <tr>
                            <th scope="row">${teamInfo.id}</th>
                            <td>${teamInfo.teamName}</td>
                            <td>${teamInfo.userCount}</td>
                            <td>${teamInfo.postCount}</td>
                            <td>${teamInfo.projectCount}</td>
                            <td>
                                <a href="/team/${teamInfo.id}">
                                    <button type="button" class="btn btn-success"><i class="fas fa-info"></i></button>
                                </a>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</@c.page>
<#include "parts/forTeam/teamAdd.ftlh">
