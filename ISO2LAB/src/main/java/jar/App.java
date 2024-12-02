package jar;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
    	String name = "Paco", surname = "Merlo", nationality = "British", emailAddress = "paco@gmail.com";
    	Degree degree = Degree.DOCTORATE;
    	EnglishCertification englishCertification = EnglishCertification.A1;
    	LocalDate birthdate = LocalDate.parse("2004-01-08");
    	int phoneNumber = 654321789;
        Person persona = new Person(name, surname, nationality, degree, englishCertification, emailAddress, birthdate, phoneNumber);
        System.out.println(persona.toString());
        System.out.println(persona.getAge());
        System.out.println(persona.isEuropean());
        System.out.println(persona.canEnrollDoctoralProgram());
        System.out.println(persona.isAdult());
        }
}
