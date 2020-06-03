<#import "../pager.ftlh" as p>
<@p.pager url page/>
<div class="row mt-3">
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Ad</th>
            <th scope="col">Soyad</th>
            <th scope="col">Əlaqə Nömrəsi</th>
            <th scope="col">Email</th>
            <th scope="col">Dərəcə</th>
            <th scope="col"></th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list page.content as user>
            <#if user.active == true>
                <tr>
            <#elseif user.active == false>
                <tr style="background-color: #ff8684">
            </#if>
            <th scope="row">${user.id}</th>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.phone}</td>
            <td>${user.email}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td>
                <a href="/team/${user.teamId}/${"info"}/user/${user.id}">
                    <button type="button" class="btn btn-success"><i class="fas fa-info"></i></button>
                </a>
            </td>
            <#if url!="/users">
                <#if (isLeader==true || isAdmin==true) && isUser==false  && teamIdOfCurrentAdmin==teamId>
                    <td>
                        <a href="/team/${user.teamId}/${"update"}/user/${user.id}">
                            <button type="button" class="btn btn-warning"><i style="color: white"
                                                                             class="far fa-edit"></i></button>
                        </a>
                    </td>
                </#if>
                <#if (isLeader==true || isUser==false) && isAdmin==true && teamIdOfCurrentAdmin==teamId && !(isAdmin==true && adminId==user.id)>
                    <#if user.active==true>
                        <td>
                            <form method="post" action="/team/${user.teamId}/deactive/user/${user.id}">
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                <button type="submit" class="btn btn-danger"><i class="far fa-trash-alt"></i>
                                </button>
                            </form>
                        </td>

                    <#else>
                        <td>
                            <form method="post" action="/team/${user.teamId}/activate/user/${user.id}">
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                <button type="submit" class="btn btn-success"><i
                                            class="far fa-check-square"></i>
                                </button>
                            </form>
                        </td>
                    </#if>
                </#if>
            <#else>
                <#if isAdmin==true>
                    <td>
                        <a href="/users/user/${user.id}/profile">
                            <button type="submit" style="color: white" class="btn btn-warning"><i
                                        class="fas fa-sync"></i></button>
                        </a>
                    </td>
                </#if>
            </#if>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
<@p.pager url page/>