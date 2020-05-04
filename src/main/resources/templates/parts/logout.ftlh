<#macro logout>
    <form class="mb-2 mt-2" action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input class="btn btn-danger" type="submit" value="Sign Out"/>
    </form>
</#macro>