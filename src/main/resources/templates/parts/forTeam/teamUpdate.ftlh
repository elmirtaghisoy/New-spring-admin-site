<#if team.imgName??>
    <div class="row mt-3 text-center">
        <div class="col-8 ml-auto mr-auto">
            <h4>${team.teamName} koordinatorluğu</h4>
            <img src="/img/${team.imgName}"
                 class="img-fluid" alt="Responsive image">
        </div>
    </div>
</#if>
<form method="post" action="/team/${team.id}/updateTeam" enctype="multipart/form-data">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <#if team.imgName??>
        <input type="hidden" name="oldImgName" value="${team.imgName}"/>
    </#if>
    <div class="row mt-3 text-center">
        <div class="col-12">
            <div class="form-group">
                <div class="input-group input-group-lg">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-lg">Koordinatorluq</span>
                    </div>
                    <input name="teamName" type="text" value="${team.teamName}" class="form-control"
                           aria-label="Sizing example input"
                           aria-describedby="inputGroup-sizing-lg">
                </div>
            </div>
        </div>
        <div class="col-12">
            <div class="form-group">
                <label for="exampleFormControlTextarea1">Koordinatorluq haqqında məlumat</label>
                <textarea name="teamDesc" class="form-control" id="exampleFormControlTextarea1"
                          rows="3">${team.teamDesc}</textarea>
            </div>
            <div class="custom-file mt-3">
                <input type="file" name="file" class="custom-file-input" id="customFileLangHTML">
                <label class="custom-file-label" for="customFileLangHTML" data-browse="SEÇ">Faylı
                    seçin</label>
            </div>
        </div>
        <div class="col-12 ml-auto mr-auto mt-3">
            <div class="form-group">
                <button type="submit" class="btn btn-success">YADDA SAXLA</button>
            </div>
        </div>
    </div>
</form>