package com.thelion.thegeoptapp.pojos.compositors;

import java.util.Objects;

public class AdministrativeInfo {
    private double areaha;
    private int populacao;
    private int eleitores;
    private int codigoine;

    public AdministrativeInfo() {
    }

    public AdministrativeInfo(double areaha, int populacao, int eleitores, int codigoine) {
        this.areaha = areaha;
        this.populacao = populacao;
        this.eleitores = eleitores;
        this.codigoine = codigoine;
    }

    public double getAreaha() {
        return areaha;
    }

    public void setAreaha(double areaha) {
        this.areaha = areaha;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public int getEleitores() {
        return eleitores;
    }

    public void setEleitores(int eleitores) {
        this.eleitores = eleitores;
    }

    public int getCodigoine() {
        return codigoine;
    }

    public void setCodigoine(int codigoine) {
        this.codigoine = codigoine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdministrativeInfo that = (AdministrativeInfo) o;
        return Double.compare(that.areaha, areaha) == 0 &&
                populacao == that.populacao &&
                eleitores == that.eleitores &&
                codigoine == that.codigoine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaha, populacao, eleitores, codigoine);
    }
}
