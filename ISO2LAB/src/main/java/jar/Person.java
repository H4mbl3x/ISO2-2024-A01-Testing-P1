package jar;

import java.time.LocalDate;
import java.time.Period;

public class Person {
	private String name, surname, nationality, emailAddress;
	private Degree degree;
	private EnglishCertification englishCertification;
	private LocalDate birthdate;
	private int phoneNumber;

	public Person(String name, String surname, String nationality, Degree degree,
			EnglishCertification englishCertification, String emailAddress, LocalDate birthdate, int phoneNumber)
			throws IllegalArgumentException {
		this.setName(name);
		this.setSurname(surname);
		this.setNationality(nationality);
		this.setDegree(degree);
		this.setEnglishCertification(englishCertification);
		this.setEmailAddress(emailAddress);
		this.setBirthdate(birthdate);
		this.setPhoneNumber(phoneNumber);
	}

	public boolean isAdult() {
		return this.getAge() >= 18;
	}

	public boolean isEuropean() {
		for (EuropeanNationalities euNationality : EuropeanNationalities.values()) {
			if (this.getNationality().equalsIgnoreCase(euNationality.toString()))
				return true;
		}
		return false;
	}

	public boolean canEnrollDoctoralProgram() {
		if (this.getDegree().equals(Degree.MASTER) || this.getDegree().equals(Degree.DOCTORATE))
			return true;
		else
			return false;
	}

	public int getAge() {
		return Period.between(birthdate, LocalDate.now()).getYears();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws IllegalArgumentException {
		if (name.equals(""))
			throw new IllegalArgumentException("Name cannot be empty");
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if (surname.equals(""))
			throw new IllegalArgumentException("Surname cannot be empty");
		this.surname = surname;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public EnglishCertification getEnglishCertification() {
		return englishCertification;
	}

	public void setEnglishCertification(EnglishCertification englishCertification) {
		this.englishCertification = englishCertification;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		if (emailAddress.equals(""))
			throw new IllegalArgumentException("Email adress cannot be empty");
		this.emailAddress = emailAddress;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) throws IllegalArgumentException {
		if (birthdate == null)
			throw new IllegalArgumentException("Birthdate cannot be null");
		if (birthdate.isAfter(LocalDate.now()))
			throw new IllegalArgumentException("Birthdate cannot be in the future");

		this.birthdate = birthdate;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = Math.abs(phoneNumber);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", nationality=" + nationality + ", emailAddress="
				+ emailAddress + ", degree=" + degree + ", englishCertification=" + englishCertification
				+ ", birthdate=" + birthdate + ", phoneNumber=" + phoneNumber + "]";
	}

}
