package _407_Project_Build_Order;

public class TesterClass {

    public static void main(String[] args) {

        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};
        try {
            System.out.println(ProjectBuildOrder.buildGraphFromDependencies(projects, dependencies));
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
}
