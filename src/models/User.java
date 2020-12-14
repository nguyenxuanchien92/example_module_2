package models;

public class User {
    private String name;
    private String gender;
    private String address;
    private String dob;
    private String email;

    public User(String name, String gender, String address) {
        this.name = name;
        this.gender = gender;
        this.address = address;
    }

    public User(String name, String gender, String address, String dob, String email) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
