<#import "parts/common.ftlh" as c>
<@c.page>
    <#include "parts/navbar.ftlh">
    <div id="page-content-wrapper">
    <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <#--                        <i class="fas fa-ellipsis-v"></i>-->
        <button class="btn btn-primary" id="menu-toggle"><i class="fas fa-bars"></i></button>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                <#--                    <li class="nav-item active">-->
                <#--                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>-->
                <#--                    </li>-->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${adminInfo}
                    </a>
                    <div class="dropdown-menu dropdown-menu-right text-center" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <@l.logout />
                    </div>
                </li>
            </ul>
        </div>
    </nav>
    <#include "parts/forTeam/teamNavbar.ftlh">
    <div class="container">
    <#include "parts/forResponse/response.ftlh">
    <div class="row mt-3">
        <div class="col-12">
            <h1 class="text-center">${user.name} ${user.surname}</h1>
        </div>
    </div>
    <form action="/user/update" method="post" enctype="multipart/form-data">
        <#if user.userImg??>
            <div class="row mt-3">
                <img height="200" width="200" src="/img/${user.userImg}" class="rounded mx-auto d-block" alt="...">
                <input type="hidden" name="oldImgName" value="${user.userImg}">
            </div>
        <#else>
            <div class="row mt-3">
                <div class="text-center col-12">
                    <h4>İstifadəçi şəkili yoxdur.</h4>
                </div>
            </div>
        </#if>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="mt-3 custom-file">
            <input type="file" name="file" class="custom-file-input" id="customFileLangHTML">
            <label class="custom-file-label" for="customFileLangHTML" data-browse="SEÇ">YENI ŞƏKİL SEÇ</label>
        </div>
        <input type="hidden" name="userId" value="${user.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="row mt-2">
            <div class="col-6">
                <div class="form-group">
                    <label for="exampleFormControlInput1">Ad</label>
                    <input required type="text" name="name" value="${user.name}"
                           class="form-control">
                </div>
            </div>
            <div class="col-6">
                <div class="form-group">
                    <label for="exampleFormControlInput1">Soyad</label>
                    <input required type="text" name="surname" value="${user.surname}"
                           class="form-control">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <div class="form-group">
                    <label for="exampleFormControlInput1">Əlaqə Nömrəsi</label>
                    <input required type="text" name="phone" value="${user.phone}"
                           class="form-control">
                </div>
            </div>
            <div class="col-6">
                <div class="form-group">
                    <label for="exampleFormControlInput1">Email</label>
                    <input required type="text" name="email" value="${user.email}"
                           class="form-control">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <div class="form-group">
                    <label for="exampleFormControlInput1">Instagram</label>
                    <input required type="text" name="instagram" value="${user.instagram}"
                           class="form-control">
                </div>
            </div>
            <div class="col-6">
                <div class="form-group">
                    <label for="exampleFormControlInput1">Facebook</label>
                    <input required type="text" name="facebook" value="${user.facebook}"
                           class="form-control">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <div class="form-group">
                    <label for="exampleFormControlInput1">Linkedin</label>
                    <input required type="text" name="linkedin" value="${user.linkedin}"
                           class="form-control">
                </div>
            </div>
            <div class="col-6">
                <div class="form-group">
                    <label for="exampleFormControlInput1">Twitter</label>
                    <input required type="text" name="twitter" value="${user.twitter}"
                           class="form-control">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <div class="form-group">
                    <label for="formGroupExampleInput2">Doğum tarixi</label>
                    <input type="date" name="brithday" class="form-control" id="formGroupExampleInput2"
                           value="${user.brithday}">
                </div>
            </div>
            <div class="col-6">
                <div class="form-group">
                    <label for="formGroupExampleInput2">Doğulduğu yer</label>
                    <input type="text" name="birthdayPlace" class="form-control" id="formGroupExampleInput2"
                           value="${user.brithdayPlace}">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <div class="form-group">
                    <label for="formGroupExampleInput">Hazirki ünvan</label>
                    <input type="text" name="currentAddress" class="form-control" id="formGroupExampleInput"
                           value="${user.currentAddress}">
                </div>
            </div>
            <div class="col-6">
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Koordinatorluq</label>
                    <select name="teamId" class="form-control" id="exampleFormControlSelect1">
                        <option selected value="${team.id}">${team.teamName}</option>
                        <option disabled>#############</option>
                        <#list otherTeams as otherTeam>
                            <option value="${otherTeam.id}">${otherTeam.teamName}</option>
                        </#list>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Hobbiləriniz</label>
                    <textarea name="hobbySkill" class="form-control" id="exampleFormControlTextarea1"
                              rows="3">${user.hobbySkill}</textarea>
                </div>
            </div>
            <div class="col-6">
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Bizimlə birlikdə gerçəkləşdirmək istədiyiniz
                        idealar</label>
                    <textarea name="whyUs" class="form-control" id="exampleFormControlTextarea1"
                              rows="3">${user.additionalIdeas}</textarea>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Digər müəssisə və təşkilatlarda fəaliyyətiniz</label>
                    <textarea name="socialActivitiy" class="form-control" id="exampleFormControlTextarea1"
                              rows="3">${user.socialActivitiy}</textarea>
                </div>
            </div>
            <div class="col-6">
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Haqqımızda məlumatı necə əldə etmisiniz</label>
                    <textarea name="whereFindUs" class="form-control" id="exampleFormControlTextarea1"
                              rows="3">${user.whereFindUs}</textarea>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Bizimlə birlikdə çalışmaqda məqsədiniz</label>
                    <textarea name="additionalIdeas" class="form-control" id="exampleFormControlTextarea1"
                              rows="3">${user.whyUs}</textarea>
                </div>
            </div>
            <div class="col-6">
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Təhsil Məlumatları</label>
                    <textarea name="eduInfo" class="form-control" id="exampleFormControlTextarea1"
                              rows="3">${user.eduInfo}</textarea>
                </div>
            </div>
            <div class="form-group mr-auto ml-auto">
                <#list roles as role>
                    <label>
                        <#if role=="ADMIN">
                            <#continue>
                        <#else>
                            <input name="${role}" ${user.roles?seq_contains(role)?string("checked", "")} type="checkbox"
                                   class="form-control">
                            ${role}
                        </#if>
                    </label>
                </#list>
            </div>
        </div>
        <div class="row mb-3">
            <div class="col-12 text-center">
                <input type="submit" class="btn btn-success" value="YADDA SAXLA">
            </div>
        </div>
    </form>
</@c.page>