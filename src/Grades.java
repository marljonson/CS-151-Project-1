package src;

import java.util.Scanner;

public class Grades {
    private int gradeID;

    private String gradeLetterPassFail;

    public Grades(int gradeID) {
        this.gradeID = gradeID;
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


    public double curveGrade(int gradeID)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a decimal number for curving grade: ");
        double curveFactor = sc.nextDouble();
        while (!sc.hasNextDouble()) {
            System.out.println("Please enter a decimal number.");
            sc.next();
        }
        double curvedGrade = gradeID * curveFactor;
        sc.close();
        return curvedGrade;
    }

    public int extraCredit(int gradeID)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount of extra credit points: ");
        int extraPoints = sc.nextInt();
        while (!sc.hasNextInt()) {
            System.out.println("Please enter an integer number.");
            sc.next();
        }
        int newGrade = gradeID + extraPoints;
        sc.close();
        return newGrade;
    }

    public String convertGradeIDToPassFail(int gradeID) 
    {
        if (gradeID >= 70) {
            return "Pass";
        } else {
            return "Fail";
        }

    }
}






