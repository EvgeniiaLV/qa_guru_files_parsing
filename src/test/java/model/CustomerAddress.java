package model;

public class CustomerAddress {
    private String city;
    private String postalCode;
    private String houseNumberAndStreet;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getHouseNumberAndStreet() {
        return houseNumberAndStreet;
    }

    public void setHouseNumberAndStreet(String houseNumberAndStreet) {
        this.houseNumberAndStreet = houseNumberAndStreet;
    }
}
