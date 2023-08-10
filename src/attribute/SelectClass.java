package attribute;

public class SelectClass {

	private String studentNumber;
	private String classNumber;
	private int record;

	public SelectClass(String studentNumber, String classNumber, int record) {
		this.studentNumber=studentNumber;
		this.classNumber=classNumber;
		this.record=record;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public String getClassNumber() {
		return classNumber;
	}
	public int getRecord() {
		return record;
	}

}
