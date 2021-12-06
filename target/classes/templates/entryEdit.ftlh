<#import "parts/common.ftlh" as c>

<@c.page>
    <link rel="stylesheet" href="/static/style.css">
    <form method="post">
        <div class="container mt-5">
            <h2>Создание проводки</h2>
            <input type="text" class="form-control" name="entryId" hidden value="${entryId}"><br>
            <input type="text" class="form-control" name="comment" placeholder="Комментарий к проводке" value="${comment}"><br>

            <!-- Тригер для открытия модального окна -->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                Добавить транзакцию
            </button>

            <!-- Модальное окно -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Создание транзакции</h5>
                            <button type="button" class="close" data-dismiss="modal">x</button>
                        </div>

                        <!-- Тело модального окна -->
                        <div class="modal-body">
                            <div class="row g-3">
                                <div class="col mt-5">
                                    <label for="selectTransType" class="form-label">Тип транзакции</label>
                                    <select class="form-select" name="transtype" id = "selectTransType">
                                        <#list transactionTypes as key,type>
                                            <option>${type}</option>
                                        </#list>
                                    </select>
                                </div>
                            </div>
                            <div class="row g-3">
                                <div class="col mt-5">
                                    <label for="creditId" class="form-label">Со счета</label>
                                    <input type="text" id ="creditId" class="form-control" name="credit"><br>
                                </div>
                                <div class="col mt-5">
                                    <label for="debetId" class="form-label">На счет</label>
                                    <input type="text" id ="debetId" class="form-control" name="debet"><br>
                                </div>
                            </div>

                            <div class="row g-3">
                                <div class="col-md-3">
                                    <label for="amountId" class="form-label">Количество</label>
                                    <input type="text" id ="amountId" class="form-control" name="amount"><br>
                                </div>
                                <div class="col-md-3">
                                    <label for="selectAmountType" class="form-label">Размерность</label>
                                    <select class="form-select" id = "selectAmountType" name="amountType">
                                        <#list amountTypes as key,type>
                                            <option>${type}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col-md-3">
                                    <label for="selectUnit" class="form-label">Актив</label>
                                    <select class="form-select" name="unit" id ="selectUnit">
                                        <#list units as key,type>
                                            <option>${type}</option>
                                        </#list>
                                    </select>

                                </div>
                            </div>
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                            <button type="submit" name="savebutton" class="btn btn-primary"
                                    value="savetransaction">Сохранить</button>
                        </div>

                    </div>
                </div>
            </div>



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

    </form>

</@c.page>