package ua.prog.java.lesson8;

public class Main {

	public static void main(String[] args) {

		Student studentOne = new Student(24, "Sergii", "Lukavenko", "male");
		Student studentTwo = new Student(18, "Timofii", "Lukavenko", "male");
		Student studentThree = new Student(20, "Antonina", "Lukavenko", "female");
		Student studentFour = new Student(31, "Vasyl", "Petrovych", "male");
		Student studentFive = new Student(30, "Tetiana", "Mykolaivna", "female");

		Group groupOne = new Group("La51");
		groupOne.addStudent(studentOne);
		groupOne.addStudent(studentTwo);
		groupOne.addStudent(studentThree);
		groupOne.addStudent(studentFour);
		groupOne.addStudent(studentFive);

		System.out.println(groupOne.toString());

		GroupManagement groupsManager = new GroupManagement();
		String filePathGroup = "C:/JAVA/University/saveGroup.txt";
		groupsManager.storeGroupToFile(filePathGroup, groupOne);

		Faculty faculty = new Faculty();
		faculty.addGroup(groupOne);

		groupsManager.restoreGroupFromFile(filePathGroup);
		Group groupTwo = new Group();
		groupTwo = groupsManager.getGroup();

		groupTwo.setName("IA52");
		groupTwo.addStudent(new Student(50, "Vlad", "Vladislavovych", "male"));
		System.out.println(groupTwo.toString());

		faculty.addGroup(groupTwo);

		FacultyManagement facultyManager = new FacultyManagement();
		String filePathFaculty = "C:/JAVA/University/saveFaculty.txt";
		facultyManager.storeFacultyToFile(filePathFaculty, faculty);

		facultyManager.restoreFacultyFromFile(filePathFaculty);
		Faculty restoredFaculty = new Faculty();
		restoredFaculty = facultyManager.getFaculty();
		System.out.println(restoredFaculty.toString());
	}
}
