class Student1
{
String name;
int rno;
Student1()
{
name="ABC";
rno=123;
}
Student1(String str,int n)
{
name=str;
rno=n;
}
public static void main(String args[])
{
Student1 s1=new Student1();
Student1 s2=new Student1("DEF",456);
System.out.println(s1.name);
System.out.println(s1.rno);
System.out.println(s2.name);
System.out.println(s2.rno);
}
}