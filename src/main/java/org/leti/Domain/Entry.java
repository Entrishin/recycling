package org.leti.Domain;

import javax.persistence.*;

/**
 * Таблица "Проводка"
 * id - ID проводки, через этот ID к проводке будут привязываться транзакции
 * comment -  комментарий
 */

@Entity
@Table(name = "entry")
public class Entry {
    @Id
    private String id;
    private String comment;
    private String timestamp;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Entry() {
    }

    public Entry(String id) {
        this.id = id;
    }

    public Entry(String id, String comment, String timestamp) {
        this.id = id;
        this.comment = comment;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
