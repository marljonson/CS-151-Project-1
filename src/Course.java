package src;

public class Course {

    private int courseID;
    private String courseName;
    private int credits;
    private int time;
    private boolean passFail;

    // arg constructor
    public Course(int courseID, String courseName, int credits, int time, boolean passFail) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
        this.time = time;
        this.passFail = passFail;
    }

    // no-arg constructor
    public Course() {
        this.courseID = 0;
        this.courseName = "NA";
        this.credits = 0;
        this.time = 0;
        this.passFail = false;
    }

     public void setCourseID(int courseId) {
        this.courseID = courseId;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setPassFail(boolean passFail) {
        this.passFail = passFail;
    }

    public boolean isPassFail() {
        return passFail;
    }

}
