package org.leti.Domain;

import javax.persistence.*;

/**
 * TransactionType - таблица, определяющая тип транзакции
 * id - ID типа
 * title - название (тип транзакции) денежная? ресурсы?
 * transactionId - id транзакции, для которой указан этот тип
 */

@Entity
@Table(name = "transaction_type")
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
