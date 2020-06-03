<form action="/files/updateFile/${postId}" method="post" enctype="multipart/form-data">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="mt-3 custom-file">
        <input type="file" name="files" multiple="" class="custom-file-input" id="customFileLangHTML">
        <label class="custom-file-label" for="customFileLangHTML" data-browse="SEÇ">ƏLAVƏ FAYLLAR</label>
    </div>
    <button class="btn btn-success mt-3" type="submit">YENİ FAYLLARI YADDA SAXLA</button>
</form>