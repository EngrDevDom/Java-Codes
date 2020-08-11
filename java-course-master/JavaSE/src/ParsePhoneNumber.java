public class ParsePhoneNumber {
    public static void main(String[] args) {
        StringBuilder phoneNumber = new StringBuilder("977-555-1212");
        String areaCode = phoneNumber.substring(0, 3);
        String prefix = phoneNumber.substring(4, 7);
        String suffix = phoneNumber.substring(8);
        System.out.println(phoneNumber + "\n");
        System.out.println("Code of AreaCalculation: " + areaCode);
        System.out.println("Prefix: " + prefix);
        System.out.println("Suffix: " + suffix);
    }
}
