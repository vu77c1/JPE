import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Teacher extends Person {
    private static boolean headerPrinted = false;

    public Teacher(String fullName, String gender, String phone, String email, Date birthDate, double basicSalary, double subsidy) {
        super(fullName, gender, phone, email, birthDate);
        this.basicSalary = basicSalary;
        this.subsidy = subsidy;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Teacher(double basicSalary, double subsidy) {
        super();
        this.basicSalary = basicSalary;
        this.subsidy = subsidy;
    }

    public Teacher() {

    }

    public double getSubsidy() {
        return subsidy;
    }


    public void setSubsidy(double subsidy) {
        this.subsidy = subsidy;
    }

    private double basicSalary;
    private double subsidy;

    public double calculateSalary() {
        return basicSalary + subsidy;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        NumberFormat formatter = NumberFormat.getInstance(Locale.US);

        String formattedBirthDate = dateFormat.format(getBirthDate());
        String formattedSalary = formatter.format(calculateSalary());
        String basicSalary = formatter.format(getBasicSalary());
        String subsidy = formatter.format(getSubsidy());

        // Using a StringBuilder for better performance when concatenating multiple strings
        StringBuilder formattedOutput = new StringBuilder();

        if (!headerPrinted) {
            formattedOutput.append(String.format("%-15s %-10s %-15s %-25s %-15s %-15s %-15s %-15s\n",
                    "Full Name", "Gender", "Phone", "Email", "Birth Date", "Basic Salary", "Subsidy", "Salary"));
            headerPrinted = true;
        }

        formattedOutput.append(String.format("%-15s %-10s %-15s %-25s %-15s %-15s %-15s %-15s\n",
                getFullName(), getGender(), getPhone(), getEmail(), formattedBirthDate, basicSalary, subsidy, formattedSalary));

        return formattedOutput.toString();
    }


}
