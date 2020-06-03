<div id="addTeamModal" class="modal fade bd-example-modal-xl" tabindex="-1" role="dialog"
     aria-labelledby="myExtraLargeModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-xl" role="document">
        <form method="post" action="/team/addTeam" enctype="multipart/form-data">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">YENİ KOORDİNATORLUQ</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label text-uppercas">Koordinatorluğun
                            adı:</label>
                        <input name="teamName" type="text" class="form-control" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Koordinatorluq haqqında məlumat</label>
                        <textarea name="teamDesc" class="form-control" id="message-text"></textarea>
                    </div>
                    <div class="custom-file mt-3">
                        <input type="file" name="file" class="custom-file-input" id="customFileLangHTML">
                        <label class="custom-file-label" for="customFileLangHTML" data-browse="SEÇ">Fayllı seçin</label>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success">YADDA SAXLA</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">LƏĞV ET</button>
                </div>
            </div>
        </form>
    </div>