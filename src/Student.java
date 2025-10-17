package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public abstract class Student implements Person {

    public static final int MAX_SLOTS = 6;
    private final Integer studID;
    private String name;
    private String email;
    private Double GPA;
    private String major;

    public final Grade[] grades = {new Grade(), new Grade(), new Grade(), new Grade(), new Grade(), new Grade()};
    public final Professor[] professors = { new Professor(), new Professor(), new Professor(), new Professor(), new Professor(), new Professor()};
    public final Course[] courses = {new Course(), new Course(), new Course(), new Course(), new Course(), new Course()};

    public Map<String, Integer> Schedule = new HashMap<>();
    public List<Course> roadmapCourseList = new ArrayList<>(); 

    protected Student(Integer studID, String name, String email, String major) {
        if (studID == null) throw new IllegalArgumentException("studID cannot be null");
        this.studID = studID;
        this.name = name;
        this.email = email;
        this.GPA = 0.0;
        this.major = major;
    }

    // MAIN METHOD
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("  -  Enroll Student (Enter e for enroll) (Default SID is 1111111)  -  ");
            System.out.println("  -  Professor Methods (Enter t to access)  -  ");
            System.out.println("  -  Access Students (Enter s to access)  -  ");
            String studentCheck = sc.next();
            if (studentCheck.equals("e") || studentCheck.equals("E")){

                System.out.println("Enter Student name: ");
                String newStudentName = sc.next();
                System.out.println("Enter Student email: ");
                String newStudentEmail = sc.next();
                System.out.println("Enter Student major (CS, CMPE, or ENGR): ");
                String newStudentMajor = sc.next();
                System.out.println("Enter Student type: (1 for PartTimeMajor, 2 for FullTimeMajor)");
                int newStudentType = sc.nextInt();
                if(newStudentType == 1) {
                    PartTimeStudent currentPartStud = new PartTimeStudent(1111111, newStudentName, newStudentEmail, newStudentMajor);
                    studentsList.add(currentPartStud);
                    PART_TIME_STUDENTS.add(currentPartStud);
                    while(true) {
                        System.out.println("What would you like to do?");
                        System.out.println("Enter 1 for Applying/Dropping Courses: ");
                        System.out.println("Enter 2 for Managing Class Schedule: ");
                        System.out.println("Enter 3 for Graduation Info and Management: ");
                        System.out.println("Enter 4 for Personal/Student Info and Management: ");
                        int d1 = sc.nextInt();
                        if (d1 == 1) {
                            ApplyingDroppingCourses(currentPartStud);
                            System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                            String c1 = sc.next();
                            if(c1.equals("EXIT")){
                                break;
                            } else {
                                continue;
                            }
                        } else if (d1 == 2) {
                            ManagingClassSchedule(currentPartStud);
                            System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                            String c1 = sc.next();
                            if(c1.equals("EXIT")){
                                break;
                            } else {
                                continue;
                            }
                        } else if (d1 == 3) {
                            GraduationIM(currentPartStud);
                            System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                            String c1 = sc.next();
                            if(c1.equals("EXIT")){
                                break;
                            } else {
                                continue;
                            }
                        } else if (d1 == 4) {
                            PersonalIM(currentPartStud);
                            System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                            String c1 = sc.next();
                            if(c1.equals("EXIT")){
                                break;
                            } else {
                                continue;
                            }
                        } else {
                            System.out.println("Invalid Input (Try Again)");
                            continue;
                        }
                    }
                } else if (newStudentType == 2) {
                    FullTimeStudent currentFullStud = new FullTimeStudent(1111111, newStudentName, newStudentEmail, newStudentMajor);
                    studentsList.add(currentFullStud);
                    FULL_TIME_STUDENTS.add(currentFullStud);
                    while(true) {
                        System.out.println("What would you like to do?");
                        System.out.println("Enter 1 for Applying/Dropping Courses: ");
                        System.out.println("Enter 2 for Managing Class Schedule: ");
                        System.out.println("Enter 3 for Graduation Info and Management: ");
                        System.out.println("Enter 4 for Personal/Student Info and Management: ");
                        int d1 = sc.nextInt();
                        if (d1 == 1) {
                            ApplyingDroppingCourses(currentFullStud);
                            System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                            String c1 = sc.next();
                            if(c1.equals("EXIT")){
                                break;
                            } else {
                                continue;
                            }
                        } else if (d1 == 2) {
                            ManagingClassSchedule(currentFullStud);
                            System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                            String c1 = sc.next();
                            if(c1.equals("EXIT")){
                                break;
                            } else {
                                continue;
                            }
                        } else if (d1 == 3) {
                            GraduationIM(currentFullStud);
                            System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                            String c1 = sc.next();
                            if(c1.equals("EXIT")){
                                break;
                            } else {
                                continue;
                            }
                        } else if (d1 == 4) {
                            PersonalIM(currentFullStud);
                            System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                            String c1 = sc.next();
                            if(c1.equals("EXIT")){
                                break;
                            } else {
                                continue;
                            }
                        } else {
                            System.out.println("Invalid Input (Try Again)");
                            continue;
                        }
                    }
                }
            } else if (studentCheck.equals("t") || studentCheck.equals("T")) {
                System.out.println("Enter Professor ID");
                int p1 = sc.nextInt();
                int count = 0;
                for (Professor p : professorsList) {
                    if (p.getProfessorID() == p1) {
                        System.out.println("Enter 1 to drop office hours, Enter 2 to add office hours, Enter 3 to drop Student, Enter 4 to view info: ");
                        break;
                    }
                    count++;
                }
                int o1 = sc.nextInt();
                if(o1 == 1) {
                    professorsList.get(count).removeOfficeHours();
                    System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                    String c1 = sc.next();
                    if(c1.equals("EXIT")){
                        break;
                    } else {
                        continue;
                    }
                } else if(o1 == 2) {
                    professorsList.get(count).addOfficeHours();
                    System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                    String c1 = sc.next();
                    if(c1.equals("EXIT")){
                        break;
                    } else {
                        continue;
                    }
                } else if (o1 == 3) {
                    professorsList.get(count).dropStudent();
                    System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                    String c1 = sc.next();
                    if(c1.equals("EXIT")){
                        break;
                    } else {
                        continue;
                    }
                } else if (o1 == 4) {
                    professorsList.get(count).printInfo();
                    System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                    String c1 = sc.next();
                    if(c1.equals("EXIT")){
                        break;
                    } else {
                        continue;
                    }
                } else {
                    System.out.println("Invalid Input (Try Again)");
                    continue;
                }

            } else if(studentCheck.equals("s") || studentCheck.equals("S")) {
                System.out.println("Enter Student ID");
                int s1 = sc.nextInt();
                System.out.println("Enter 1 if it's a PartTime Student, 2 if it's a FullTime Student");
                int c1 = sc.nextInt();
                if (c1 == 1) {
                    int count = 0;
                    for (PartTimeStudent s : PART_TIME_STUDENTS) {
                        if(s1 == s.getStudID()) {
                            break;
                        }
                        count++;
                    }
                    while(true) {
                        System.out.println("What would you like to do?");
                        System.out.println("Enter 1 for Applying/Dropping Courses: ");
                        System.out.println("Enter 2 for Managing Class Schedule: ");
                        System.out.println("Enter 3 for Graduation Info and Management: ");
                        System.out.println("Enter 4 for Personal/Student Info and Management: ");
                        int d1 = sc.nextInt();
                        if (d1 == 1) {
                            ApplyingDroppingCourses(PART_TIME_STUDENTS.get(count));
                            System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                            String g1 = sc.next();
                            if(g1.equals("EXIT")){
                                break;
                            } else {
                                continue;
                            }
                        } else if (d1 == 2) {
                            ManagingClassSchedule(PART_TIME_STUDENTS.get(count));
                            System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                            String g1 = sc.next();
                            if(g1.equals("EXIT")){
                                break;
                            } else {
                                continue;
                            }
                        } else if (d1 == 3) {
                            GraduationIM(PART_TIME_STUDENTS.get(count));
                            System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                            String g1 = sc.next();
                            if(g1.equals("EXIT")){
                                break;
                            } else {
                                continue;
                            }
                        } else if (d1 == 4) {
                            PersonalIM(PART_TIME_STUDENTS.get(count));
                            System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                            String g1 = sc.next();
                            if(g1.equals("EXIT")){
                                break;
                            } else {
                                continue;
                            }
                        } else {
                            System.out.println("Invalid Input (Try Again)");
                            continue;
                        }
                    }
                } else if (c1 == 2) {
                    int count = 0;
                    for (FullTimeStudent s : FULL_TIME_STUDENTS) {
                        if(s1 == s.getStudID()) {
                            break;
                        }
                        count++;
                    }
                    while(true) {
                        System.out.println("What would you like to do?");
                        System.out.println("Enter 1 for Applying/Dropping Courses: ");
                        System.out.println("Enter 2 for Managing Class Schedule: ");
                        System.out.println("Enter 3 for Graduation Info and Management: ");
                        System.out.println("Enter 4 for Personal/Student Info and Management: ");
                        int d1 = sc.nextInt();
                        if (d1 == 1) {
                            ApplyingDroppingCourses(FULL_TIME_STUDENTS.get(count));
                            System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                            String g1 = sc.next();
                            if(g1.equals("EXIT")){
                                break;
                            } else {
                                continue;
                            }
                        } else if (d1 == 2) {
                            ManagingClassSchedule(FULL_TIME_STUDENTS.get(count));
                            System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                            String g1 = sc.next();
                            if(g1.equals("EXIT")){
                                break;
                            } else {
                                continue;
                            }
                        } else if (d1 == 3) {
                            GraduationIM(FULL_TIME_STUDENTS.get(count));
                            System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                            String g1 = sc.next();
                            if(g1.equals("EXIT")){
                                break;
                            } else {
                                continue;
                            }
                        } else if (d1 == 4) {
                            PersonalIM(FULL_TIME_STUDENTS.get(count));
                            System.out.println("Would you like to continue or exit to MAIN? (Enter EXIT to exit, Enter CONT to continue)");
                            String g1 = sc.next();
                            if(g1.equals("EXIT")){
                                break;
                            } else {
                                continue;
                            }
                        } else {
                            System.out.println("Invalid Input (Try Again)");
                            continue;
                        }
                    }
                }
                System.out.println("Would you like to continue or exit to HOME PAGE? (Enter EXIT to exit, Enter CONT to continue)");
                String h1 = sc.next();
                if(h1.equals("EXIT")){
                    break;
                } else {
                    continue;
                }
            } else {
                System.out.println("Invalid Input (Try Again)");
                continue;
            }
        }
        sc.close();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////

    
    private static void PersonalIM(PartTimeStudent currentPartStud) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do: ");
        System.out.println("Enter 1 to change major: ");
        System.out.println("Enter 2 to see Student info: ");
        int d1 = sc.nextInt();
        if (d1 == 1) {
            currentPartStud.changeMajor();
        } else if (d1 == 2) {
            currentPartStud.printInfo();
        }
        sc.close();
    }

    private static void GraduationIM(PartTimeStudent currentPartStud) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do: ");
        System.out.println("Enter 1 to create and view roadmap: ");
        System.out.println("Enter 2 to see all credits: ");
        System.out.println("Enter 3 to see GPA: ");
        int d1 = sc.nextInt();
        if (d1 == 1) {
            currentPartStud.createRoadmap(currentPartStud.getMajor());
            currentPartStud.showCourseRoadmap();
        } else if (d1 == 2) {
            currentPartStud.totalCredits();
        } else if (d1 == 3) {
            currentPartStud.calculateGPA();
            System.out.println(currentPartStud.getGPA());
        }
        sc.close();
    }

    private static void ManagingClassSchedule(PartTimeStudent currentPartStud) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do: ");
        System.out.println("Enter 1 to view schedule: ");
        System.out.println("Enter 2 to create schedule: ");
        System.out.println("Enter 3 to delete schedule: ");
        int d1 = sc.nextInt();
        if (d1 == 1) {
            currentPartStud.checkSchedule();
        } else if (d1 == 2) {
            currentPartStud.addSchedule();
        } else if (d1 == 3) {
            System.out.println("What index do u want to remove?: ");
            int d2 = sc.nextInt();
            currentPartStud.deleteSchedule(d2);
        }
        sc.close();
    }

    private static void ApplyingDroppingCourses(PartTimeStudent currentPartStud) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do: ");
        System.out.println("Enter 1 to add classes: ");
        System.out.println("Enter 2 to drop classes: ");
        System.out.println("Enter 3 to see Student info: ");
        int d1 = sc.nextInt();
        if (d1 == 1) {
            currentPartStud.applyForCourses();
            System.out.println("Enter Professors for your Courses");
            while(true) {
                System.out.println("Enter professor ID (Enter EXIT when done): ");
                String p1 = sc.next();
                if(p1.equals("EXIT")) {
                    break;
                }
                if (!p1.isEmpty()) {
                    for (Professor p : professorsList) {
                        if (p.getProfessorID() == Integer.parseInt(p1)) {
                            System.out.println("Give computer to Professor to approve: ");
                            p.approveStudent();
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
        } else if (d1 == 2) {
            currentPartStud.dropCourses();
        } else if (d1 == 3) {
            currentPartStud.printInfo();
        }
        sc.close();
    }

    
    private static void PersonalIM(FullTimeStudent currentFullStud) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do: ");
        System.out.println("Enter 1 to change major: ");
        System.out.println("Enter 2 to see Student info: ");
        int d1 = sc.nextInt();
        if (d1 == 1) {
            currentFullStud.changeMajor();
        } else if (d1 == 2) {
            currentFullStud.printInfo();
        }
        sc.close();
    }

    private static void GraduationIM(FullTimeStudent currentFullStud) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do: ");
        System.out.println("Enter 1 to create and view roadmap: ");
        System.out.println("Enter 2 to see all credits: ");
        System.out.println("Enter 3 to see GPA: ");
        int d1 = sc.nextInt();
        if (d1 == 1) {
            currentFullStud.createRoadmap(currentFullStud.getMajor());
            currentFullStud.showCourseRoadmap();
        } else if (d1 == 2) {
            currentFullStud.totalCredits();
        } else if (d1 == 3) {
            currentFullStud.calculateGPA();
            System.out.println(currentFullStud.getGPA());
        }
        sc.close();
    }

    private static void ManagingClassSchedule(FullTimeStudent currentFullStud) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do: ");
        System.out.println("Enter 1 to view schedule: ");
        System.out.println("Enter 2 to create schedule: ");
        System.out.println("Enter 3 to delete schedule: ");
        int d1 = sc.nextInt();
        if (d1 == 1) {
            currentFullStud.checkSchedule();
        } else if (d1 == 2) {
            currentFullStud.addSchedule();
        } else if (d1 == 3) {
            System.out.println("What index do u want to remove?: ");
            int d2 = sc.nextInt();
            currentFullStud.deleteSchedule(d2);
        }
        sc.close();
    }

    private static void ApplyingDroppingCourses(FullTimeStudent currentFullStud) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do: ");
        System.out.println("Enter 1 to add classes: ");
        System.out.println("Enter 2 to drop classes: ");
        System.out.println("Enter 3 to see Student info: ");
        int d1 = sc.nextInt();
        if (d1 == 1) {
            currentFullStud.applyForCourses();
            System.out.println("Enter Professors for your Courses");
            
            while(true) {
                System.out.println("Enter professor ID (Enter EXIT when done): ");
                String p1 = sc.next();
                if(p1.equals("EXIT")) {
                    break;
                }
                if (!p1.isEmpty()) {
                    for (Professor p : professorsList) {
                        if (p.getProfessorID() == Integer.parseInt(p1)) {
                            System.out.println("Give computer to Professor to approve: ");
                            p.approveStudent();
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
        } else if (d1 == 2) {
            currentFullStud.dropCourses();
        } else if (d1 == 3) {
            currentFullStud.printInfo();
        }
        sc.close();
    }

/////////////////////////////////////////////////////////////////////////////////////////////

    public void showCourseAvailability(){
        for (Course c : coursesList) {
            System.out.println(c.getCourseName() + " - " + c.getCourseID());
        }
    }

    //Method 1
    public double calculateGPA() {
        int count = 0;
        double total = 0.0;
        List<Double> list = new ArrayList<>();
        for (Grade g : grades) {
            if (g == null) continue;
            String t = g.convertGradeID(g.getGradeID(), this.getCourses()[count]);
            // Treat "Pass"/"Fail" (or any non-letter) as not counted for GPA
            Double pts = letterToPoints(t);
            if (pts != null ) {
                list.add(pts);
            }
            count++;
        }
        for (Double pointer : list) {
            
            total += pointer;
        }
        this.setGPA(total/list.size());
        return total/list.size();
    }

    // Method 2
    public abstract void addSchedule();

    // Method 3
    public abstract void deleteSchedule(int index);

    // Method 4
    public abstract void createRoadmap(String major);

    
    public abstract String checkSchedule();
    
    
    
    @Override
    public void printInfo() {
        System.out.println("Student Info: ");
        System.out.println(("Student: " + this.getName() + ", ID: " + this.getStudID() + ", Email: " + this.getEmail() + ", Major: " + this.getMajor()));

        Course[] studentEnrolled = this.getCourses();
        Professor[] studentProfessors = this.getProfessors();
        Grade[] studentGrades = this.getGrades();   
        boolean hasCoursesAvail = false;
        int i = 0;

        for (Course c : studentEnrolled) {
            if (c != null) {
                hasCoursesAvail = true;

                String proftoStudent = "N/A";
                if (studentProfessors != null && i < studentProfessors.length && studentProfessors[i] != null) {
                    proftoStudent =  studentProfessors[i].getProfessorName() + " (ID: " + studentProfessors[i].getProfessorID() + ")";
                }

                String gradetoStudent = "N/A";
                if (studentGrades != null && i < studentGrades.length && studentGrades[i] != null) {
                    Integer gradeValue = studentGrades[i].getGradeID();
                    gradetoStudent = gradeValue.toString();
                    
                }

                System.out.println("Courses enrolled in: " + c.getCourseName() + " (" + c.getCourseID() + "), " 
                + "Credits: " + c.getCredits() + ", Time: " + c.getTime() + ", "
                + "Professor: " + proftoStudent + 
                  ", Grade: " + gradetoStudent);

            }
            i++;
        }
        if (!hasCoursesAvail) {
            System.out.println("Student has no enrolled courses.");
        }
        this.calculateGPA();
        System.out.println("GPA: " + this.getGPA());
    }


    private Double letterToPoints(String letter) {
        if (letter == null) return null;
        switch (letter) {
            case "A":  return 4.0;
            case "A-": return 3.7;
            case "B+": return 3.3;
            case "B":  return 3.0;
            case "B-": return 2.7;
            case "C+": return 2.3;
            case "C":  return 2.0;
            case "C-": return 1.7;
            case "D+": return 1.3;
            case "D":  return 1.0;
            case "D-": return 0.7;
            case "F":  return 0.0;
            case "Pass": return null;
            case "Fail": return 0.0;
            default:   return null; // not a letter grade we count
        }
    }

    public Integer getStudID() { return studID; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Double getGPA() {return GPA; }
    public String getMajor() {return major; }
    public void setMajor(String major) {this.major = major;}
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setGPA(Double GPA) {this.GPA = GPA; } 

    public Grade[] getGrades() { return Arrays.copyOf(grades, grades.length); }
    public Professor[] getProfessors() { return Arrays.copyOf(professors, professors.length); }
    public Course[] getCourses() { return Arrays.copyOf(courses, courses.length); }
}
