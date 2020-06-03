<form method="post" action="/category/add">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Yeni Kateqoriya</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <input type="text" name="catName" required
                       placeholder="Kateqoriyanın adını daxil edin."/>
            </td>
            <td>
                <a>
                    <button type="submit" class="btn btn-success">
                        <i class="far fa-save"></i>
                    </button>
                </a>
            </td>
        </tr>
        </tbody>
    </table>
</form>
