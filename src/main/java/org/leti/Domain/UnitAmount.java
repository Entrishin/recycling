package org.leti.Domain;

import javax.persistence.*;

/**
 * Таблица Unit_amount - определяет размерность передаваемых ресурсов (кг, литры и т.п.)
 * id
 * title - размерность
 */

@Entity
@Table(name = "unit_amount")
public class UnitAmount {
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
