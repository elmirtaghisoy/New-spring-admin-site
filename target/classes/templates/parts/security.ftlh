<#assign
know = Session.SPRING_SECURITY_CONTEXT??
>

<#if know>
    <#assign
    adminUser = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    adminName = adminUser.getUsername()
    isAdmin = adminUser.isAdmin()
    >
<#else>
    <#assign
    isAdmin = false
    >
</#if>