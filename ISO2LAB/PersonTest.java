import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class PersonTest {
	
	/**
	 *-------------------------------------- CONSTRUCTOR METHOD--------------------------------------------------------------------------------------------------
	 */
	// Test case: valid input
    @Test
    public void testCreatePersonValidInput() {
        Person person = new Person("Alice", "Smith", "British", Degree.MASTER, EnglishCertification.C1, 
                                    "alice.smith@example.com", LocalDate.of(1990, 1, 1), 123456789);
        assertNotNull(person);// Verify object has been created
    }
    // Test case: empty name
    @Test
    public void testCreatePersonEmptyName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("", "Smith", "British", Degree.MASTER, EnglishCertification.C1, 
                       "alice.smith@example.com", LocalDate.of(1990, 1, 1), 123456789);
        });
        assertEquals("Name cannot be empty", exception.getMessage());
    }
    // Test case: future birth date
    @Test
    public void testCreatePersonFutureBirthdate() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("Alice", "Smith", "British", Degree.MASTER, EnglishCertification.C1, 
                       "alice.smith@example.com", LocalDate.of(2030, 1, 1), 123456789);
        });
        assertEquals("Birthdate cannot be in the future", exception.getMessage());
    }
    // Test case: null birth date
    @Test
    public void testCreatePersonNullBirthdate() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("Alice", "Smith", "British", Degree.MASTER, EnglishCertification.C1, 
                       "alice.smith@example.com", null, 123456789);
        });
        assertEquals("Birthdate cannot be null", exception.getMessage());
    }
    
    /**
	 *-------------------------------------- isAdult METHOD--------------------------------------------------------------------------------------------------
	 */
    // Test case: exactly 18 years old
    @Test
    public void testIsAdultExactly18YearsOld() {
        LocalDate birthdate = LocalDate.now().minusYears(18); // Birth date exactly 18 years before
        Person person = new Person("Alice", "Smith", "British", Degree.MASTER, EnglishCertification.C1, 
                                   "alice.smith@example.com", birthdate, 123456789);
        assertTrue(person.isAdult()); 
    }
    // Test case: less than 18 years old
    @Test
    public void testIsAdultLessThan18YearsOld() {
        LocalDate birthdate = LocalDate.now().minusYears(17); //Birth date exactly 17 years before
        Person person = new Person("Alice", "Smith", "British", Degree.MASTER, EnglishCertification.C1, 
                                   "alice.smith@example.com", birthdate, 123456789);
        assertFalse(person.isAdult());
    }
    // Test case: more than 18 years old
    @Test
    public void testIsAdultMoreThan18YearsOld() {
        LocalDate birthdate = LocalDate.now().minusYears(19); // Birthdate exactly 19 years before
        Person person = new Person("Alice", "Smith", "British", Degree.MASTER, EnglishCertification.C1, 
                                   "alice.smith@example.com", birthdate, 123456789);
        assertTrue(person.isAdult());
    }
    
    /**
	 *-------------------------------------- isEuropean METHOD--------------------------------------------------------------------------------------------------
	 */
    // Test case: European nationality
    @Test
    public void testIsEuropeanEuropeanNationality() {
        Person person = new Person("Alice", "Smith", "Austrian", Degree.MASTER, EnglishCertification.C1, 
                                   "alice.smith@example.com", LocalDate.of(2000, 1, 1), 123456789);
        assertTrue(person.isEuropean()); // "Austrian" is an european nationality
    }
    // Test case: Non-European nationality
    @Test
    public void testIsEuropeanNonEuropeanNationality() {
        Person person = new Person("Alice", "Smith", "American", Degree.MASTER, EnglishCertification.C1, 
                                   "alice.smith@example.com", LocalDate.of(2000, 1, 1), 123456789);
        assertFalse(person.isEuropean()); // "American" is not an european nationality
    }
    // Test case: Case-insensitivity test
    @Test
    public void testIsEuropeanCaseInsensitivity() {
        Person person = new Person("Alice", "Smith", "austrian", Degree.MASTER, EnglishCertification.C1, 
                                   "alice.smith@example.com", LocalDate.of(2000, 1, 1), 123456789);
        assertTrue(person.isEuropean()); // "austrian nationality in lower case should be recognize
    }
    
    /**
	 *-------------------------------------- canEnrollDoctoralProgram METHOD--------------------------------------------------------------------------------------------------
	 */
    // Test case: Doctorate degree
    @Test
    public void testCanEnrollDoctoralProgramDoctorate() {
        Person person = new Person("Alice", "Smith", "British", Degree.DOCTORATE, EnglishCertification.C1, 
                                   "alice.smith@example.com", LocalDate.of(2000, 1, 1), 123456789);
        assertTrue(person.canEnrollDoctoralProgram());
    }
    // Test case: Master's degree
    @Test
    public void testCanEnrollDoctoralProgramMasters() {
        Person person = new Person("Alice", "Smith", "British", Degree.MASTER, EnglishCertification.C1, 
                                   "alice.smith@example.com", LocalDate.of(2000, 1, 1), 123456789);
        assertTrue(person.canEnrollDoctoralProgram()); //With a Master's, you should be able to enroll in a doctoral program.
    }
    // Test case: Undergraduate degree
    @Test
    public void testCanEnrollDoctoralProgramUndergraduate() {
        Person person = new Person("Alice", "Smith", "British", Degree.GRADUATE, EnglishCertification.C1, 
                                   "alice.smith@example.com", LocalDate.of(2000, 1, 1), 123456789);
        assertFalse(person.canEnrollDoctoralProgram()); // With an undergraduate degree, you should not be able to enroll in a doctoral program.
    }
    // Test case: No degree
    @Test
    public void testCanEnrollDoctoralProgramNoDegree() {
        Person person = new Person("Alice", "Smith", "British", Degree.NONE, EnglishCertification.C1, 
                                   "alice.smith@example.com", LocalDate.of(2000, 1, 1), 123456789);
        assertFalse(person.canEnrollDoctoralProgram()); // Without a degree, you should not be able to enroll in a doctoral program.
    }
    
    /**
	 *-------------------------------------- getAge METHOD--------------------------------------------------------------------------------------------------
	 */
    // Test case: Recent birthday (exactly 25 years old)
    @Test
    public void testGetAgeRecentBirthday() {
        // Assuming today is 2024-12-20
        Person person = new Person("Alice", "Smith", "British", Degree.MASTER, EnglishCertification.C1,
                                   "alice.smith@example.com", LocalDate.of(1999, 12, 20), 123456789);
        assertEquals(25, person.getAge()); // Should be 25 years old today
    }
    // Test case: Upcoming birthday (still 24 years old, birthday is tomorrow)
    @Test
    public void testGetAgeUpcomingBirthday() {
        // Assuming today is 2024-12-20, the person was born on 1999-12-21
        Person person = new Person("Alice", "Smith", "British", Degree.MASTER, EnglishCertification.C1,
                                   "alice.smith@example.com", LocalDate.of(1999, 12, 21), 123456789);
        assertEquals(24, person.getAge()); // Should be 24 years old today
    }
    // Test case: Leap year birthdate (born on 29th February 2000)
    @Test
    public void testGetAgeLeapYearBirthday() {
        // Assuming today is 2024-12-20
        Person person = new Person("Alice", "Smith", "British", Degree.MASTER, EnglishCertification.C1,
                                   "alice.smith@example.com", LocalDate.of(2000, 2, 29), 123456789);
        assertEquals(24, person.getAge()); // Should be 24 years old today
    }
}
