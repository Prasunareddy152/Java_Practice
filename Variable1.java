class Variable1
{
static int c=30;
int a=10;
public static void main(String args[])
{
int b=20;
Variable1 v=new Variable1();
System.out.println("Instance variable="+v.a);
System.out.println("Local variable="+b);
System.out.println("static variable="+c);
}
}