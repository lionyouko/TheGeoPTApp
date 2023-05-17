package com.thelion.thegeoptapp.pojos;

import java.util.Objects;

public class Place {
    private int nif;
    private String nome;
    private int codigo;

    public Place() {
    }

    public Place(int nif, String nome, int codigo) {
        this.nif = nif;
        this.nome = nome;
        this.codigo = codigo;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return nif == place.nif &&
                codigo == place.codigo &&
                Objects.equals(nome, place.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, nome, codigo);
    }

    @Override
    public String toString() {
        return "Place{" +
                "nif=" + nif +
                ", nome='" + nome + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}
