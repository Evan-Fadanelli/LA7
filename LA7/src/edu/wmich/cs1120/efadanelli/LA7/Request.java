package edu.wmich.cs1120.efadanelli.LA7;

public class Request<T> implements Comparable<T>{
	
	String name;
	String dept;
	String level;
	String courseDept;
	int courseNumber;
	double[][]GPA_Array;
	double GPA = GPA_Cal(GPA_Array);
	
	// Constructor
	public Request(String studentName, String studentDept, String studentLevel,
				String courseDept, int courseNumber, double[][] GPA_Array) {
		name = studentName;
		dept = studentDept;
		level = studentLevel;
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
		this.GPA_Array = GPA_Array;
	}
	// Returns number of years to graduation (0 for seniors, 1 for juniors etc.). This is determined from the 
	// student’s level – senior, junior, etc.
	public int yearsFromGraduation(String level) {
		if(level.equals("Senior"))
			return 0;
		else {
			if(level.equals("Junior"))
				return 1;
			else {
				if(level.equals("Sophmore"))
					return 2;
				else {
						return 3;
				}
			}
		}
	}

	// Calculate the GPA for a particular student.
	private double GPA_Cal(double[][] GPA_Array) {
		double gps = 0;
		double credits = 0;
		for(int i=0;i<GPA_Array.length;i++) {
			gps = gps + GPA_Array[i][0];
			credits = credits + GPA_Array[i][1];
		}			
		return (gps/credits);
	}
	@Override
	public int compareTo(T arg0) {
		// TODO Auto-generated method stub
		
		return 0;
	}
}
