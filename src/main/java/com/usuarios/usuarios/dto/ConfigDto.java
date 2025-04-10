package com.usuarios.usuarios.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "config")
public class ConfigDto {
    @Id
    private long id;

    @Column(name = "pattern")
    private String pattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
