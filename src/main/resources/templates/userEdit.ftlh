<#import "parts/common.ftlh" as c>

<@c.page>
    Редактирование пользователя
    <form action="/user" method="post">
        <input type="text" pattern="[a-z0-9_]{4,30}" value="${user.getUsername()}" name="username">
        <#list roles as role>
            <div>
                <label> <input type="checkbox" name="${role}" ${user.getRoles()?seq_contains(role)?string("checked", "")} > ${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${user.getId()}" name="userId">
        <input type="hidden" value="${_csrf.token}" name = "_csrf">
        <button type="submit">Сохранить</button>
    </form>
</@c.page>