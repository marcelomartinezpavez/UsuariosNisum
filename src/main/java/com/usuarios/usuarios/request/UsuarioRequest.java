package com.usuarios.usuarios.request;

import java.util.List;

public class UsuarioRequest {
    private String name;
    private String email;
    private String password;
    private List<PhonesRequest>  phones;

    public List<PhonesRequest> getPhones() {
        return phones;
    }

    public void setPhones(List<PhonesRequest> phones) {
        this.phones = phones;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
