package src;

public class Grades {
    private int gradeID;

    public Grades(int gradeID) {
        this.gradeID = gradeID;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }

    public int getGradeID() {
        return gradeID;
    }

    public String convertGradeID(int gradeID) {
        if (gradeID < 0 || gradeID > 100) {
            return "Invalid gradeID";
        } else if (gradeID >= 90) {
            return "A";
        } else if (gradeID >= 80) {
            return "B";
        } else if (gradeID >= 70) {
            return "C";
        } else if (gradeID >= 60) {
            return "D";
        } else {
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



