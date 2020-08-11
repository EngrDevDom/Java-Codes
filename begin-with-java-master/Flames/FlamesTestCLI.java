import java.util.Scanner;

public class FlamesTestCLI {

	private static String test(String name1,String name2) {
		char x[] = name1.toLowerCase().toCharArray();
		char y[] = name2.toLowerCase().toCharArray();
		for(int i=0;i<x.length;i++) {
			for(int j=0;j<y.length;j++) {
				if(x[i] == y[j]) {
					x[i] = y[j] = '$';
					break;
				}
			}
		}
		int count = 0;
		for(char a : x) {
			if(a != '$') count++;
		}
		for(char b : y) {
			if(b != '$') count++;
		}
		Flames f = new Flames();
		char c = f.getResultChar(count);
		if(c == 'F') return "Friendship";
		else if(c == 'L') return "Love";
		else if(c == 'A') return "Affection";
		else if (c == 'M') return "Marriage";
		else if(c == 'E') return "Enemy";
		else if(c == 'S') return "Sibling";
		else return "None";
	}

	private static String getName(int n) {
		Scanner sc = new Scanner(System.in);
		String name;
		if(n == 1) {
			System.out.print("\nEnter your name: ");
		}
		else {
			System.out.print("Enter your partner's name: ");
		}
		try {
			name = sc.nextLine();
			if(name.length() == 0) throw new EmptyNameException();
			for(char c : name.toCharArray()) {
				if((c>='A' && c<='Z') || (c>='a' && c<='z'))
					continue;
				throw new InvalidCharacterException();
			}
			return name;
		}
		catch(EmptyNameException e) {
			System.out.println("Exception: " + e);
			return getName(n);
		}
		catch(InvalidCharacterException e) {
			System.out.println("Exception: " + e);
			return getName(n);
		}
	}

	private static boolean continueOrNot() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nTry again...? (Y|N): ");
		char c = sc.next().charAt(0);
		if(c == 'Y' || c == 'y') return true;
		else if(c == 'N' || c == 'n') return false;
		else {
			System.out.println("Please enter a valid character!");
			return continueOrNot();
		}
	}

	public static void main(String args[]) {
		System.out.println("\n" + "=".repeat(7) + " FLAMES TEST " + "=".repeat(7));
		Scanner sc = new Scanner(System.in);
		boolean b;
		while(true) {
			String name1 = getName(1);
			String name2 = getName(2);
			String relation = test(name1, name2);
			String result;
			if(relation.equals("None"))
				result = String.format("\nThe relationship between %s and %s cannot be found!", name1, name2);
			else
				result = String.format("\nThe relationship between %s and %s will end in %s!", name1, name2, relation);
			System.out.println(result);
			b = continueOrNot();
			if(b) continue;
			else break;
		}
		System.out.println("\nYou terminated...Bye!");
	}
}

class EmptyNameException extends Exception {

	@Override
	public String toString() {
		return "Name cannot be empty!";
	}

}

class InvalidCharacterException extends Exception {

	@Override
	public String toString() {
		return "Name contains only alpabets!";
	}

}

class Flames {

	Flames() {
		char arr[] = {'F','L','A','M','E','S'};
		for(char c:arr) {
			this.insert(c);
		}
	}

	private class Node {
		char data;
		Node next;

		Node(char data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head = null;
	private Node tail = null;
	private Node mark = null;

	private void insert(char c) {
		Node temp = new Node(c);
		if(head == null) {
			head = temp;
			tail = temp;
			tail.next = head;
		}
		else {
			tail.next = temp;
			tail = temp;
			tail.next = head;
		}
	}

	private Node remove(Node mark) {
		if(mark == head) {
			if(head == tail) {
				head = null;
				tail = null;
				return null;
			}
			else {
				head = head.next;
				tail.next = head;
				return head;
			}
		}
		else if(mark == tail) {
			Node temp;
			for(temp=head;temp.next!=tail;temp=temp.next) {}
			tail = temp;
			tail.next = head;
			return head;
		}
		else {
			Node u = null;
			Node v = null;
			for(u=head;u.next!=mark;u=u.next) {}
			v = u.next;
			v = v.next;
			u.next = v;
			return v;
		}
	}

	char getResultChar(int n) {
		if(n!=0) {
			mark = head;
			while(head!=tail) {
				for(int i=0;i<n-1;i++) {
					mark = mark.next;
				}
				mark = this.remove(mark);
			}
			return mark.data;
		}
		else {
			return 'X';
		}
	}
}