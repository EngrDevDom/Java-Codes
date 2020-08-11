import java.util.Scanner;

class StringCompression {
	    public static void main(String[] args) {
			String s = "aabcccccaaa";
			
			System.out.println(Compress(s)); 
		    
			        }

	      static String Compress(String s){
		    //char[] c = s.toCharArray(s);
			 String Compresstr = "";
			 int count = 0;
		    for(int i = 0;i<s.length();i++){
			    count++;
				 if(i+1 >= s.length() || s.charAt(i) != s.charAt(i+1)){    
					 Compresstr = Compresstr + s.charAt(i) + count;   
					 count = 0;                       // reset count to 0
				 }
			
		    }
		    return Compresstr.length() > s.length() ? s : Compresstr;
	    }
}
