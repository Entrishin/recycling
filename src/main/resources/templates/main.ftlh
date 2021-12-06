<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="container mt-5">
      <a href="/entry" class="btn btn-info" role="button">Создать проводку</a>

        <!-- Таблица проводок -->
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Дата</th>
                <th>ID проводки</th>
                <th>Комментарий</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <#list entries as entry>
                <tr>
                    <td>${entry.getTimestamp()}</td>
                    <td>${entry.getId()}</td>
                    <td>${entry.getComment()}</td>
                    <td><a href="/entry/${entry.getId()}">Просмотр</a></td>
                </tr>
            </#list>
            </tbody>
        </table>

    </div>
</@c.page>