<#import "parts/common.ftlh" as c>
<#include "parts/navbar.ftlh">
<@c.page>
    <div class="container">
        <h1>USERS LIST PAGE</h1>
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Role</th>
                <th scope="col">Handle</th>
            </tr>
            </thead>
            <tbody>
            <#list users as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td><#list user.roles as role>${role}<#sep>, </#list></td>
                    <td>
                        <#if user.id != 1>
                            <a href="/user/${user.id}">EDIT</a>
                        </#if>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>