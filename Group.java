package ua.prog.java.lesson8;

import java.io.Serializable;

public class Group implements Serializable {
	private static final long serialVersionUID = 1L;
	private int maxGroupSize = 20;
	private int currentGroupSize;
	private String name;
	private Student[] studentsGroup = new Student[maxGroupSize];
	private String groupVisualisation;

	public Group(String name) {
		super();
		this.name = name;
	}

	public Group() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private void convertGroupToNiceString() {
		groupVisualisation = "";
		currentGroupSize = 0;
		for (Student st : studentsGroup) {
			if (st != null) {
				currentGroupSize++;
				groupVisualisation += st.toString() + "\n";
			}
		}
	}

	private Boolean isStudentAlreadyIn(Student checkedStudent) {
		for (Student student : studentsGroup) {
			if (student != null) {
				if (student.equals(checkedStudent)) {
					return true;
				}
			}
		}
		return false;
	}

	public void addStudent(Student newStudent) {
		if (isStudentAlreadyIn(newStudent)) {
			System.out.println("Student " + newStudent.toString() + " is in the group already.");
			return;
		}
		int counterFirstFreeSpaceInGroup = -1;
		int counterStudentInGroup = 0;
		for (Student student : studentsGroup) {
			counterFirstFreeSpaceInGroup += 1;
			if (student == null) {
				studentsGroup[counterFirstFreeSpaceInGroup] = newStudent;
				break;
			} else {
				counterStudentInGroup += 1;
			}
		}
		if (counterStudentInGroup == maxGroupSize) {
			System.out.println("Student has not been added because the current group is fullfilled.");
			return;
		}
	}

	@Override
	public String toString() {
		convertGroupToNiceString();
		return "\nGroup [name=" + name + "; size=" + currentGroupSize + " students]:\n" + groupVisualisation;
	}

}
