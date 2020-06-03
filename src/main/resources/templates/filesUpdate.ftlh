<#import "parts/common.ftlh" as c>
<#import "parts/logout.ftlh" as l>
<@c.page>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/team/${teamId}/post/${postId}/update">
            <button class="btn btn-danger">GERİ</button>
        </a>
    </nav>
    <div class="container">
        <div class="row mt-3">
            <#include "parts/forResponse/response.ftlh">
        </div>
        <div class="row mt-3">
            <#include "parts/forFiles/allFile.ftlh">
        </div>
        <div class="row mt-3">
            <#include "parts/forFiles/updateFile.ftlh">
        </div>
    </div>
</@c.page>
