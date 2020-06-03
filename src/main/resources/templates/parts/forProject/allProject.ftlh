<#import "../pager.ftlh" as p>
<@p.pager url page/>
<div class="card-columns">
    <#list page.content as project>
        <div class="card" style="width: 18rem;">
            <img src="/img/${project.imgName}" class="card-img-top" alt="${project.imgName}">
            <div class="card-body">
                <h5 class="card-title">${project.header}</h5>
                <p class="card-text">${project.date}</p>
                <#if project.status==1>
                    <p class="card-text">Aktiv deyil</p>
                <#elseif project.status==2>
                    <p class="card-text">Aktivdir</p>
                <#elseif project.status==3>
                    <p class="card-text">Bitib</p>
                </#if>
                <p class="card-text">${project.teamByTeamId.teamName}</p>
                <#assign
                participantList = project.getParticipantStatisticsById()
                countOfParticipants = participantList?size
                >
                <p class="card-text">${countOfParticipants}</p>
            </div>
            <ul class="list-group list-group-flush">
                <#list project.projectCreatorsById as creator>
                    <li class="list-group-item">${creator.userByUserId.name} ${creator.userByUserId.surname}</li>
                </#list>
            </ul>
            <div class="card-body text-center">
                <a href="/team/${teamIdOfCurrentAdmin}/project/${project.id}/info/" class="card-link">ƏTRAFLI</a>
                <#if url!="/project/pending" && url!="/project/online" && url!="/project/finished">
                    <#if (isLeader==true || isAdmin==true ) && isUser==false && teamIdOfCurrentAdmin==teamId>
                        <a href="/team/${teamIdOfCurrentAdmin}/project/${project.id}/update/" class="card-link">DƏYİŞİKLİK
                            ET</a>
                    </#if>
                </#if>
            </div>
        </div>
    </#list>
</div>
<@p.pager url page/>