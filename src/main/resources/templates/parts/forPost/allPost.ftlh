<#import "../pager.ftlh" as p>
<@p.pager url page/>
<div class="card-columns">
    <#list page.content as post>
        <div class="card my-3" style="width: 18rem;">
            <#list post.filesById as file>
                <#if file.fileType == 2 && file.queue == 1>
                    <img src="/img/${file.fileName}" class="card-img-top" alt="${file.fileName}">
                </#if>
            </#list>
            <div class="card-body">
                <h5 class="card-title">${post.header}</h5>
                <p class="card-text">${post.date}</p>
                <p class="card-text">${post.teamByTeamId.teamName}</p>
                <p class="card-text">${post.categorieByCatId.catName}</p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">${post.userByAuthorId.name}  ${post.userByAuthorId.surname}</li>
            </ul>
            <div class="card-body text-center">
                <a href="/team/${teamIdOfCurrentAdmin}/post/${post.id}/info" class="card-link">ƏTRAFLI</a>
                <#if adminId==post.userId || isLeader==true ||isAdmin==true>
                    <a href="/team/${teamIdOfCurrentAdmin}/post/${post.id}/update" class="card-link">DƏYİŞİKLİK
                        ET</a>
                </#if>
            </div>
        </div>
    <#else>
        <h3>Paylaşım Yoxdur</h3>
    </#list>
</div>
<@p.pager url page/>
