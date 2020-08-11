public class URLify {

    public static void convertUrl(String input, int length){
        StringBuilder sb = new StringBuilder();
        String in = "%20";

        for(int i=0;i<length;i++){
            if(input.charAt(i) == ' '){
                sb.append(in);
            }else{
                sb.append(input.charAt(i));
            }
        }
        String answer = sb.toString();
        System.out.println(answer);

    }

    public static void main(String[] args) {
        String input = "Mr John Smith       ";
        int length = 13;
        convertUrl(input,length);
    }
}
