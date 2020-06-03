<form action="/team/${teamIdOfCurrentAdmin}/project/add" method="post" enctype="multipart/form-data">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="form-group">
        <label for="exampleFormControlInput1">Ad</label>
        <input required type="text" name="header" class="form-control">
    </div>
    <div class="form-group">
        <label for="exampleFormControlTextarea1">Məlumat</label>
        <textarea required name="context" class="form-control" rows="3"></textarea>
    </div>
    <div class="form-group">
        <label for="exampleFormControlInputs1">Tarix / Saat</label>
        <input required type="datetime-local" name="date" class="form-control">
    </div>
    <select name="users" multiple class="custom-select">
        <#list users as user>
            <option value="${user.id}">${user.name} ${user.surname}</option>
        </#list>
    </select>
    <div class="custom-file mt-3">
        <input type="file" name="imgName" class="custom-file-input" id="customFileLangHTML">
        <label class="custom-file-label" for="customFileLangHTML" data-browse="SEÇ">LAYİHƏNİN COVER
            ŞƏKİLİ</label>
    </div>
    <button type="submit" class="btn btn-success mt-3">YADDA SAXLA</button>
</form>