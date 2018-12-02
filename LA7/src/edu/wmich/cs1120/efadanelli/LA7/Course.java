package edu.wmich.cs1120.efadanelli.LA7;

public class Course implements ICourse {

	String courseDept;
	int courseNumber;
	int capacity;
	LinkedList<Node> reigisteredStudents = new LinkedList<Node>();
	
	@Override
	public boolean isFull() {
		if(reigisteredStudents.size()+1 == capacity)
			return true;
		else 
			return false;
	}

	@Override
	public void addStudent(String name) {
		// TODO Auto-generated method stub
		if(!(isFull())) {
			Node<String> student = new Node<String>(name);
			reigisteredStudents.add(student);
		}
	}

	@Override
	public void printClassList() {
		// TODO Auto-generated method stub
		for(int i=0;i<reigisteredStudents.size();i++) {
			System.out.println(reigisteredStudents.get(i).getData());
		}
	}

}
