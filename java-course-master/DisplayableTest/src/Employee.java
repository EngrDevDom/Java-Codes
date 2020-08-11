public class Employee implements Displayable, DepartmentConstants {

    private int department;
    private String firstName;
    private String lastName;

    public Employee(int department, String lastName, String firstName) {
        this.department = department;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @Override
    public String getDisplayText() {
        String text = "";
        text += firstName + " " + lastName;
        String dept = "";
        if (department == ADMIN) {
            dept = "Administration";
        } else if (department == EDITORIAL) {
            dept = "Editorial";
        } else if (department == MARKETING) {
            dept = "Marketing";
        }
        text += " (" + dept + ")";
        return text;
    }
}