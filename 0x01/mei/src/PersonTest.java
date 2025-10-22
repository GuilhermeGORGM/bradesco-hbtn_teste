package src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private Person person;

    @BeforeEach
    public void setup() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1);
        Date birthDate = calendar.getTime();

        person = new Person("Paul", "McCartney", birthDate, true, true, true, 1200f);
    }

    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary() {
        person.setSalary(1200f);
        assertEquals(14400f, person.calculateYearlySalary());
    }

    @Test
    public void person_is_MEI() {
        // Pessoa apta a ser MEI
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);
        person.setSalary(10000f / 12f); // Renda anual < 130000

        assertTrue(person.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        // Pessoa não apta (possui outra empresa)
        person.setAnotherCompanyOwner(true);
        person.setPensioner(false);
        person.setPublicServer(false);
        person.setSalary(20000f); // Renda anual > 130000

        assertFalse(person.isMEI());
    }
}
