public class TabDelimitedString {
    public static void main(String[] args) {
        String address = "805 Main Street\tDallas\tTX\t12345";
        address = address.trim();
        System.out.println(address);
        System.out.println();
        String[] addressParts = address.split("\t");
        String street = addressParts[0];
        String city = addressParts[1];
        String state = addressParts[2];
        String zip = addressParts[3];
        for (int i = 0; i < addressParts.length; i ++)
            System.out.println(addressParts[i]);
    }
}
