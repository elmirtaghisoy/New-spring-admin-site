<#import "parts/common.ftlh" as c>
<#include "parts/navbar.ftlh">
<@c.page>
    <div class="container">
        <h1>USER EDITOR</h1>
        <form action="/user" method="post">
            <div class="form-group">
                <label for="formGroupExampleInput">Username</label>
                <input type="text" class="form-control" name="username" id="formGroupExampleInput"
                       value="${user.username}">
            </div>
            <div class="form-group">
                <#list roles as role>
                    <label>
                        <input name="${role}" ${user.roles?seq_contains(role)?string("checked", "")} type="checkbox"
                               class="form-control">
                        ${role}
                    </label>
                </#list>
            </div>
            <input type="hidden" value="${user.id}" name="userId">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button class="btn btn-primary" type="submit">Save</button>
        </form>
    </div>
</@c.page>