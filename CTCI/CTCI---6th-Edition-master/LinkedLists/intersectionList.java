package StringRotation.LinkedLists;

public class intersectionList {
    static node head,head1;
    static class node{
            int data;
            node next;
            node(int data){
                this.data = data;
        }
    }
    class result{
        node res;
        int size;
        result(node res, int size){
            this.res = res;
            this.size = size;
        }
    }

    node isintersecting(node one, node two){
        if(one == null || two == null){
            return null;
        }
            
        result shorter = gettailnSize(one);
        result longer = gettailnSize(two);

        //if tails are diffferent ret
        if(shorter.res != longer.res){
            return null;
        }

        //move pointer to start of list
        node shorter1 = shorter.size < longer.size? one : two;
        node longer1 = shorter.size < longer.size? two :one;

        longer1 = getkthnode(longer1,Math.abs(shorter.size - longer.size));
        //now the pointers at same position proceed untill intersection
        while(shorter1 != longer1){
            shorter1 = shorter1.next;
            longer1 = longer1.next;
        }
        // return either one
        return longer1;

        
    }

    node getkthnode(node n, int diff){
        node current = n;
        while(diff>0 && current != null){
            current = current.next;
            diff--;
        }
        return current;
    }

    result gettailnSize(node head){
        if(head == null){
            return null;
        }
        int size = 1;
        node curr = head;
        while(curr.next != null){
            size++;
            curr = curr.next;
        }
        return new result(curr,size);
    }
        public static void main(String[] args) {
            intersectionList in = new intersectionList();
            head = new node(1);
            head.next = new node(2);
            head.next.next = new node(3);
            head.next.next.next = new node(4);  
            head.next.next.next.next = new node(5);

            head1 = new node(6);
            head1.next = new node(7);
            head1.next.next = new node(5);
            head1.next.next.next = new node(2);
            head1.next.next.next.next = head.next.next.next;
            head1.next.next.next.next.next = head.next.next.next.next;

            node res= in.isintersecting(head,head1);
            System.out.println(res.data);
        }
}