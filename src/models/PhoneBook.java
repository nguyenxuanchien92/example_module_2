package models;

public class PhoneBook {
    private String phoneNumber;
    private String typeGroup;
    private User user;

    public PhoneBook(String phoneNumber, String typeGroup, User user) {
        this.phoneNumber = phoneNumber;
        this.typeGroup = typeGroup;
        this.user = user;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTypeGroup() {
        return typeGroup;
    }

    public void setTypeGroup(String typeGroup) {
        this.typeGroup = typeGroup;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", typeGroup='" + typeGroup + '\'' +
                ", user=" + user +
                '}';
    }
}
