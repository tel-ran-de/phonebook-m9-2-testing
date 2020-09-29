package api.jsonObjects;

public class Address {

    private String street;
    private String zip;
    private String city;
    private String country;
    private int id;
    private int contactId;

    public Address(String street, String zip, String city, String country, int contactId) {
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.country = country;
        this.contactId = contactId;
    }

    public Address(String street, String zip, String city, String country, int id, int contactId) {
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.country = country;
        this.id = id;
        this.contactId = contactId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }
}
