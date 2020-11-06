package micronaut.application.pesistence.model;

import java.time.LocalDate;
import java.util.Objects;

//@Entity
//@Table(name = "Person")
public class Person {

    //@Id
    //@SequenceGenerator(name = "pk_sequence_generator", sequenceName = "PK_SEQUENCE", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence_generator")
    //@Column(name = "ID", nullable = false)
    private Long id;

    //@Column(name= "FIRST_NAME", nullable = false)
    private String firstName;

    //@Column(name= "LAST_NAME", nullable = false)
    private String lastName;

    //@Column(name= "EMAIL", nullable = false, unique = true)
    private String email;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    //@Column(name= "DAY_OF_BIRTH")
    private LocalDate dayOfBirth;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(final LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(email, person.email) &&
                Objects.equals(dayOfBirth, person.dayOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, dayOfBirth);
    }
}
