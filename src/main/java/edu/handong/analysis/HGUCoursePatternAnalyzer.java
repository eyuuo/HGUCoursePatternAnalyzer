package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	int numOfStudents; //total number of students
	int numOfCourses; //total number of courses
	Student[] students; //save student list from the lines
	Course[] courses; //save course list from the lines
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = 3;//Integer.parseInt(args[0]);
		numOfCourses = 6;//Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		students = new Student[this.numOfStudents];
		Student[] students2 = new Student[lines.length];
		
		for(int i=0;i<lines.length;i++) {
			students2[i] = new Student(lines[i].split(",")[1].trim()); 
		}
		
		for(int i=0;i<this.numOfStudents;i++) {
			students[i] = new Student(" "); 
		}
	
	
		for(int i=0;i<numOfStudents;) {
			for(int j=0;j<lines.length;j++) {
				if(studentExist(students,students2[j])==false){
					students[i] = new Student(lines[j].split(",")[1].trim()); i++;
					break;
					}
			}
		} 
		return students;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		// TODO: implement this method
		boolean same =true;

		for(int i=0;i<this.numOfStudents;i++){
			if(students[i].getName().equals(student.getName())){  same =true; return same; }
			else {same = false;}
			}
		return same;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		courses = new Course[this.numOfCourses];
		Course[] courses2 = new Course[lines.length];
		
		for(int i=0;i<lines.length;i++) {
			courses2[i] = new Course(lines[i].split(",")[2].trim()); 
		}
		
		for(int i=0;i<this.numOfCourses;i++) {
			courses[i] = new Course(" "); 
		}

		for(int i=0;i<numOfCourses;) {
			for(int j=0;j<lines.length;j++) {
				if(courseExist(courses,courses2[j])==false){
					courses[i] = new Course(lines[j].split(",")[2].trim()); i++;
					break;
					}
			}
		} 
		
		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		boolean same =true;

		for(int i=0;i<this.numOfCourses;i++){
			if(courses[i].getCourseName().equals(course.getCourseName())){  same =true; return same; }
			else {same = false;}
			}
		return same;
	}

}
