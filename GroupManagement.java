package ua.prog.java.lesson8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GroupManagement {

	private Group group;

	public GroupManagement() {
		// TODO Auto-generated constructor stub
	}

	public Group getGroup() {
		return this.group;
	}

	public boolean storeGroupToFile(String filePath, Group groupToFile) {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
			oos.writeObject(groupToFile);
		} catch (IOException e) {
			System.out.println("Some IO Error in putStringToFile module");
			System.out.println(e.getMessage());
			return false;
		}
		System.out.println("Group \"" + groupToFile.getName() + "\" has been successfully stored to file.");
		return true;
	}

	public boolean restoreGroupFromFile(String filePath) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
			group = (Group) ois.readObject();
		} catch (IOException e) {
			System.out.println("Some IO Error in putStringToFile module");
			return false;
		} catch (ClassNotFoundException e) {
			System.out.println("File not found during deSerializing process of students Group from file");
			return false;
		}
		System.out.println("Group \"" + group.getName() + "\" has been successfully restored.");
		return true;
	}

}
