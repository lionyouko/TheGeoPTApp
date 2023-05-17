package com.thelion.thegeoptapp.pojos.compositors;

import java.util.Objects;

public class Adress {
    private String rua;
    private String localidade;
    private String codigopostal;
    private String descrpostal;
    private String distrito;

    public Adress() {
    }

    public Adress(String rua, String localidade, String codigopostal, String descrpostal, String distrito) {
        this.rua = rua;
        this.localidade = localidade;
        this.codigopostal = codigopostal;
        this.descrpostal = descrpostal;
        this.distrito = distrito;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getDescrpostal() {
        return descrpostal;
    }

    public void setDescrpostal(String descrpostal) {
        this.descrpostal = descrpostal;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adress adress = (Adress) o;
        return Objects.equals(rua, adress.rua) &&
                Objects.equals(localidade, adress.localidade) &&
                Objects.equals(codigopostal, adress.codigopostal) &&
                Objects.equals(descrpostal, adress.descrpostal) &&
                Objects.equals(distrito, adress.distrito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rua, localidade, codigopostal, descrpostal, distrito);
    }

    @Override
    public String toString() {
        return "Adress{" +
                "rua='" + rua + '\'' +
                ", localidade='" + localidade + '\'' +
                ", codigopostal='" + codigopostal + '\'' +
                ", descrpostal='" + descrpostal + '\'' +
                ", distrito='" + distrito + '\'' +
                '}';
    }
}
