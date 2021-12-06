package org.leti.Domain;

import javax.persistence.*;

/**
 * Таблица TxInput - дебет (куда) - на какой счет перевод
 * id - ID дебета
 * account - номер счета
 * transaction - транзакция, в которую входит этот счет, отношение manyToOne (в одной транзакции может быть несколько разных счетов)
 */

@Entity
@Table(name = "tx_input")
public class TxInput {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long account;
    @ManyToOne(fetch = FetchType.EAGER)
    private Transaction transaction;

    public TxInput() {
    }

    public TxInput(Long account, Transaction transaction) {
        this.account = account;
        this.transaction = transaction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
