<#import "parts/common.ftlh" as c>
<#include "parts/navbar.ftlh">
<@c.page>
    <div class="container">
        <h1>EDIT USER PAGE</h1>
        <h6>${adminName}</h6>
        <form class="form-signin col-4 mx-auto" method="post">
            <h1 class="h3 mb-3 font-weight-normal">Please add user information</h1>
            <label for="inputEmail" class="sr-only">Username</label>
            <input type="text" class="form-control" name="username" disabled="" value="${username}" required="" autofocus="">
            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="email" class="form-control mt-2" name="email" value="${email!''}" required="" autofocus="">
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" name="password" class="form-control my-2" placeholder="Password"  required="">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Save"/>
        </form>
    </div>
</@c.page>