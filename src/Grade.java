package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Grade {
    private int gradeID;
    private String gradeLetterPassFail;

    public Grade() {
        this.gradeID = -1;
        this.gradeLetterPassFail = "NA";
    }

    // GETTERS AND SETTERS 
    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }

    public int getGradeID() {
        return gradeID;
    }

    public void setGradeLetterPassFail(String gradeLetterPassFail) {
        this.gradeLetterPassFail = gradeLetterPassFail;
    }

    public String getGradeLetterPassFail(){
        return gradeLetterPassFail;
    }

    // Method 1
    public String convertGradeID(int gradeID, Course courselink)
    {
        if (gradeID < 0) {
            return "Invalid gradeID";
        } else if (courselink.isPassFail()) {
            setGradeLetterPassFail(convertGradeIDToPassFail(gradeID));
            return convertGradeIDToPassFail(gradeID);
        } else if (gradeID >= 93) {
            setGradeLetterPassFail("A");
            return "A";
        } else if (gradeID >= 90) {
            setGradeLetterPassFail("A-");
            return "A-";
        } else if (gradeID >= 87) {
            setGradeLetterPassFail("B+");
            return "B+";
        } else if (gradeID >= 83) {
            setGradeLetterPassFail("B");
            return "B";
        } else if (gradeID >= 80) {
            setGradeLetterPassFail("B-");
            return "B-";
        } else if (gradeID >= 77) {
            setGradeLetterPassFail("C+");
            return "C+";
        } else if (gradeID >= 73) {
            setGradeLetterPassFail("C");
            return "C";
        } else if (gradeID >= 70) {
            setGradeLetterPassFail("C-");
            return "C-";
        } else if (gradeID >= 67) {
            setGradeLetterPassFail("D+");
            return "D+";
        } else if (gradeID >= 63) {
            setGradeLetterPassFail("D");
            return "D";
        } else if (gradeID >= 60) {
            setGradeLetterPassFail("D-");
            return "D-";
        } else {
            setGradeLetterPassFail("F");
            return "F";
        }
    }

    // Method 2
    public double curveGrade(int gradeID)
    {
        Scanner sc = new Scanner(System.in);
        double curveFactor;

        while (true) {
            System.out.println("Please enter a decimal number for curving grade: ");
            try {
                curveFactor = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input is not valid. Please enter a decimal number.");
                sc.next(); 
            }
        }
        double curvedGrade = gradeID * curveFactor;
        sc.close();
        return curvedGrade;
    }

    // Method 3
    public int extraCredit(int gradeID)
    {
        Scanner sc = new Scanner(System.in);
        int extraPoints;
        
        while (true) {
            System.out.println("Please enter an integer number.");
            try {
                extraPoints = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input is not valid. Please enter an integer number.");
                sc.next(); 
            }
        }
        int newGrade = gradeID + extraPoints;
        sc.close();
        return newGrade;
    }

    // Overloaded method 3 for testing purposes
    public int extraCredit(int gradeID, int extraPoints) {
        return gradeID + extraPoints;
    }

    // Method 4
    public String convertGradeIDToPassFail(int gradeID) 
    {
        if (gradeID >= 70 || gradeID == -1) {
            return "Pass";
        } else {
            return "Fail";
        }

    }
}








