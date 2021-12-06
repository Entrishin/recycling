<#import "parts/common.ftlh" as c>

<@c.page>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Имя</th>
            <th>Роль</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.getUsername()}</td>
                <td><#list user.getRoles() as role> ${role}<#sep>, </#list>  </td>
                <td><a href="/user/${user.getId()}">Редактировать</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>