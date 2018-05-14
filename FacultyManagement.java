package ua.prog.java.lesson8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FacultyManagement {

	private Faculty faculty;

	public FacultyManagement() {

	}

	public Faculty getFaculty() {
		return faculty;
	}

	public boolean storeFacultyToFile(String filePath, Faculty facultyToFile) {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
			oos.writeObject(facultyToFile);
		} catch (IOException e) {
			System.out.println("Some IO Error in putStringToFile module");
			System.out.println(e.getMessage());
			return false;
		}
		System.out.println("Faculty has been successfully stored to file.");
		return true;
	}

	public boolean restoreFacultyFromFile(String filePath) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
			faculty = (Faculty) ois.readObject();
		} catch (IOException e) {
			System.out.println("Some IO Error in putStringToFile module");
			return false;
		} catch (ClassNotFoundException e) {
			System.out.println("File not found during deSerializing process of Faculty from file");
			return false;
		}
		System.out.println("Faculty has been successfully restored.");
		return true;
	}

}
