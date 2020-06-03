<div class="jumbotron">
    <#if user.userImg??>
        <div class="row mt-3">
            <div class="text-center col-12">
                <img height="200" width="200" src="/img/${user.userImg}" class="rounded mx-auto d-block" alt="...">
            </div>
        </div>
    </#if>
    <h1 class="display-4 text-center">${user.name} ${user.surname}</h1>
    <#--    <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>-->
    <hr class="my-4">
    <#--    <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>-->
    <div class="col-12 text-center">
        <a href="/team/${teamId}/${"info"}/user/${user.id}">
            <button type="button" class="btn btn-info">Məlumat</button>
        </a>
        <a href="/team/${teamId}/user/${user.id}/post">
            <button type="button" class="btn btn-info">Paylaşımlar: 12</button>
        </a>
        <a href="/team/${teamId}/user/${user.id}/project">
            <button type="button" class="btn btn-info">Layihələr: 3</button>
        </a>
    </div>
</div>