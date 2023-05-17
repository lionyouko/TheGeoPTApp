package com.thelion.thegeoptapp.pojos;

import com.thelion.thegeoptapp.pojos.compositors.AdministrativeInfo;
import com.thelion.thegeoptapp.pojos.compositors.Adress;
import com.thelion.thegeoptapp.pojos.compositors.Contact;

import java.util.Objects;

public class City extends Place {
    private Adress address;
    private Contact contact;
    private AdministrativeInfo administrativeInfo;

    public City() {
        super();
    }

    public Adress getAddress() {
        return address;
    }

    public void setAddress(Adress address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public AdministrativeInfo getAdministrativeInfo() {
        return administrativeInfo;
    }

    public void setAdministrativeInfo(AdministrativeInfo administrativeInfo) {
        this.administrativeInfo = administrativeInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(address, city.address) &&
                Objects.equals(contact, city.contact) &&
                Objects.equals(administrativeInfo, city.administrativeInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, contact, administrativeInfo);
    }

    @Override
    public String toString() {
        return "City{" +
                "address=" + address +
                ", contact=" + contact +
                ", administrativeInfo=" + administrativeInfo +
                '}';
    }
}
