package ua.prog.java.lesson8;

import java.io.Serializable;
import java.util.Arrays;

public class Faculty implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name = "KievProgUa";
	private int maxNumberOfGroups = 2;
	private int currentFacultySize;
	private Group[] groupsOfFaculty = new Group[maxNumberOfGroups];

	public Faculty() {
		// TODO Auto-generated constructor stub
	}

	public int getMaxNumberOfGroups() {
		return maxNumberOfGroups;
	}

	public void setMaxNumberOfGroups(int maxNumberOfGroups) {
		this.maxNumberOfGroups = maxNumberOfGroups;
	}

	public String getName() {
		return name;
	}

	public int getCurrentGroupSize() {
		return currentFacultySize;
	}

	private Boolean isGroupAlreadyIn(Group checkedGroup) {
		for (Group group : groupsOfFaculty) {
			if (group != null) {
				if (group.getName() == checkedGroup.getName()) {
					return true;
				}
			}
		}
		return false;
	}

	public void addGroup(Group newGroup) {
		if (isGroupAlreadyIn(newGroup)) {
			System.out.println("Group " + newGroup.getName().toString() + " already exists.");
			return;
		}
		int counterFirstFreeSpaceInFaculty = -1;
		int counterGroupInFaculty = 0;
		for (Group group : groupsOfFaculty) {
			counterFirstFreeSpaceInFaculty += 1;
			if (group == null) {
				groupsOfFaculty[counterFirstFreeSpaceInFaculty] = newGroup;
				break;
			} else {
				counterGroupInFaculty += 1;
			}
		}
		if (counterGroupInFaculty == maxNumberOfGroups) {
			System.out.println("Group has not been added because the current Faculty is fullfilled.");
			return;
		}
		System.out.println("Group \"" + newGroup.getName() + "\" has been added to Faculty.");
	}

	@Override
	public String toString() {
		return "\nFaculty [name=" + name + "]\ngroupsOfFaculty:\n" + Arrays.toString(groupsOfFaculty) + "]";
	}

}
