package edu.wmich.cs1120.efadanelli.LA7;

import java.io.BufferedReader;
import java.util.Scanner;

public class Controller implements IController {

	BufferedReader courseFileInput;
	BufferedReader requestFileInput;
	LinkedList<Course> coursesInput;
	PriorityQueue<Request> queue;
	public Controller(PriorityQueue<Request> requestQueue,LinkedList<Course> courses,BufferedReader courseFile,BufferedReader requestFile)
	{
		courseFileInput = courseFile;
		requestFileInput = requestFile;
		coursesInput = courses;
		queue = requestQueue;
		
		
	}
	
	@Override
	public void readCourseFile() {
		Scanner pizza = new Scanner(courseFileInput);
		//E pine = pizza.nextLine();
	//	coursesInput.add(pine);
		pizza.close();
	}

	@Override
	public void readRequestFile() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRequest(Request req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processRequests() {
		// TODO Auto-generated method stub

	}

	@Override
	public Course getCourse(String courseDept, int courseNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printClassList() {
		// TODO Auto-generated method stub

	}

}
