package src;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class PartTimeStudent extends Student {

    public static final int COURSE_LIMIT = 4;
    
    protected PartTimeStudent(Integer studID, String name, String email, String major) {
        super(studID, name, email, major);
    }

    //1st METHOD OVERRIDE
    @Override
    public void addSchedule(){
        int count = 0;
        for (Course c : this.getCourses()) {
            if (this.getGrades()[count].getGradeID() != -1) {
                Schedule.put(c.getCourseName(), c.getTime());
            }
            count++;
        }
    };

    //2nd METHOD OVERRIDE
    @Override
    public String checkSchedule() {
        System.out.println("Current Schedule:");
        if (Schedule.isEmpty()) {
            System.out.println("No courses in your viewable schedule.");
        } else {
            int slot = 1;
            for (String courseName : Schedule.keySet()) {
                int time = Schedule.get(courseName);
                System.out.println("Slot " + slot + ": " + courseName + " at " + time);
                slot++;
            }
        }
        return "Schedule displayed.";
    }

    //3rd METHOD OVERRIDE
    @Override
    public void deleteSchedule(int index) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the course slot (1-4) to remove from viewable schedule: ");
        int userInput = sc.nextInt();
    
        int arrayIndex = userInput - 1;
    
        if (arrayIndex < 0 || arrayIndex >= MAX_SLOTS) {
            System.out.println("Please select a valid course slot to delete.");
            return;
        }

        if (courses[arrayIndex] == null || courses[arrayIndex].getCourseID() == 0) {
            System.out.println("No course scheduled here.");
            return;
        }

        Course courseToRemove = courses[arrayIndex];
    
        if (Schedule.containsKey(courseToRemove.getCourseName())) {
            Schedule.remove(courseToRemove.getCourseName());
            System.out.println("Removed " + courseToRemove.getCourseName() + " from your viewable schedule.");
        } else {
            System.out.println("That course wasn't in your viewable schedule.");
        }
        
        sc.close();
    }
    
    // 4th METHOD OVERRIDE
    @Override
    public void createRoadmap(String major) {
        for(Course c : coursesList) {
            if(c.getCourseName().contains(major)){
                roadmapCourseList.add(c);
            }
        }
    }

    public void showCourseRoadmap(){
        for (Course c : roadmapCourseList) {
            System.out.println(c.getCourseName());
        }
    }
    
    //Method 1
    public void dropCourses() {
        final int MAX = 6;
        System.out.println("Course options: ");
        for (Course c : courses) {
            System.out.println(c.getCourseName() + " ,ID: " + c.getCourseID());
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter up to " + MAX + " courses to drop. Press ENTER on course name to finish early.");
        int count = 0;
        while (count < MAX) {
            System.out.print("Course ID" + (count + 1) + ": ");
            String course = sc.nextLine().trim();
            if (course.isEmpty()) break;      
            if (checkIfCourseValid(course)) {
                System.out.println("Removed: " + course);
                courses[count] = new Course();
                grades[count] = new Grade();
            } else {
                System.out.println("That course is not in your schedule. Try a different one.");
                continue;
            }
            count++;
        }
        System.out.println("\nYou removed " + count + " course(s).");
    }
    
    //Method 2
    public void applyForCourses() {
        System.out.println("Course options: ");
        showCourseAvailability();
        final int MAX = 6;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter up to " + MAX + " courses. Press ENTER on course name to finish early.");
        int count = 0;
        while (count < MAX) {
            System.out.print("Course ID" + (count + 1) + ": ");
            String course = sc.nextLine().trim();
            if (course.isEmpty()) break;      
            if (checkIfCourseValid(course)) {
                System.out.println("That course is already in your schedule. Try a different one.");
                continue;
            } else if(!checkIfCourseExists(course)){
                System.out.println("CourseID not valid (Course doesn't exist)");
                continue;
            }
            courses[count] = getCourseObjectFromCourseID(course);
            System.out.println("Added: " + course);
            count++;
        }
        System.out.println("\nYou added " + count + " course(s).");
    }
    
    //Method 3
    public void changeMajor() {
        try {
            if (this.getGPA() >= 3.2) {
                final java.util.Set<String> allowed = java.util.Set.of("CS", "CMPE", "ENGR");
                java.util.Scanner sc = new java.util.Scanner(System.in);
    
                String major;
                while (true) {
                    System.out.print("Enter the major you would like to switch to (CS, CMPE, ENGR): ");
                    String input = sc.next().trim().toUpperCase();
                    if (allowed.contains(input)) {
                        major = input;
                        break;
                    }
                    System.out.println("Invalid input. Please enter one of: CS, CMPE, ENGR.");
                }
    
                this.setMajor(major);
                System.out.println("Changing Student Roadmap...");
                roadmapCourseList.clear();
                this.createRoadmap(major);
                } else {
                    System.out.println("Cannot switch major (GPA restriction not met)");
                }
             } catch (NoSuchElementException e) {
                System.out.println("No input provided. Major has not been changed.");
             } catch (Exception e) {
                System.out.println("Failed to change major: " + e.getMessage());
             }
    }

    // Method 4
    public void totalCredits() {
        
        int totalTaken = 0;
        int totalPassed = 0;

        for (int i = 0; i < courses.length; i++) {
            Course c = courses[i];
            Grade g = grades[i];
            
            if (c == null || g == null ) {
                continue;
            }
            int credits = c.getCredits();
            int gradeValue = g.getGradeID();
            
            totalTaken += credits;

            if (gradeValue >= 70) {
                totalPassed += credits;
            }

        }
        System.out.println("Total Credits Enrolled: " + totalTaken);
        System.out.println("Total Credits Passed: " + totalPassed);
    }


    
    // Helper Methods

    public boolean checkIfCourseExists(String course) {
        for(Course g : coursesList) {
            if(g.getCourseID() == Integer.parseInt(course)) {
                return true;
            }    
        }
        return false;
    }

    public boolean checkIfCourseValid(String course) {
        for (Course g : this.getCourses()) {
            if (Integer.parseInt(course) == g.getCourseID()) {
                return true;
            }
        }
        return false;      
    }

    public Course getCourseObjectFromCourseID(String course) {
        for (Course c : coursesList) {
            if(c.getCourseID() == Integer.parseInt(course)){
                return c;
            }
        }
        return null;
    }


}
