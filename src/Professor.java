package src;

import java.util.*;

public class Professor implements Person  {
    private int professorID;
    private String professorName; 
    private String email;
    private int courseID1;
    private int courseID2;
    private int courseID3;
    private Map<String, Integer> officeHours = new HashMap<>();
    
    public Professor(int professorID, String professorName,  String email, int courseID1, int courseID2, int courseID3) {
        this.professorID = professorID;
        this.professorName = professorName;
        this.email = email;
        this.courseID1 = courseID1;
        this.courseID2 = courseID2;
        this.courseID3 = courseID3;
    }
    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }
    public int getProfessorID() {
        return professorID;
    }
    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }
    public String getProfessorName() {
        return professorName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public int getCourseID1() {
        return courseID1;
    }
    public void setCourseID1(int courseID1) {
        this.courseID1 = courseID1;
    }
    public int getCourseID2() {
        return courseID2;
    }
    public void setCourseID2(int courseID2) {
        this.courseID2 = courseID2;
    }
    public int getCourseID3() {
        return courseID3;
    }
    public void setCourseID3(int courseID3) {
        this.courseID3 = courseID3;
    }
    public Map<String, Integer> getOfficeHours() {
        return officeHours;
    }
    public void setOfficeHours(Map<String, Integer> officeHours) {
        this.officeHours = officeHours;
    }
    
    private Student verifyProfInputs(List<Student> studentsList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Professor ID: ");
        int profInput = scanner.nextInt();
        if (profInput != this.professorID) {
            System.out.println("Error: Wrong Professor ID. Please Try Again.");
            return null;
        }
        System.out.print("Enter Student ID: ");
        int studentIDInput = scanner.nextInt();
        for (Student s : studentsList) {
            if (s.getStudID() == studentIDInput) {
                return s;
            }
        }
        System.out.println("Student not found.");
        return null;
    }

    
    public void approveStudent(List<Student> studentsList) {
        Student studentEX = verifyProfInputs(studentsList);
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        for(Course c :  studentEX.getCourses()){
            if (studentEX.getGrades()[count] == null && checkIfCourseIsTaughtByProfessor(c)){ 
                System.out.println("Approve Student for " + c.getCourseName() + "? Enter Y or N: ");
                String input = scanner.next();
                if (input.equalsIgnoreCase("Y")) {
                    studentEX.getGrades()[count] = new Grades();
                    studentEX.getGrades()[count].setGradeID(100);
                    System.out.println("Approved Student");
                } else {
                    System.out.println("Didn't Approve Student");
                }
            }
            count++;
        }
    }
    
    public boolean checkIfCourseIsTaughtByProfessor(Course c) {
        if (c.getCourseID() == courseID1 || c.getCourseID() == courseID2 || c.getCourseID() == courseID3) {
            return true;
        }
        return false;
    }

    
    public void dropStudent(List<Student> studentsList) {
        Student studentEX = verifyProfInputs(studentsList);
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        
        for(Course c :  studentEX.getCourses()){
            
            if (studentEX.getGrades()[count] != null && checkIfCourseIsTaughtByProfessor(c)){ 
                System.out.println("Drop Student for " + c.getCourseName() + "? Enter Y or N: ");
                String input = scanner.next();
                if (input.equalsIgnoreCase("Y")) {
                    studentEX.getGrades()[count] = new Grades();
                    studentEX.getCourses()[count] = new Course(); 
                    System.out.println("Dropped Student");
                } else {
                    System.out.println("Didn't Drop Student");
                }
            }
            count++;
        }


    }
    
    public void addOfficeHours(Course[] coursesList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Professor ID: ");
        int profInput = scanner.nextInt();
        if (profInput != this.professorID) {
           System.out.println("Error: Wrong Professor ID. Please Try Again.");
           return;
        }
        System.out.println("Enter Course ID to set your desired Office Hours for:");
        int courseIDInput = scanner.nextInt();
        Course courseEX = null;
        for (Course c : coursesList) {
            if (c.getCourseID() == courseIDInput && checkIfCourseIsTaughtByProfessor(c)) {
                courseEX = c;
                break;
            }
        }
        System.out.println("Set your Office Hours: ");
        int officeHoursSlot = scanner.nextInt();
        if (officeHoursSlot == courseEX.getTime()) {
            System.out.println("Error: Conflicting with course time!");
            return;
        }
        officeHours.put(courseEX.getCourseName(), officeHoursSlot);
        System.out.println(courseEX.getCourseName() + "| Office Hours: " + officeHoursSlot);

    }
    
    public void removeOfficeHours(Course[] coursesList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Professor ID: ");
        int profInput = scanner.nextInt();
        if (profInput != this.professorID) {
            System.out.println("Error: Wrong Professor ID. Please Try Again.");
            return;
        }
        System.out.println("Enter Course ID to remove Office Hours for:");
        int courseIDInput = scanner.nextInt();
        Course courseEX = null;
        for (Course c : coursesList) {
            if (c.getCourseID() == courseIDInput && checkIfCourseIsTaughtByProfessor(c)) {
                courseEX = c;
                break;
            }
        }
        if (!officeHours.containsKey(courseEX.getCourseName())) {
            System.out.println("No office hours set for this course.");
            return;
        }
        officeHours.remove(courseEX.getCourseName());
        System.out.println("Removed office hours for: " + courseEX.getCourseName());
        System.out.println(courseEX.getCourseName() + "| Office Hours: N/A");
    }

    public void printInfo(Course[] coursesList) {
        System.out.println("Professor " + professorName + "'s Schedule:" );
        for (Course course: coursesList) {
            int id = course.getCourseID();
            if (id == courseID1 || id == courseID2 || id == courseID3 ) {
                String printOfficeHours;
                if (officeHours.containsKey(course.getCourseName())) {
                    printOfficeHours = String.valueOf(officeHours.get(course.getCourseName()));
                } else {
                    printOfficeHours = "N/A";
                }
                System.out.println("Course: " + course.getCourseName() + " | Course ID: " + course.getCourseID() + 
                " | Course Time: " + course.getTime() + " | Office Hours: " + printOfficeHours);
            }
        }
    }

    public void submitAssignment(int index, Student[] studentsList) {

        if (index < 0 || index >= Student.MAX_SLOTS) {
            throw new IndexOutOfBoundsException("index must be 0..5");
        }
        if (studentsList == null || studentsList.length == 0) {
            System.out.println("No student for this professor.");      
            return;  
        }

        Student studentInClass = null;
        for (Student s : studentsList) {
            if (s != null) {
                Course[] c = s.getCourses();
                if (index < c.length && c[index] != null) {
                    Course study = c[index];
                    int courseIDs = study.getCourseID();
                    if (courseIDs == this.courseID1 || courseIDs == this.courseID2 || courseIDs == this.courseID3) {
                        studentInClass = s;
                        break;
                    }
                }
            }
        }
        
        if (studentInClass == null) {
            System.out.println("Student not found in this course index.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the points to deduct from student: ");
        while (!sc.hasNextInt()) {
            System.out.println("Please enter an integer number.");
            sc.next();
        }
        int pointsDeducted = Math.abs(sc.nextInt());
        Grades currentGrade = studentInClass.getGrades()[index];
        if (currentGrade == null) {
            System.out.println("There is no grade for this student. Grade cannot be deducted.");
            return;
        }

        Integer currentGradeValue = currentGrade.getGradeID();
        if (currentGradeValue == null || currentGradeValue == -1) {
            currentGradeValue = 0;
        }
        int newGrade = currentGradeValue - pointsDeducted;
        currentGrade.setGradeID(newGrade);
    }

}

    


    


    


    
