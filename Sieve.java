//Arion Mercado
//10/16/22
//Queue Programming

public class Sieve {
   
    //First value of the queue
    int p;

    //Constructor
    Sieve(){
        p = 2;
    }

    //Implementing Queue
    public interface Queue<Any>{
        int size();
        boolean isEmpty();
        void enqueue(Any thing);
        Any first();
        Any dequeue();
    }

    //Implementing SinglyLinkedList
    public class SinglyLinkedList<Any>{

        //Adding the Node clas
        private class Node<Any>{
            private Any element;
            private Node<Any> next;
            public Node(Any thing, Node<Any> a){
                element = thing;
                next = a;
            }
            public Any getElement() {
                return element;
            }
            public Node<Any> getNext() {
                return next;
            }
            public void setNext(Node<Any> b){
                next = b;
            }
        }

        //Making the initial list empty
        private Node<Any> head = null;
        private Node<Any> tail = null;
        private int size = 0;

        //getting list size
        public int size() {
            return size;
        }
        //checking if list is empty
        public boolean isEmpty(){
            return size == 0;
        }
        //getting first element of list
        public Any first(){
            if (isEmpty()){
                return null;
            }
            return head.getElement();
        }
        //getting last element of list
        public Any last(){
            if(isEmpty()){
                return null;
            }
            return tail.getElement();
        }

        //Adding element to start of list
        public void addFirst(Any thing){
            head = new Node<>(thing, head);
            if (size == 0){
                tail = head;
            }
            size++;
        }
        //Adding element to end of list
        public void addLast(Any thing){
            Node<Any> last = new Node<>(thing, null);
            if(isEmpty()){
                head = last;
            }
            else{
                tail.setNext(last);
            }
            tail = last;
            size++;
        }

        //Removing first element
        public Any removeFirst(){
            if (isEmpty()){
                return null;
            }
            Any start  = head.getElement();
            head = head.getNext();
            size--;
            if(size == 0){
                tail = null;
            }
            return start;
        }
    }

    //Implementing LinkedQueue
    public class LinkedQueue<Any> implements Queue<Any>{
        //Creating LinkedList
        private SinglyLinkedList<Any> list = new SinglyLinkedList<>();
    
        public LinkedQueue(){}
        public int size(){ //Gives size of queue
            return list.size();
        }
        public boolean isEmpty(){ //Checks if queue is empty
            return list.isEmpty();
        }
        public void enqueue(Any thing){ //Adds to the queue
            list.addLast(thing);
        }
        public Any first(){ //Returns what is first in the queue
            return list.first();
        }
        public Any dequeue(){ //Removes what is first from the queue
            return list.removeFirst();
        }
    }

    public void primesTo(int n){
        //Creating a string that will print out primes after
        String AllPrimes = "";
        //int for for loop sizes
        Queue<Integer> numbers = new LinkedQueue<Integer>();
        Queue<Integer> primes = new LinkedQueue<Integer>();

        //Adding all integers from 2 to n into Queue "numbers"
        for(int i = 2; i <= n; i++){
            numbers.enqueue(i);
        }

        while(p <= Math.sqrt(n)){
            //Pushing the first value of numbers queue to prime
            primes.enqueue(p);

            //Creating a new Queue to keep all unelimiated numbers
            Queue<Integer> nonDivisible = new LinkedQueue<Integer>();
            int numbersize = numbers.size();
            for(int i = 0; i < numbersize; i++){
                //Going through numbers and elimiating numbers divisible by p
                if(isDivisible(numbers.first(), p)){
                    numbers.dequeue();
                }
                else{
                    nonDivisible.enqueue(numbers.dequeue());
                }
            }

            //Adding the non-eliminated numbers back to queue
            int nonDivisiblesize = nonDivisible.size();
            for(int i = 0; i < nonDivisiblesize; i++){
                numbers.enqueue(nonDivisible.dequeue());
            }

            p = numbers.first();
        }

        //Adding all elements of number to primes
        int numberSizes = numbers.size();
        for(int i = 0; i < numberSizes; i++){
            primes.enqueue(numbers.dequeue());
        }

        //Making the primes queue into a string of primes
        int primeSize = primes.size();
        for(int i = 0; i < primeSize; i++){
            AllPrimes = AllPrimes + primes.dequeue() + ", ";
        }

        //Removing last comma from AllPrimes
        AllPrimes = AllPrimes.substring(0, AllPrimes.length() - 2);

        //Printing out the number of primes
        System.out.println("Primes up to " + n + " are: " + AllPrimes);
    }

    //Checking divisibility with an isDivisible Function
    public boolean isDivisible(int a, int p){
        if(a % p == 0){
            return true;
        }
        else{
            return false;
        }
    }

}
   


