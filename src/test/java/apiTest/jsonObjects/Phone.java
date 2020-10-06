package apiTest.jsonObjects;

public class Phone {

    private int countryCode;
    private long phoneNumber;
    private int id;
    private int contactId;

    public Phone(int countryCode, long phoneNumber, int contactId) {
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
        this.contactId = contactId;
    }

    public Phone(int countryCode, long phoneNumber, int id, int contactId) {
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.contactId = contactId;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
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
