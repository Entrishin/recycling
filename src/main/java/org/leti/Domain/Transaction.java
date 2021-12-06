package org.leti.Domain;


import javax.persistence.*;

/**
 * Таблица "Транзакция"
 * id - ID транзакции
 * entry - проводка к которой принадлежит эта транзакция ( отношение manyToOne много транзакций - одна проводка)
 * timestamp - время проводения транзакции
 * invoiceUrl - ссылка на кассовый чек?
 * transactionTypeId - id типа транзакции
 * amountId - ID размерности
 * unitId - ID ресурса (пластики/стекло/деньги?)
 * Также к каждой транзакции будут (по ID) привязаны таблицы:
 * @see TxInput
 * @see TxOutput
 * @see PaymentGateway
 */
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Entry entry;
    private Long timestamp;
    private String invoiceUrl;
    private Long transactionTypeId;
    private Long amountId;

    private Long unitId;

    public Long getAmountId() {
        return amountId;
    }

    public void setAmountId(Long amountId) {
        this.amountId = amountId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getInvoiceUrl() {
        return invoiceUrl;
    }

    public void setInvoiceUrl(String invoiceUrl) {
        this.invoiceUrl = invoiceUrl;
    }
}
