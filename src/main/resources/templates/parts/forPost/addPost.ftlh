<form action="/team/${teamIdOfCurrentAdmin}/post/add" method="post" enctype="multipart/form-data">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="form-group">
        <label for="exampleFormControlInput1">Başlıq</label>
        <input required type="text" name="header" class="form-control">
    </div>
    <div class="form-group">
        <label for="exampleFormControlTextarea1">İçərik</label>
        <textarea required name="context" class="form-control" rows="3"></textarea>
    </div>
    <select name="catId" class="custom-select">
        <#list categories as category>
            <option value="${category.id}">${category.catName}</option>
        </#list>
    </select>
    <select name="userId" class="custom-select mt-3">
        <#list users as user>
            <option value="${user.id}">${user.name} ${user.surname}</option>
        </#list>
    </select>
    <div class="custom-file mt-3">
        <input type="file" name="files" multiple="" class="custom-file-input" id="customFileLangHTML">
        <label class="custom-file-label" for="customFileLangHTML" data-browse="SEÇ">Faylları seçin</label>
    </div>
    <button type="submit" class="btn btn-success mt-3">YADDA SAXLA</button>
</form>