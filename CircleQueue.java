public class CircleQueue{
   int size;
   int front,rear;
   int arr[];
   CircleQueue(int size)
   {
       this.size =size;
       front=rear=-1;
       arr = new int[size];
   }
   boolean isEmpty()
   {
       if(front==-1&&rear==-1)
       {
           return true;
       }
       return false;
   }
   boolean isFull()
   {
       if(front==0 && rear==size-1)
       {
           return true;
       }
       return false;
   }
   void enque(int data)
   {
     if(isFull())
     {
       System.out.println("Full");
     }else{
       if(front==-1){front=0;}
    
           rear=(rear+1)%size;
           arr[rear]=data;
          
    
     }
   }
   void deque()
   {
       if(isEmpty()){System.out.println("Empty");}
       else{
           arr[front]=0;
           front=(front+1)%size;
       }
   }
   void display()
   {
       System.out.print("Fornt->");
       for(int i: arr)
       {
           System.out.print("|"+i+"|");
       }
       System.out.print("<-Rear");


   }
}


public class Main{
   public static void main(String argss[])
   {
       CircleQueue cq=new CircleQueue(5);
       cq.enque(9);
       cq.enque(2);
       cq.enque(7);
       cq.enque(3);
       cq.enque(6);
       cq.deque();
       cq.deque();
       cq.enque(8);
       cq.enque(9);
       cq.display();


   }
}
