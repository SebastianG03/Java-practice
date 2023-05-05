package business.entities;

public class User {

    private String firstName = null;
    private String lastName = null;
    private String nationality = null;
    private Integer age = null;

    public User(final String firstName, final String lastName,
                final String nationality, final Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public Integer getAge() {
        return age;
    }
}
