public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
        public String toString(){
            return String.valueOf(this.data);
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
        if(head.next == null)
            tail = head;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(size == 0){
            addFirst(data);
        }
        else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public void add(int k, int data){
        if(k == 0 ){
            addFirst(data);
        }else{
            Node temp1 = node(k-1);
            Node temp2 = temp1.next;
            Node newNode = new Node(data);
            temp1.next = newNode;
            newNode.next = temp2;
            size++;
            if(newNode.next == null)
                tail = newNode;
        }
    }

    public Node node(int idx){
        Node x = head;
        for(int i = 0; i< idx; i++)
            x = x.next;
        return x;
    }

    public String toString(){
        if(head == null){
            return "[]";
        }
        Node temp = head;
        String str = "[";
        while (temp.next != null) {
            str += temp.data + ", ";
            temp = temp.next;
        }
        str += temp.data;
        return str+"]";
    }
    public int removeFirst(){
        Node temp = head;
        head = head.next;
        int returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }

    public int remove(int k){
        if(k == 0)
            return removeFirst();
        Node temp = node(k-1);
        Node todoDeleted = temp.next;
        temp.next = temp.next.next;
        int returnData = todoDeleted.data;
        if(todoDeleted == tail)
            tail = temp;

        todoDeleted = null;
        size--;
        return returnData;
    }

    public int removeLast(){
        return remove(size-1);
    }

    public int getSize(){
        return size;
    }

    public int getElement(int k){
        Node temp = node(k);
        return temp.data;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addFirst(30);
        System.out.println(list);
        System.out.println(list.remove(1));
        System.out.println(list);
        System.out.println(list.getSize());
        System.out.println(list.getElement(1));
    }
}
