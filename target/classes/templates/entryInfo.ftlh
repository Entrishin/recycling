<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="container mt-5">
        <h3> Список транзакций для проводки </h3>
        <div style="color: #1c1c1c; text-decoration: underline"> № ${entryId} </div>
        <div style="color: #1b5880;">  ${comment} </div>

        <!-- Таблица транзакций проводки -->
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Дата</th>
                <th>Тип транзакции</th>
                <th>Со счета</th>
                <th>На счет</th>
                <th>Количество</th>
                <th>Размерность</th>
                <th>Актив</th>
            </tr>
            </thead>
            <tbody>
            <#list transactions as tr>
                <tr>
                    <td>${tr.getTimestamp()}</td>
                    <#--<td>test</td>-->
                    <td>${tr.getTransactionTypeTitle()}</td>
                    <td>${tr.getAccountFrom()}</td>
                    <td>${tr.getAccountTo()}</td>
                    <td>${tr.getAmount()}</td>
                    <td>${tr.getAmountTitle()}</td>
                    <td>${tr.getUnitTitle()}</td>
                </tr>
            </#list>
            </tbody>
        </table>

    </div>
</@c.page>