public class StringCapacity {
    public static void main(String[] args) {
        StringBuilder name = new StringBuilder(8);
        System.out.println("Length of name: " + name.length());
        int capacity1 = name.capacity();
        name.append("Raymond R. Thomas");
        int length = name.length();
        int capacity2 = name.capacity();
        System.out.println("Capacity1: " + capacity1);
        System.out.println("Name: " + name);
        System.out.println("Length: " + length);
        System.out.println("Capacity2: " + capacity2);
    }
}
