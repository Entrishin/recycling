package org.leti.Domain;

import javax.persistence.*;

/**
 * таблица Unit - название передаваемого ресурса - деньги/пластик/стекло
 * id
 * title - название
 * unitAmountId - id таблица unit_amount
 */

@Entity
@Table(name = "unit")
public class Unit {
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
