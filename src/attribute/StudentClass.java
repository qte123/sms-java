package attribute;

public class StudentClass {
	private String classNumber;
	private String className;
	private int credit;
	public StudentClass(String classNumber,String className,int credit) {
		this.classNumber=classNumber;
		this.className=className;
		this.credit=credit;
	}
	public String getClassNumber() {
		return classNumber;
	}
	public String getClassName() {
		return className;
	}
	public int getCredit() {
		return credit;
	}
}
