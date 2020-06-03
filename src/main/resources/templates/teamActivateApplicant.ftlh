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
                    <h1 class="text-center">${applicant.name} ${applicant.surname}</h1>
                </div>
            </div>
            <form method="post" action="/sendRegPage" enctype="multipart/form-data">
                <input type="hidden" name="applicantId" value="${applicant.id}">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Ad</label>
                            <input required type="text" name="name" value="${applicant.name}"
                                   class="form-control">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Soyad</label>
                            <input required type="text" name="surname" value="${applicant.surname}"
                                   class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Əlaqə Nömrəsi</label>
                            <input required type="text" name="phone" value="${applicant.phone}"
                                   class="form-control">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Email</label>
                            <input required type="text" name="phone" value="${applicant.email}"
                                   class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Instagram</label>
                            <input required type="text" name="instagram" value="${applicant.instagram}"
                                   class="form-control">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Facebook</label>
                            <input required type="text" name="facebook" value="${applicant.facebook}"
                                   class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Linkedin</label>
                            <input required type="text" name="linkedin" value="${applicant.linkedin}"
                                   class="form-control">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Twitter</label>
                            <input required type="twitter" name="phone" value="${applicant.twitter}"
                                   class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="formGroupExampleInput2">Doğum tarixi</label>
                            <input type="date" name="brithday" class="form-control" id="formGroupExampleInput2"
                                   value="${applicant.brithday}">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="formGroupExampleInput2">Doğulduğu yer</label>
                            <input type="text" name="birthdayPlace" class="form-control" id="formGroupExampleInput2"
                                   value="${applicant.brithdayPlace}">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="formGroupExampleInput">Hazirki ünvan</label>
                            <input type="text" name="currentAddress" class="form-control" id="formGroupExampleInput"
                                   value="${applicant.currentAddress}">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">Qoşulmaq istədiyi koordinatorluq</label>
                            <select name="teamId" class="form-control" id="exampleFormControlSelect1">
                                <option selected value="${applicant.teamId}">${applicant.team.teamName}</option>
                                <option disabled>############</option>
                                <#if teamList??>
                                    <#list teamList as team>
                                        <option value="${team.id}">${team.teamName}</option>
                                    </#list>
                                <#else>
                                    <option>Koordinatorluq Tapılmadı</option>
                                </#if>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">Hobbiləriniz</label>
                            <textarea name="hobbySkill" class="form-control" id="exampleFormControlTextarea1"
                                      rows="3">${applicant.hobbySkill}</textarea>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">Bizimlə birlikdə gerçəkləşdirmək istədiyiniz
                                idealar</label>
                            <textarea name="whyUs" class="form-control" id="exampleFormControlTextarea1"
                                      rows="3">${applicant.additionalIdeas}</textarea>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">Digər müəssisə və təşkilatlarda
                                fəaliyyətiniz</label>
                            <textarea name="socialActivitiy" class="form-control" id="exampleFormControlTextarea1"
                                      rows="3">${applicant.socialActivitiy}</textarea>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">Haqqımızda məlumatı necə əldə etmisiniz</label>
                            <textarea name="whereFindUs" class="form-control" id="exampleFormControlTextarea1"
                                      rows="3">${applicant.whereFindUs}</textarea>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">Bizimlə birlikdə çalışmaqda məqsədiniz</label>
                            <textarea name="additionalIdeas" class="form-control" id="exampleFormControlTextarea1"
                                      rows="3">${applicant.whyUs}</textarea>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">Təhsil Məlumatları</label>
                            <textarea name="eduInfo" class="form-control" id="exampleFormControlTextarea1"
                                      rows="3">${applicant.eduInfo}</textarea>
                        </div>
                    </div>
                </div>
                <button type="submit" class="mt-3 btn btn-success">ÜZV ET</button>
            </form>
        </div>
    </div>
</@c.page>
