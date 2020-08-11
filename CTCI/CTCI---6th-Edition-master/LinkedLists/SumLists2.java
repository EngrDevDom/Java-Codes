package StringRotation.LinkedLists;
class SumLists2{
	static Node node1,node2;
	static class Node{   
		int data;
		Node next;
		Node(int data){
			this.data = data;
			next = null;}
	}
	static class PartialSum{  //Wrapper class because we have to return Linked List as well as carry.
		Node sum = null;
		int carry = 0;
	}
	
	//Returns resultant node
	Node addTwoLists(Node n1, Node n2){
		int lenM = length(n1);
		int lenN = length(n2);

		if(lenM < lenN){ n1 = paddingLists(n1, lenN-lenM); }
		if(lenN < lenM){ n2 = paddingLists(n2, lenM -lenN);}

		PartialSum sum = addTwoListsHelper(n1, n2);
		if(sum.carry == 0){
			return sum.sum;
		}else{
			Node result = insertBefore(sum.sum,sum.carry);
			return result;
		}
	}
	
	int length(Node n){
		int count = 0;
		while(n.next != null){
			count++;
			n = n.next;
		}
		count++;
		return count;
	}

	Node paddingLists(Node n, int data){ //(2->2, 2(difference))
		Node head = n;
		for (int i = 0; i < data; i++) {
			head = insertBefore(head, 0);
		}
		return head;
	}

	Node insertBefore(Node list, int data){ //I=(2->2,0) (0->2->2) II = (0->0->2->2->2)
		Node node = new Node(data);
		if(list != null){
			node.next = list;
		}
		return node;
	}

	PartialSum addTwoListsHelper(Node n1, Node n2){
		if(n1 == null && n2 == null){
				PartialSum sum = new PartialSum();
				return sum;
			}
		//Recurse
		PartialSum sum = addTwoListsHelper(n1.next, n2.next);  
		//sum of node.datas
		int value = sum.carry + n1.data + n2.data;
		//create node backward adding second digit
		Node finalResult = insertBefore(sum.sum, value%10);
		sum.sum = finalResult;
		sum.carry = value/10; //first digit is carry
		return sum;
	}

	void printNode(Node n){
		while(n.next != null){
			System.out.print(n.data+"-->");
			n = n.next;
		}
		System.out.print(n.data);
	}
	public static void main(String[] args){
		SumLists2 s = new SumLists2();
		node1 = new Node(2);
		node1.next = new Node(3);
		node1.next.next = new Node(4);
		node2 = new Node(5);
		node2.next = new Node(6);
		node2.next.next = new Node(7);
		
		Node res =s.addTwoLists(node1,node2);
		System.out.print("First Linked list is:  ");
		s.printNode(node1);
		System.out.println();
		System.out.print("Second Linked list is: ");
		s.printNode(node2);
		System.out.println();
		System.out.println("_____________________________________");
		System.out.print("Addition is:           ");
		s.printNode(res);
		System.out.println();
	}
}

/* example: n1 7->1->6->3  n2 2->2
	padList and insertBefore combines to form this 0->0->2->2  
OUTPUT: 
	First Linked list is:  2-->3-->4
	Second Linked list is: 5-->6-->7
_____________________________________
	Addition is:           8-->0-->1
	*/