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
            <th scope="col">Ünvan</th>
            <th scope="col">Tarix</th>
            <th scope="col">Status</th>
            <th scope="col"></th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list page.content as apl>
            <#if apl.status==0>
                <tr style="background-color: #a7ffb4">
            <#elseif apl.status==1>
                <tr style="background-color: #fff07c">
            <#elseif apl.status==2>
                <tr>
            <#elseif apl.status==2>
                <tr style="background-color: #ff8684">
            </#if>
            <th scope="row">${apl.id}</th>
            <td>${apl.name}</td>
            <td>${apl.surname}</td>
            <td>${apl.phone}</td>
            <td>${apl.email}</td>
            <td>${apl.currentAddress}</td>
            <td>${apl.date}</td>
            <#if apl.status==0>
                <td>Yeni</td>
            <#elseif apl.status==1>
                <td>Baxılmış</td>
            <#elseif apl.status==2>
                <td>Aktiv Üzv</td>
            <#elseif apl.status==3>
                <td>Imtina edilmiş</td>
            </#if>
            <td>
                <a>
                    <button type="button" class="btn btn-primary"><i class="fas fa-info"></i>
                    </button>
                </a>
            </td>
            <#if (isLeader==true || isAdmin==true ) && isUser==false && teamIdOfCurrentAdmin==teamId>
                <td>
                    <a>
                        <button type="button" class="btn btn-danger"><i class="fas fa-user-slash"></i>
                        </button>
                    </a>
                </td>
            </#if>
            <#if (isLeader==true || isAdmin==true) && isUser==false  && teamIdOfCurrentAdmin==teamId && apl.status!=2>
                <td>
                    <a href="team/${teamId}/applicant/${apl.id}">
                        <button type="button" class="btn btn-success"><i class="far fa-check-square"></i>
                        </button>
                    </a>
                </td>
            </#if>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
<@p.pager url page/>