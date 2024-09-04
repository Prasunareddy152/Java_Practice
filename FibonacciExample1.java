class FibonacciExample1
{
public static void main(String args[])
{
int c1=0,c2=1,c3,n,count=10;
System.out.print(c1+" "+c2);
for(n=0;n<count;++n)
{
c3=c1+c2;
System.out.print(" "+c3);
c1=c2;
c2=c3;
}
}
}