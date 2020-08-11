import java.util.Scanner;

public class OneAway{
		public static void main(String[] args){
			Scanner sc = new Scanner(System.in);
			String s1 = sc.next();
			String s2 = sc.next();
			
			System.out.println(isOneEdit(s1,s2));
		}

		static boolean isOneEdit(String s1, String s2){

			if(s1.length() == s2.length()){
				return OneEditReplace(s1,s2);
			}else if(s1.length() + 1 == s2.length()){  //IF(3+1 ==4 )
				return OneEditInsert(s1,s2);
			}else if(s1.length() - 1 == s2.length()){  //IF(4-1 == 3)
				return OneEditInsert(s2,s1);
			}
			return false;
		}

		static boolean OneEditReplace(String s1,String s2){
			boolean foundOdd = false;
			for(int i =0;i<s1.length();i++){
				if(s1.charAt(i) == s2.charAt(i)){
					foundOdd = true;
				}else{
					foundOdd = false;
				break;
				}
			}
			return foundOdd;
		}

		static boolean OneEditInsert(String s1, String s2){
			
				int index1 = 0;
				int index2 = 0;
				while(index1 < s1.length() && index2 < s2.length()){
					if(s1.charAt(index1) != s2.charAt(index2)){
						if(index1 != index2){
							return false;}
						index2++;
					}
					else{
						index1++;
						index2++;
					}
				}return true;
		}
		}


