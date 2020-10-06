package apiTest.jsonObjects;

public class Email {

    private String email;
    private int id;
    private int contactId;

    public Email(String email, int contactId) {
        this.email = email;
        this.contactId = contactId;
    }

    public Email(String email, int id, int contactId) {
        this.email = email;
        this.id = id;
        this.contactId = contactId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
