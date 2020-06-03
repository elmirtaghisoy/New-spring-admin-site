<#import "parts/common.ftlh" as c>
<#import "parts/logout.ftlh" as l>
<#include "parts/security.ftlh">
<@c.page>
    <div class="container mb-5">
        <div class="row mt-3">
            <div class="col-12">
                <h1 class="text-center">${project.header}</h1>
            </div>
        </div>
        <div class="row mt-3">
            <div class="text-center col-12">
                <img src="/img/${project.imgName}" class="img-fluid" alt="Responsive image">
            </div>
        </div>
        <form>
            <div class="form-group">
                <label for="exampleFormControlInput1">Ad</label>
                <input disabled required type="text" name="header" value="${project.header}"
                       class="form-control">
            </div>
            <div class="form-group">
                <label for="exampleFormControlTextarea1">Məlumat</label>
                <textarea disabled required name="context" class="form-control"
                          rows="3">${project.context}</textarea>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput1">Tarix / Saat</label>
                <input disabled required type="datetime-local" name="date" class="form-control"
                       value="${project.date}">
            </div>
            <div class="row">
                <div class="col-6 ml-auto mr-auto">
                    <label>Üzvlər</label>
                    <select disabled required name="users" multiple class="custom-select">
                        <#list project.projectCreatorsById as pUser>
                            <option selected
                                    value="${pUser.getUserByUserId().id}">${pUser.getUserByUserId().name} ${pUser.getUserByUserId().surname}</option>
                        </#list>
                    </select>
                </div>
            </div>
        </form>
    </div>
</@c.page>
