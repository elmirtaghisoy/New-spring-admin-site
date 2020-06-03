<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="container">
        <h1>LOGIN PAGE</h1>
        <#include "parts/forResponse/response.ftlh">
        <#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>
            <div class="alert alert-danger" role="alert">
                ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
            </div>
        </#if>
        <#if message??>
            <div class="alert alert-${messageType}" role="alert">
                ${message}
            </div>
        </#if>
        <form class="form-signin col-4 mx-auto" action="/login" method="post">
            <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
            <label for="inputEmail" class="sr-only">Username</label>
            <input type="text" class="form-control ${(usernameError??)?string('is-invalid', '')}" name="username"
                   placeholder="Username" value="<#if user??>${user.username}</#if>" required="" autofocus="">
            <#if usernameError??>
                <div class="invalid-feedback">
                    ${usernameError}
                </div>
            </#if>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" name="password"
                   class="form-control my-2 ${(passwordError??)?string('is-invalid', '')}"
                   value="<#if user??>${user.username}</#if>" placeholder="Password"
                   required="">
            <#if passwordError??>
                <div class="invalid-feedback">
                    ${passwordError}
                </div>
            </#if>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Sign In"/>
        </form>
    </div>
</@c.page>