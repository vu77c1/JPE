import java.util.Date;

public abstract class Person {
    private String fullName;
    private String gender;
    private String phone;
    private String email;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    private Date birthDate;

    public String getFullName() {
        return fullName;
    }

    public Person(String fullName, String gender, String phone, String email,Date birthDate) {
        this.fullName = fullName;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.birthDate=birthDate;
    }

    public Person() {
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public   void inputCommonDetails(Person person) {
        person.setFullName(PersonManageValidator.validateStringInput("Enter Full Name: "));
        person.setGender(PersonManageValidator.validateGenderInput("Enter Gender (male or female): "));
        person.setBirthDate(PersonManageValidator.validateDateInput("Enter birth day (format: dd/mm/yyyy): "));
        person.setEmail(PersonManageValidator.validateEmailInput("Enter Email: "));
        person.setPhone(PersonManageValidator.validatePhoneNumber("Enter Phone: "));
    }

}
