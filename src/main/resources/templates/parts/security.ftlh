<#assign
know = Session.SPRING_SECURITY_CONTEXT??
>

<#if know>
    <#assign
    adminUser = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    <#--Informations-->
    adminInfo = adminUser.getName() +" " + adminUser.getSurname()
    adminId = adminUser.getAdminId()
    adminName = adminUser.getUsername()
    <#--Users-->
    isAdmin = adminUser.isAdmin()
    isLeader = adminUser.isLeader()
    isUser = adminUser.isUser()
    <#--Ides-->
    teamIdOfCurrentAdmin = adminUser.getTeamId()
    >
<#else>
    <#assign
    isAdmin = false
    isUser = false
    isLeader = false
    adminId = null
    >
</#if>