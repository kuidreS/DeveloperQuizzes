package vserdiuk.tech.test.entity;

import java.util.Objects;

/**
 * Created by vserdiuk on 7/26/18
 */

public class Address {

    private String country;
    private String city;
    private String street;
    private String buildingNumber; // Number could be like 1A or 12/34
    private String apartmentNumber; // Number could be like 1A or 12/1
    private Long postCode;

    public Address(AddressBuilder builder) {
        this.country = builder.country;
        this.city = builder.city;
        this.street = builder.street;
        this.buildingNumber = builder.buildingNumber;
        this.apartmentNumber = builder.apartmentNumber;
        this.postCode = builder.postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public Long getPostCode() {
        return postCode;
    }

    public void setPostCode(Long postCode) {
        this.postCode = postCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(country, address.country) &&
                Objects.equals(city, address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(buildingNumber, address.buildingNumber) &&
                Objects.equals(apartmentNumber, address.apartmentNumber) &&
                Objects.equals(postCode, address.postCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(country, city, street, buildingNumber, apartmentNumber, postCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", postCode=" + postCode +
                '}';
    }

    public static class AddressBuilder {
        private String country;
        private String city;
        private String street;
        private String buildingNumber;
        private String apartmentNumber = "N/A"; // Not Available - default value because it could be own house not apartment
        private Long postCode;

        public AddressBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public AddressBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder setStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder setBuildingNumber(String buildingNumber) {
            this.buildingNumber = buildingNumber;
            return this;
        }

        public AddressBuilder setApartmentNumber(String apartmentNumber) {
            this.apartmentNumber = apartmentNumber;
            return this;
        }

        public AddressBuilder setPostCode(Long postCode) {
            this.postCode = postCode;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }

}
