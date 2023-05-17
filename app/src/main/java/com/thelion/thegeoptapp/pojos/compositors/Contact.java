package com.thelion.thegeoptapp.pojos.compositors;

import java.util.Objects;

public class Contact {
    private String telefone;
    private String sitio;
    private String email;
    private String fax;

    public Contact() {
    }

    public Contact(String telefone, String sitio, String email, String fax) {
        this.telefone = telefone;
        this.sitio = sitio;
        this.email = email;
        this.fax = fax;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(telefone, contact.telefone) &&
                Objects.equals(sitio, contact.sitio) &&
                Objects.equals(email, contact.email) &&
                Objects.equals(fax, contact.fax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefone, sitio, email, fax);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "telefone='" + telefone + '\'' +
                ", sitio='" + sitio + '\'' +
                ", email='" + email + '\'' +
                ", fax='" + fax + '\'' +
                '}';
    }
}
