<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="container">
        <h1>Şifrəni Yenilə</h1>
        <#if message??>
            <p><b>${messageType}: </b>${message}</p>
        </#if>
        <form class="form-signin col-4 mx-auto" action="/updateUserCredentials" method="post">
            <input type="hidden" name="id" value="${user.id}">
            <input type="hidden" name="token" value="${token}">

            <input type="text" class="form-control ${(usernameError??)?string('is-invalid', '')}" name="username"
                   placeholder="Username" value="<#if user??>${user.username}</#if>" required="" autofocus="">
            <#if usernameError??>
                <div class="invalid-feedback">
                    ${usernameError}
                </div>
            </#if>

            <label for="inputEmail" class="sr-only">Email address</label>
            <input disabled type="email" value="<#if user??>${user.email}</#if>"
                   class="form-control mt-2 ${(emailError??)?string('is-invalid', '')}" name="email"
                   placeholder="Email" autofocus="">
            <#if emailError??>
                <div class="invalid-feedback">
                    ${emailError}
                </div>
            </#if>

            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" name="password" required=""
                   class="form-control my-2 ${(passwordError??)?string('is-invalid', '')}" placeholder="Password"
            >
            <#if passwordError??>
                <div class="invalid-feedback">
                    ${passwordError}
                </div>
            </#if>

            <input type="password" name="passwordConfirm" required=""
                   class="form-control my-2 ${(password2Error??)?string('is-invalid', '')}"
                   placeholder="Retype Password"
            >
            <#if password2Error??>
                <div class="invalid-feedback">
                    ${password2Error}
                </div>
            </#if>

            <div class="col-sm-6 mb-2">
                <div class="g-recaptcha" data-sitekey="6Ldh8OkUAAAAAAmUIGGunMtxFu5CgOx6n5bOonno"></div>
                <#if captchaError??>
                    <div class="alert alert-danger" role="alert">
                        ${captchaError}
                    </div>
                </#if>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Yadda Saxla"/>
        </form>
    </div>
</@c.page>