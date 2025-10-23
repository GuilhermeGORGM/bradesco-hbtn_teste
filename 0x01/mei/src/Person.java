
import java.util.Calendar;
import java.util.Date;

public class Person {

	private String name;
	private String surname;
	private Date birthDate;
	private boolean anotherCompanyOwner;
	private boolean pensioner;
	private boolean publicServer;
	private float salary;

	public Person(String name, String surname, Date birthDate, boolean anotherCompanyOwner, boolean pensioner,
			boolean publicServer, float salary) {
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.anotherCompanyOwner = anotherCompanyOwner;
		this.pensioner = pensioner;
		this.publicServer = publicServer;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isAnotherCompanyOwner() {
		return anotherCompanyOwner;
	}

	public void setAnotherCompanyOwner(boolean anotherCompanyOwner) {
		this.anotherCompanyOwner = anotherCompanyOwner;
	}

	public boolean isPensioner() {
		return pensioner;
	}

	public void setPensioner(boolean pensioner) {
		this.pensioner = pensioner;
	}

	public boolean isPublicServer() {
		return publicServer;
	}

	public void setPublicServer(boolean publicServer) {
		this.publicServer = publicServer;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String fullName() {
		return this.name + " " + this.surname;
	}

	public float calculateYearlySalary() {
		return this.salary * 12;
	}

	private int getAge() {
		Calendar today = Calendar.getInstance();
		Calendar birth = Calendar.getInstance();
		birth.setTime(this.birthDate);
		int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);

		if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
			age--;
		}
		return age;
	}

	public boolean isMEI() {
		boolean incomeOk = calculateYearlySalary() < 130000;
		boolean ageOk = getAge() >= 18;
		boolean ownershipOk = !anotherCompanyOwner;
		boolean pensionOk = !pensioner;
		boolean serverOk = !publicServer;

		return incomeOk && ageOk && ownershipOk && pensionOk && serverOk;
	}
}
