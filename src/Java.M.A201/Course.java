import java.util.Scanner;

public class Course {
    private String courseCode;
    private String courseName;
    private double duration;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private String status;
    private String flag;

    public Course() {
        this.courseCode = null;
        this.courseName = null;
        this.duration = 0.0;
        this.status = null;
        this.flag = null;
    }

    public Course(String courseCode, String courseName, double duration, String status, String flag) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.duration = duration;
        this.status = status;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return this.courseCode + "\t" + this.courseName + "\t" + this.duration + "\t" + this.status + "\t" + this.flag;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        this.setCourseCode(Validator.validateCourseCode("Enter Course code (format: FWxxx):: "));
        this.setCourseName(Validator.validateCourseName("Enter Course Name:"));
        this.setDuration(Validator.validateDuration("Enter Duration:"));
        this.setStatus(Validator.validateStatus("Enter status (active or in-active):"));
        this.setFlag(Validator.validateFlag("Enter flag (optional, mandatory, N/A):"));

    }


}
