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
        <#include "parts/forUser/userNavbar.ftlh">
        <div class="container">
            <#include "parts/forProject/allProject.ftlh">
        </div>
    </div>
</@c.page>
