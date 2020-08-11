public class String_Builder {
    public static void main(String[] args) {
        StringBuilder phoneNumber = new StringBuilder();
        phoneNumber.append("977");
        phoneNumber.append("555");
        phoneNumber.append("1212");
        System.out.println(phoneNumber);
        phoneNumber.insert(3, "-");
        phoneNumber.insert(7, "-");
        System.out.println(phoneNumber);
        for (int i = 0; i < phoneNumber.length(); i ++) {
            if (phoneNumber.charAt(i) == '-') {
                phoneNumber.deleteCharAt(i--);
            }
        }
        System.out.println(phoneNumber);
    }
}
