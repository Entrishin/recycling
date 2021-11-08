<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <#if isRegisterForm><div class="form-group row">
            <label class="col-sm-2 col-form-label" > ФИО :  </label>
            <div class="col-sm-6">
                <input type="text" name="fullName" class = "form-control" placeholder="Иванов Иван" required/>
            </div>
        </div> </#if>

        <#if isRegisterForm> <div class="form-group row">
            <label class="col-sm-2 col-form-label"> E-mail адрес : </label>
            <div class="col-sm-6">
                <input type="text" name="email" class = "form-control" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" placeholder="some@some.ru" required/>
            </div>
        </div> </#if>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label" > Логин : </label>
            <div class="col-sm-6">
                <input type="text" name="username" class = "form-control" pattern="[a-z0-9_]{4,30}" <#if isRegisterForm> placeholder="Логин(не менее 4 символов)"<#else > placeholder="Логин" </#if>  required/> </label>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Пароль: </label>
            <div class="col-sm-6">
                <input type="password" name="password" class = "form-control" pattern=".{4,30}" <#if isRegisterForm> placeholder="Пароль(не менее 4 символов)"<#else > placeholder="Пароль" </#if> required/>
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />


        <div>
            <button class="btn btn-primary" type="submit" ><#if isRegisterForm>Зарегистрироваться<#else>Войти</#if></button>
            <#if !isRegisterForm> <a style="margin-left: 10px" href="/registration">Зарегистрироваться</a>  </#if>
        </div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Выйти"/>
    </form>
</#macro>

<#macro editProfile>
    <form  method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> E-mail адрес : </label>
            <div class="col-sm-6">
                <input type="text" name="email" class = "form-control" placeholder="some@some.ru" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" value="${email!""}"/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Пароль: </label>
            <div class="col-sm-6">
                <input type="password" pattern=".{4,30}" name="password" class = "form-control" placeholder="Пароль" />
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div>
            <button class="btn btn-primary" type="submit" >Сохранить</button>
        </div>
    </form>
</#macro>