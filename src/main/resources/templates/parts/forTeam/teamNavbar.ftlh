<#include "../security.ftlh">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/team/${teamId}/">Koordinatorluq</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/team/${teamId}/users/">Üzvlər</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/team/${teamId}/project/online/">Layihələr</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/team/${teamId}/post/">Paylaşımlar</a>
            </li>
            <#if (isLeader==true || isAdmin==true) && isUser==false  && teamIdOfCurrentAdmin==teamId>
                <li class="nav-item">
                    <a class="nav-link" href="/team/${teamId}/applicants/">Yeni üzvlər</a>
                </li>
            </#if>
        </ul>
    </div>
</nav>