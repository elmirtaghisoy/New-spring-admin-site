<#include "security.ftlh">
<#import 'logout.ftlh' as l>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Starter Spring Security</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/main">Main</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user/profile">My Account</a>
            </li>
            <#if isAdmin>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        User
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/user">User List</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/registration">Add User</a>
                    </div>
                </li>
            </#if>
        </ul>
        <div class="navbar-text mr-2">
            ${adminName}
        </div>
        <@l.logout />
    </div>
</nav>