package org.leti.Domain;


import javax.persistence.*;
import java.util.Date;

/**
 * Таблица "Транзакция"
 * id - ID транзакции
 * entry - проводка к которой принадлежит эта транзакция ( отношение manyToOne много транзакций - одна проводка)
 * timestamp - время проводения транзакции
 * invoiceUrl - ссылка на кассовый чек?
 * transactionTypeId - id типа транзакции
 * amountId - ID размерности
 * unitId - ID ресурса (пластики/стекло/деньги?)
 * Также к каждой транзакции будут (по ID) привязана таблица:
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
    private String timestamp;
    private String invoiceUrl;
    private Long transactionTypeId;
    private Long amountId;
    private String accountFrom;
    private String accountTo;
    private Double amount;
    private Long unitId;

    private String amountTitle;
    private String transactionTypeTitle;
    private String unitTitle;

    public String getAmountTitle() {
        return amountTitle;
    }

    public void setAmountTitle(String amountTitle) {
        this.amountTitle = amountTitle;
    }

    public String getTransactionTypeTitle() {
        return transactionTypeTitle;
    }

    public void setTransactionTypeTitle(String transactionTypeTitle) {
        this.transactionTypeTitle = transactionTypeTitle;
    }

    public String getUnitTitle() {
        return unitTitle;
    }

    public void setUnitTitle(String unitTitle) {
        this.unitTitle = unitTitle;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }



    public Long getAmountId() {
        return amountId;
    }

    public String getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(String accountFrom) {
        this.accountFrom = accountFrom;
    }

    public String getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(String accountTo) {
        this.accountTo = accountTo;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getInvoiceUrl() {
        return invoiceUrl;
    }

    public void setInvoiceUrl(String invoiceUrl) {
        this.invoiceUrl = invoiceUrl;
    }
}
