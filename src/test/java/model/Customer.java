package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    @JsonProperty("CustomerNumber")
    private String customerNumber;
    private int countryKey;
    private String name;
    private String phoneNumber;
    private CustomerAddress address;
    private String[] industryCodes;

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getCountryKey() {
        return countryKey;
    }

    public void setCountryKey(int countryKey) {
        this.countryKey = countryKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomerAddress getAddress() {
        return address;
    }

    public void setAddress(CustomerAddress address) {
        this.address = address;
    }

    public String[] getIndustryCodes() {
        return industryCodes;
    }

    public void setIndustryCodes(String[] industryCodes) {
        this.industryCodes = industryCodes;
    }
}
