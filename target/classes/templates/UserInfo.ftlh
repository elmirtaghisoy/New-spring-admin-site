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
        <#include "parts/forUser/userNavbar.ftlh">
        <div class="container">
            <form>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Ad</label>
                            <input disabled required type="text" name="name" value="${user.name}"
                                   class="form-control">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Soyad</label>
                            <input disabled required type="text" name="surname" value="${user.surname}"
                                   class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Əlaqə Nömrəsi</label>
                            <input disabled required type="text" name="phone" value="${user.phone}"
                                   class="form-control">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Email</label>
                            <input disabled required type="text" name="phone" value="${user.email}"
                                   class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Instagram</label>
                            <input disabled required type="text" name="instagram" value="${user.instagram}"
                                   class="form-control">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Facebook</label>
                            <input disabled required type="text" name="facebook" value="${user.facebook}"
                                   class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Linkedin</label>
                            <input disabled required type="text" name="linkedin" value="${user.linkedin}"
                                   class="form-control">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Twitter</label>
                            <input disabled required type="text" name="twitter" value="${user.twitter}"
                                   class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="formGroupExampleInput2">Doğum tarixi</label>
                            <input disabled type="date" name="brithday" class="form-control" id="formGroupExampleInput2"
                                   value="${user.brithday}">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="formGroupExampleInput2">Doğulduğu yer</label>
                            <input disabled type="text" name="birthdayPlace" class="form-control"
                                   id="formGroupExampleInput2"
                                   value="${user.brithdayPlace}">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="formGroupExampleInput">Hazirki ünvan</label>
                            <input disabled type="text" name="currentAddress" class="form-control"
                                   id="formGroupExampleInput"
                                   value="${user.currentAddress}">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">Koordinatorluq</label>
                            <select disabled name="teamId" class="form-control" id="exampleFormControlSelect1">
                                <option selected value="${team.id}">${team.teamName}</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">Hobbiləriniz</label>
                            <textarea disabled name="hobbySkill" class="form-control" id="exampleFormControlTextarea1"
                                      rows="3">${user.hobbySkill}</textarea>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">Bizimlə birlikdə gerçəkləşdirmək istədiyiniz
                                idealar</label>
                            <textarea disabled name="whyUs" class="form-control" id="exampleFormControlTextarea1"
                                      rows="3">${user.additionalIdeas}</textarea>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">Digər müəssisə və təşkilatlarda
                                fəaliyyətiniz</label>
                            <textarea disabled name="socialActivitiy" class="form-control"
                                      id="exampleFormControlTextarea1"
                                      rows="3">${user.socialActivitiy}</textarea>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">Haqqımızda məlumatı necə əldə etmisiniz</label>
                            <textarea disabled name="whereFindUs" class="form-control" id="exampleFormControlTextarea1"
                                      rows="3">${user.whereFindUs}</textarea>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">Bizimlə birlikdə çalışmaqda məqsədiniz</label>
                            <textarea disabled name="additionalIdeas" class="form-control"
                                      id="exampleFormControlTextarea1"
                                      rows="3">${user.whyUs}</textarea>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">Təhsil Məlumatları</label>
                            <textarea disabled name="eduInfo" class="form-control" id="exampleFormControlTextarea1"
                                      rows="3">${user.eduInfo}</textarea>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</@c.page>
