package attribute;

public class Student {
	private String studentNumber;
	private String name;
	private String sex;
	private String birthday;
	private String department;
	public Student(String studentNumber, String name,String sex,String birthday,String department) {
		this.studentNumber=studentNumber;
		this.name=name;
		this.sex=sex;
		this.birthday=birthday;
		this.department=department;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getDepartment() {
		return department;
	}
}
