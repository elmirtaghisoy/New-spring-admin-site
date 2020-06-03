<#list fileList as file>
    <div class="col-lg-4 d-flex align-items-stretch">
        <div class="card" style="width: 18rem;">
            <img src="/img/${file.fileName}" class="card-img-top" alt="...">
            <div class="card-body">
                <div class="row">
                    <form class="ml-1" method="post" action="/files/deleteFile/${file.postId}/${file.id}">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button class="btn btn-danger" type="submit">SİL</button>
                    </form>
                    <#if file.fileType ==2>
                        <#if file.queue==1>
                            <form>
                                <button class="btn" style="color: black" disabled>Is Cover</button>
                            </form>
                        <#else>
                            <form class="ml-1" action="/files/selectCover/${file.postId}/${file.id}"
                                  method="post">
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                <button class="btn btn-success" type="submit">COVER</button>
                            </form>
                        </#if>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</#list>
