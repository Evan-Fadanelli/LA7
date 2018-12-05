package edu.wmich.cs1120.efadanelli.LA7;

import java.io.*;
import java.util.Scanner;

public class Controller implements IController{

	BufferedReader courseFileInput;//the input file for course
	BufferedReader requestFileInput;//input file for requests
	LinkedList<Course> courses;//list of courses
	PriorityQueue<Request> queue;//queue of requests
	
	/**
	 * The constructor for controller
	 * @param requestQueue the priority queue of requests
	 * @param courses the linkedlist of courses
	 * @param courseFile the file with course data
	 * @param requestFile the file with request data
	 */
	public Controller(PriorityQueue<Request> requestQueue,LinkedList<Course> courses,BufferedReader courseFile,BufferedReader requestFile){
		courseFileInput = courseFile;
		requestFileInput = requestFile;
		this.courses = courses;
		queue = requestQueue;
	}//END OF THE CONSTRUCTOR
	
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
	}//END OF MAIN

	/*
	 * This method reads the Course file and puts the Course objects into
	 * a Course Array list
	 */
	@Override
	public void readCourseFile() {
		Scanner fileReader = new Scanner(courseFileInput);//Scanner declared 
		while(fileReader.hasNextLine()) {//while the Scanner has a next line
			String line;
			try{						 //A try catch to get the next line in the file
				line = fileReader.nextLine();//line gets the next string from the file
			}catch(NullPointerException e) {
				System.out.println("No line was found in the coursefile");//if no line in the file this will print out to USER
				line = null;//line gets null
			}
			System.out.println(line);//prints the String recived 
			String[] lineA = line.split(",");//splits the String into an array of strings
			Course room = new Course(lineA[0],Integer.parseInt(lineA[1]),Integer.parseInt(lineA[2]));//creat a course class object
			courses.add(room);//add the course object to the course array list
		}
		System.out.println("");//spacing
		fileReader.close();//close the Scanner
	}//END OF METHOD readCourseFile

	/*
	 * This method reads the Request file and calculates the GPA of that students
	 * and adds the students request to be put into the Priority Queue.
	 */
	@Override
	public void readRequestFile() {
		
		Scanner fileReader = new Scanner(requestFileInput);//Scanner declared 
		while(fileReader.hasNextLine()) {
			String[] line;
			try {//A try catch to get the next line in the file
				line = fileReader.nextLine().split(",");//split the string into tokens
			}catch(NullPointerException e){
				System.out.println("No linen was found in the request file");//print out to USER
				line = null;//line gets null
			}
			double[][] GPA_Array = new double[4][2];//Declared the size of the array
			int j = 0;
			for(int i=5;i<line.length;i=i+2) {//a for-loop to enter in the GPA and credit weight 
				GPA_Array[j][0] = Double.parseDouble(line[i]);
				GPA_Array[j][1] = Double.parseDouble(line[i+1]);
				j++;
			}
			Request req = new Request(line[0].trim(), line[2].trim(), line[1].trim(), line[3].trim(), Integer.parseInt(line[4]), GPA_Array);//creates a request class object
			addRequest(req);//sent it to the queue
		}//end of while loop
		queue.Qprint();//prints all of the nodes in queue
		fileReader.close();//close the Scanner
	}//END OF METHOD readRequestFile

	/*
	 * This method adds a request to the queue
	 */
	@Override
	public void addRequest(Request req) {
		
		queue.enqueue(req);
	}//END OF METHOD addRequest

	/*
	 * This method processes the Requests and puts them into the classes the students asked for
	 * unless the class has no more spots in the class then it fails.
	 */
	@Override
	public void processRequests() {
	
		while(!(queue.isEmpty())){//while the queue is not empty
			Request req = queue.dequeue();//get the most prioritized node out of queue
			System.out.println("Processing request " + req);//print out to USER
			boolean fail = true;//fail gets true
			for(int i=0;i<courses.size();i++) {//for-loop to register the student into the course 
				if(req.courseDept.equals(courses.get(i).courseDept) && !(courses.get(i).isFull()) && req.courseNumber == courses.get(i).courseNumber) {
					fail=false;//fail gets fails
					System.out.println("Succesfully added " + req.name + " to " + courses.get(i).courseDept + courses.get(i).courseNumber);//prints out to USER
					courses.get(i).addStudent(req.name);//add the students name to the course
				}
			}
			if(fail)
				System.out.println("Faied to process request " + req);//if fail is true then print to USER
		}
		System.out.println("");//SPACING
		queue.Qprint();//prints the nodes in queue
	}//END OF METHOD processRequests

	/*
	 * This method returns the Course that is selected by the courseDept & courseNumber
	 */
	@Override
	public Course getCourse(String courseDept, int courseNumber) {
		
		for(int i=0;i<courses.size();i++) {
			if(courseDept.equals(courses.get(i).courseDept) && courseNumber == courses.get(i).courseNumber)//if the course that is asked matche up with
				return courses.get(i);//returns course														 the data base
		}
			return null;//return null
	}//END OF METHOD getCourse

	/*
	 * This method prints the class list 
	 */
	@Override
	public void printClassList() {
		
		for(int i=0;i<courses.size();i++) {
			courses.get(i).printClassList();//prints to USER
		}
	}//END OF METHOD printClassList
}//END OF CLASS Controller
