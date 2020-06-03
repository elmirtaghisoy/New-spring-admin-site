<#import "../parts/common.ftlh" as c>
<@c.page>
<#--    <div class="container">-->
<#--        <main role="main" class="container">-->
<#--            <div class="starter-template">-->
<#--                <h1>Client Page</h1>-->
<#--                <p class="lead"><a href="/main">TO ADMIN PANEL</a></p>-->
<#--            </div>-->
<#--        </main>-->
<#--    </div>-->
    <div class="container">
        <div class="row">
            <div class="col-6 mr-auto ml-auto">
                <form method="post" action="/templates/client/applicant/apply" enctype="multipart/form-data">
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
                        <label for="formGroupExampleInput">Ünvan</label>
                        <input type="text" name="currentAddress" class="form-control" id="formGroupExampleInput"
                               placeholder="Example input placeholder">
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Qoşulmaq istədiyiniz koordinatorluq</label>
                        <select class="form-control" id="exampleFormControlSelect1">
                            <#if teamList??>
                                <#list teamList as team>
                                    <option value="${team.id}">${team.teamName}</option>
                                </#list>
                            <#else>
                                <option>Koordinatorluq Tapılmadı</option>
                            </#if>
                        </select>
                    </div>
                    <div class="custom-file">
                        <input name="cv" type="file" class="custom-file-input" id="customFileLangHTML">
                        <label class="custom-file-label" for="customFileLangHTML" data-browse="SEÇ">PDF formatlı CV'ni
                            seçin</label>
                    </div>
                    <button class="btn btn-success mt-3">GÖNDƏR</button>
                </form>
            </div>
        </div>
    </div>
</@c.page>