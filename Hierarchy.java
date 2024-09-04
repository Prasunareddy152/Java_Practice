class A
{
int a=20;
void display()
{
System.out.println("A");
}
}
class B extends A
{
int b=30;
void show()
{
System.out.println("B");
}
}
class C extends A
{
int C=50;
void dis()
{
System.out.println("C");
}
}
class Hierarchy
{
public static void main(String args[])
{
C obj1=new C();
obj1.dis();
obj1.display();
B obj2=new B();
obj2.show();
obj2.display();
}
}