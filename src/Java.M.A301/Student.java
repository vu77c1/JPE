import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Student extends Person{
    private static boolean headerPrinted = false;

    private String studentId;

    public Student(String fullName, String gender, String phone, String email, Date birthDate,String studentId, double theory, double practice ) {
        super(fullName, gender, phone, email, birthDate);
        this.studentId = studentId;
        this.theory = theory;
        this.practice = practice;
    }

    private double theory;

    public Student() {

    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getTheory() {
        return theory;
    }

    public void setTheory(double theory) {
        this.theory = theory;
    }

    public double getPractice() {
        return practice;
    }

    public void setPractice(double practice) {
        this.practice = practice;
    }

    private double practice;


    public double calculateFinalMark() {
        return (theory + practice) / 2.0;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        NumberFormat formatter = NumberFormat.getInstance(Locale.US);

        String formattedBirthDate = dateFormat.format(getBirthDate());
        String formattedFinalMark = formatter.format(calculateFinalMark());

        // Using a StringBuilder for better performance when concatenating multiple strings
        StringBuilder formattedOutput = new StringBuilder();
        if (!headerPrinted)
        {
            formattedOutput.append(String.format("%-15s %-10s %-15s %-25s %-15s %-10s %-10s %-15s %-15s\n",
                    "Full Name", "Gender", "Phone", "Email", "Birth Date", "Student ID", "Theory", "Practice", "Final Mark"));
            headerPrinted=true;
        }

        formattedOutput.append(String.format("%-15s %-10s %-15s %-25s %-15s %-10s %-10s %-15s %-15s\n",
                getFullName(), getGender(), getPhone(), getEmail(), formattedBirthDate, studentId, theory, practice, formattedFinalMark));

        return formattedOutput.toString();
    }

}
