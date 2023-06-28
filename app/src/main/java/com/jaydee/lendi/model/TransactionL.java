package com.jaydee.lendi.model;

public class TransactionL {
    public Long id;
    public String type;
    public boolean status;
    public String description;

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TransactionL{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}
