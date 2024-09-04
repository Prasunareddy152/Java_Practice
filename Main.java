class Node
{
int data;
node reference;
Node(int data);
{
this.data=data;
reference=null;
}
}
public class Main{
public static void Main(String args[])
{
Node n1=new Node(10);
Node n2=new Node(20);
Node n3=new Node(30);
Node head=n1;
n1.reference=n2;
n2.reference=n3;
while(head!=null)
{
System.out.print(head.data+"<-");
head=head.reference;
}


