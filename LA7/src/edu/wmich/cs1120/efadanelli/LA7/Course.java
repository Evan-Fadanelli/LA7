package edu.wmich.cs1120.efadanelli.LA7;

public class Course implements ICourse {

	String courseDept;//course department
	int courseNumber;//course number
	int capacity;//course capacity
	LinkedList<Node> reigisteredStudents = new LinkedList<Node>();//list of students registered for class
	
	/**
	 * Constructor for course class initializes all variables
	 * @param courseDept course department
	 * @param courseNumber couse nubmer
	 * @param capacity number of students course can hold
	 */
	public Course(String courseDept, int courseNumber, int capacity) {
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
		this.capacity = capacity;
	}
	
	/**
	 * Returns a boolean telling weather or not a class is full.
	 * @return true if it is full false if not
	 */
	@Override
	public boolean isFull() {
		if(reigisteredStudents.size() >= capacity)//if the registered students is greater or equal to capacity
			return true;//return true
		else //otherwise return false
			return false;
	}

	@Override
	/**
	 * Adds a student to the linkedlist of names
	 * @param name the name of the student
	 */
	public void addStudent(String name) {
		// TODO Auto-generated method stub
		if(!(isFull())) {//if the class is not full
			Node<String> student = new Node<String>(name);//make a new student Node
			reigisteredStudents.add(student);//add it to registered Student list
		}
	}

	@Override
	/**
	 * prints the list of students in the class
	 */
	public void printClassList() {
		// TODO Auto-generated method stub
		System.out.println("Students signed up for " + courseDept + courseNumber + ":");//tell the user what course this is
		for(int i=0;i<reigisteredStudents.size();i++) {//traverse through the registered student list
			System.out.println(reigisteredStudents.get(i).getData());//print the names of the students
		}
		System.out.println("");
	}

}
