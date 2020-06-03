<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="container">
        <main role="main" class="container">
            <div class="starter-template">
                <h1>Client Page</h1>
                <p class="lead"><a href="/main">TO ADMIN PANEL</a></p>
            </div>
        </main>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-6 mr-auto ml-auto">
                <form method="post" action="/colorbrain/applicant/apply" enctype="multipart/form-data">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <div class="form-group">
                        <label for="formGroupExampleInput">Ad</label>
                        <input type="text" name="name" class="form-control" id="formGroupExampleInput"
                               placeholder="Example input placeholder">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput2">Soyad</label>
                        <input type="text" name="surname" class="form-control" id="formGroupExampleInput2"
                               placeholder="Another input placeholder">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput2">Doğum tarixi</label>
                        <input type="date" name="brithday" class="form-control" id="formGroupExampleInput2"
                               placeholder="Another input placeholder">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput2">Doğulduğu yer</label>
                        <input type="text" name="birthdayPlace" class="form-control" id="formGroupExampleInput2"
                               placeholder="Another input placeholder">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput2">Əlaqə nömrəsi</label>
                        <input type="text" name="phone" class="form-control" id="formGroupExampleInput2"
                               placeholder="Another input placeholder">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput">Email</label>
                        <input type="email" name="email" class="form-control" id="formGroupExampleInput"
                               placeholder="Example input placeholder">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput">Instagram</label>
                        <input type="text" name="instagram" class="form-control" id="formGroupExampleInput"
                               placeholder="Example input placeholder">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput">Facebook</label>
                        <input type="text" name="facebook" class="form-control" id="formGroupExampleInput"
                               placeholder="Example input placeholder">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput">Linkedin</label>
                        <input type="text" name="linkedin" class="form-control" id="formGroupExampleInput"
                               placeholder="Example input placeholder">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput">Twitter</label>
                        <input type="text" name="twitter" class="form-control" id="formGroupExampleInput"
                               placeholder="Example input placeholder">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput">Hazirki ünvan</label>
                        <input type="text" name="currentAddress" class="form-control" id="formGroupExampleInput"
                               placeholder="Example input placeholder">
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Qoşulmaq istədiyiniz koordinatorluq</label>
                        <select name="teamId" class="form-control" id="exampleFormControlSelect1">
                            <#if teamList??>
                                <#list teamList as team>
                                    <option value="${team.id}">${team.teamName}</option>
                                </#list>
                            <#else>
                                <option>Koordinatorluq Tapılmadı</option>
                            </#if>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">Təhsiliniz haqqında məlumat</label>
                        <textarea name="eduInfo" class="form-control" id="exampleFormControlTextarea1"
                                  rows="3"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">Hobbiləriniz</label>
                        <textarea name="hobbySkill" class="form-control" id="exampleFormControlTextarea1"
                                  rows="3"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">Bizimlə birlikdə gerçəkləşdirmək istədiyiniz
                            idealar</label>
                        <textarea name="whyUs" class="form-control" id="exampleFormControlTextarea1"
                                  rows="3"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">Digər müəssisə və təşkilatlarda fəaliyyətiniz</label>
                        <textarea name="socialActivitiy" class="form-control" id="exampleFormControlTextarea1"
                                  rows="3"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">Haqqımızda məlumatı necə əldə etmisiniz</label>
                        <textarea name="whereFindUs" class="form-control" id="exampleFormControlTextarea1"
                                  rows="3"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">Bizimlə birlikdə çalışmaqda məqsədiniz</label>
                        <textarea name="additionalIdeas" class="form-control" id="exampleFormControlTextarea1"
                                  rows="3"></textarea>
                    </div>

                    <button type="submit" class="btn btn-success mt-3">GÖNDƏR</button>
                </form>
            </div>
        </div>
    </div>
</@c.page>