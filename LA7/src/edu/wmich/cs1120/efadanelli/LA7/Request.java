package edu.wmich.cs1120.efadanelli.LA7;

public class Request implements Comparable<Request>{
	
	String name;//name of student
	String studentDept;//student Department
	String level;//student class standing
	String courseDept;//course Department
	int courseNumber;//course number
	double[][]GPA_Array;//the array of GPA information
	double GPA;//their calculated GPA
	
	/**
	 * The Request constructor initializes the student name, department, 
	 * class standing and their GPA. It also initializes the course 
	 * number and department.
	 * @param studentName name of the student
	 * @param studentDept department of the student
	 * @param studentLevel level of the student
	 * @param courseDept department of the course
	 * @param courseNumber number of the course
	 * @param GPA_Array the array holding the GPA information for each student
	 */
	public Request(String studentName, String studentDept, String studentLevel,
				String courseDept, int courseNumber, double[][] GPA_Array) {
		name = studentName;
		this.studentDept = studentDept;
		level = studentLevel;
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
		this.GPA_Array = GPA_Array;
		this.GPA = GPA_Cal(GPA_Array);
	}
	/**
	 *  Returns number of years to graduation (0 for seniors, 1 for juniors etc.). This is determined from the 
	 *  student’s level – senior, junior, etc.
	 * @param level the level of the student
	 * @return a number corresponding to their level
	 */
	public int yearsFromGraduation(String level) {
		if(level.equals("Senior"))//if the student is a senior
			return 0;//return zero
		else {
			if(level.equals("Junior"))//if student is a Junior
				return 1;//return 1
			else {
				if(level.equals("Sophmore"))//if studdent is a sophmore
					return 2;//return 2
				else {
						return 3;//student is a freshman, return 3
				}
			}
		}
	}

	/** 
	 * Calculate the GPA for a particular student.
	 * @param GPA_Array the array with GPA information
	 * @return the calculated GPA
	 */
	private double GPA_Cal(double[][] GPA_Array) {
		double gps = 0;//grade points is 0
		double credits = 0;//credits is 0
		for(int i=0;i<GPA_Array.length;i++) {
			gps = gps + GPA_Array[i][0];//add up grade points
			credits = credits + GPA_Array[i][1];//add up credits
		}			
		return (gps/credits);//divide gps by credits and return
	}
	/**
	 * This method compares the data in being sent by the student. 
	 * This is what selects where the nodes get Priority Queue up.
	 * 
	 * Method calling object is greater than the object it is comparing 
	 * the method returns a 1.
	 *  
	 * 
	 * @param the request to compare
	 */
	@Override
	public int compareTo(Request req) {
		
		if(!(req.studentDept.equals(req.courseDept))) //if the requested has a department different to the course department
			return(1);//return 1
		else {
			if(req.yearsFromGraduation(req.level) <  this.yearsFromGraduation(this.level))//if requested has a closer graduation date than requester
				return(-1);//return -1
			else {
				if(req.yearsFromGraduation(req.level) >  this.yearsFromGraduation(this.level))//if requested has a further graduation date than requester
					return(1);//return 1
				else {
					if(req.GPA < this.GPA)//if requested has a lower GPA than requester
						return(1);//return 1
					else {
						if(req.GPA > this.GPA)//if requester has a lower gpa than requested
							return(-1);//return -1
						else
							return(-1);//requested has a priority
					}
				}
			}
		}
	}
}