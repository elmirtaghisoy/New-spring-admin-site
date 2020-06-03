<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Kateqoriya</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">1</th>
        <td>
            <input type="text" disabled value="Digər"/>
        </td>
        <td></td>
        <td></td>
    </tr>
    <#list categoryList as category>
        <tr>
            <th scope="row">${category.id}</th>
            <form method="post" action="/category/update/${category.id}">
                <td>
                    <input type="text" name="catName" value="${category.catName}"/>
                </td>
                <td>
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button type="submit" class="btn btn-warning">
                        <i style="color: white" class="far fa-edit"></i>
                    </button>
                </td>
            </form>
            <td>
                <form method="post" action="/category/delete/${category.id}">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button type="submit" class="btn btn-danger">
                        <i class="far fa-trash-alt"></i>
                    </button>
                </form>
            </td>
        </tr>
    </#list>
    </tbody>
</table>