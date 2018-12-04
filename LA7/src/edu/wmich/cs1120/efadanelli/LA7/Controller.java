package edu.wmich.cs1120.efadanelli.LA7;

import java.io.*;
import java.util.Scanner;

public class Controller implements IController{

	BufferedReader courseFileInput;
	BufferedReader requestFileInput;
	LinkedList<Course> coursesInput;
	PriorityQueue<Request> queue;
	
	public Controller(PriorityQueue<Request> requestQueue,LinkedList<Course> courses,BufferedReader courseFile,BufferedReader requestFile){
		courseFileInput = courseFile;
		requestFileInput = requestFile;
		coursesInput = courses;
		queue = requestQueue;
	}
	
	public static void main(String[] args) throws IOException {// Two main strings?
		
		PriorityQueue<Request> requestQueue = new PriorityQueue<Request>();
		LinkedList<Course> courses = new LinkedList<Course>();
		BufferedReader fileIn = new BufferedReader(new FileReader("course.txt"));
		BufferedReader fileIn1 = new BufferedReader(new FileReader("request.txt"));
		IController control = new Controller(requestQueue, courses, fileIn, fileIn1);
		control.readCourseFile();
		control.readRequestFile();
//		control.processRequests();
//		control.printClassList();
	}

	
	@Override
	public void readCourseFile() {
		Scanner fileReader = new Scanner(courseFileInput);
		while(fileReader.hasNextLine()) {
			String[] line = fileReader.nextLine().split(",");
			Course room = new Course(line[0],Integer.parseInt(line[1]),Integer.parseInt(line[2]));
			coursesInput.add(room);
		}
		fileReader.close();
	}

	@Override
	public void readRequestFile() {
		// TODO Auto-generated method stub
		Scanner fileReader = new Scanner(requestFileInput);
		while(fileReader.hasNextLine()) {
			System.out.println("READING FILE LINE");
			String[] line = fileReader.nextLine().split(",");
			double[][] GPA_Array = new double[4][2];
			int j = 0;
			for(int i=5;i<line.length;i=i+2) {
				GPA_Array[j][0] = Double.parseDouble(line[i]);
				GPA_Array[j][1] = Double.parseDouble(line[i+1]);
				j++;
			}
			Request req = new Request(line[0], line[2], line[1], line[3], Integer.parseInt(line[4]), GPA_Array);
			addRequest(req);
		}
		fileReader.close();
	}

	@Override
	public void addRequest(Request req) {
		// TODO Auto-generated method stub
		queue.enqueue(req);
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