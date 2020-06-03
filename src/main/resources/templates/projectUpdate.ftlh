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
                    <h1 class="text-center">${project.header}</h1>
                </div>
            </div>
            <div class="row mt-3">
                <div class="text-center col-12">
                    <img src="/img/${project.imgName}" class="img-fluid" alt="Responsive image">
                </div>
            </div>
            <form method="post" action="/team/${teamIdOfCurrentAdmin}/project/${projectId}/update/"
                  enctype="multipart/form-data">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="form-group">
                    <label for="exampleFormControlInput1">Ad</label>
                    <input required type="text" name="header" value="${project.header}"
                           class="form-control">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Məlumat</label>
                    <textarea required name="context" class="form-control"
                              rows="3">${project.context}</textarea>
                </div>
                <div class="form-group">
                    <label for="exampleFormControlInput1">Tarix / Saat</label>
                    <input required type="datetime-local" name="date" class="form-control"
                           value="${project.date}">
                </div>
                <div class="row">
                    <div class="col-6 ml-auto mr-auto">
                        <label>Üzvlər</label>
                        <select required name="users" multiple class="custom-select">
                            <option disabled><b>#TƏŞKİLATÇILAR#</b></option>
                            <#list projectUsers as pUser>
                                <option selected value="${pUser.id}">${pUser.name} ${pUser.surname}</option>
                            </#list>
                            <option disabled><b>#DİGƏR ÜZVLƏR#</b></option>
                            <#list otherUsers as user>
                                <option value="${user.id}">${user.name} ${user.surname}</option>
                            </#list>
                        </select>
                    </div>
                </div>
                <input type="hidden" name="oldImg" value="${project.imgName}">
                <div class="mt-3 custom-file">
                    <input type="file" name="imgName" class="custom-file-input" id="customFileLangHTML">
                    <label class="custom-file-label" for="customFileLangHTML" data-browse="SEÇ">LAYİHƏNİN COVER
                        ŞƏKİLİNİ DƏYİŞ</label>
                </div>
                <div class="mt-3 form-group">
                    <label>Layihənin statusu</label>
                    <select required name="status" size="3" class="custom-select">
                        <#switch project.status>
                            <#case 1>
                                <option selected value="1">Gözləmədə olan</option>
                                <option value="2">İcra edilən</option>
                                <#break>
                            <#case 2>
                                <option value="1">Gözləmədə olan</option>
                                <option selected value="2">İcra edilən</option>
                                <option value="3">Yekunlaşdırılmış</option>
                                <#break>
                            <#case 3>
                                <option selected value="3">Yekunlaşdırılmış</option>
                                <#break>
                        </#switch>
                    </select>
                </div>
                <button type="submit" class="mt-3 btn btn-success">YADDA SAXLA</button>
            </form>
        </div>
    </div>
</@c.page>
