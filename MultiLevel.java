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
class C extends B
{
int C=50;
void dis()
{
System.out.println("C");
}
}
class MultiLevel
{
public static void main(String args[])
{
C obj=new C();
obj.dis();
obj.show();
obj.display();
}
}