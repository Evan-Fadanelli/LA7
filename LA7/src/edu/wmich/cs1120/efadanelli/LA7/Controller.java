package edu.wmich.cs1120.efadanelli.LA7;

import java.io.*;
import java.util.Scanner;

public class Controller implements IController{

	BufferedReader courseFileInput;
	BufferedReader requestFileInput;
	LinkedList<Course> courses;
	PriorityQueue<Request> queue;
	
	public Controller(PriorityQueue<Request> requestQueue,LinkedList<Course> courses,BufferedReader courseFile,BufferedReader requestFile){
		courseFileInput = courseFile;
		requestFileInput = requestFile;
		this.courses = courses;
		queue = requestQueue;
	}
	
	public static void main(String[] args) throws IOException {
		
		PriorityQueue<Request> requestQueue = new PriorityQueue<Request>();
		LinkedList<Course> courses = new LinkedList<Course>();
		BufferedReader fileIn = new BufferedReader(new FileReader("course.txt"));
		BufferedReader fileIn1 = new BufferedReader(new FileReader("request.txt"));
		IController control = new Controller(requestQueue, courses, fileIn, fileIn1);
		control.readCourseFile();
		control.readRequestFile();
		control.processRequests();
		control.printClassList();
	}

	
	@Override
	public void readCourseFile() {
		Scanner fileReader = new Scanner(courseFileInput);
		while(fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			System.out.println(line);
			String[] lineA = line.split(",");
			Course room = new Course(lineA[0],Integer.parseInt(lineA[1]),Integer.parseInt(lineA[2]));
			courses.add(room);
		}
		System.out.println("");
		fileReader.close();
	}

	@Override
	public void readRequestFile() {
		
		Scanner fileReader = new Scanner(requestFileInput);
		while(fileReader.hasNextLine()) {
			String[] line = fileReader.nextLine().split(",");
			double[][] GPA_Array = new double[4][2];
			int j = 0;
			for(int i=5;i<line.length;i=i+2) {
				GPA_Array[j][0] = Double.parseDouble(line[i]);
				GPA_Array[j][1] = Double.parseDouble(line[i+1]);
				j++;
			}
			Request req = new Request(line[0].trim(), line[2].trim(), line[1].trim(), line[3].trim(), Integer.parseInt(line[4]), GPA_Array);
			addRequest(req);
		}
		queue.Qprint();
		fileReader.close();
	}

	@Override
	public void addRequest(Request req) {
		
		queue.enqueue(req);
	}

	@Override
	public void processRequests() {
	
		while(!(queue.isEmpty())){
			Request req = queue.dequeue();
			System.out.println("Processing request " + req);
			boolean fail = true;
			for(int i=0;i<courses.size();i++) {
				if(req.courseDept.equals(courses.get(i).courseDept) && !(courses.get(i).isFull()) && req.courseNumber == courses.get(i).courseNumber) {
					fail=false;
					System.out.println("Succesfully added " + req.name + " to " + courses.get(i).courseDept + courses.get(i).courseNumber);
					courses.get(i).addStudent(req.name);
				}
			}
			if(fail)
				System.out.println("Faied to process request " + req);
		}
		System.out.println("");
		queue.Qprint();
	}

	@Override
	public Course getCourse(String courseDept, int courseNumber) {
		
		for(int i=0;i<courses.size();i++) {
			if(courseDept.equals(courses.get(i).courseDept) && courseNumber == courses.get(i).courseNumber)
				return courses.get(i);
		}
			return null;
	}

	@Override
	public void printClassList() {
		
		for(int i=0;i<courses.size();i++) {
			courses.get(i).printClassList();
		}
	}
}
