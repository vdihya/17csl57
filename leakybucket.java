import java.util.*;

public class leakybucket 
{
	static int orate,max,n;

	static int content =0,remaining=0;
	static char status;
	
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of packets in burst: ");
		n = sc.nextInt();
		System.out.println("Enter output rate of packets in packets/second: ");
		orate = sc.nextInt();
		System.out.println("Enter the maximum buffer queue size: ");
		max = sc.nextInt();
		int in[] = new int[n];
		System.out.println("Enter the burst packet values: ");
		for(int i=0;i<n;i++)
		{
			in[i] = sc.nextInt();
			compute(in[i]);

		}
		
	}
	public static void compute(int input)
	{
		System.out.println("Input rate \t Content \t Status \t Remaining content ");
		
		content += input;
		if(content<=max)
		{
			status = 'A';
		}
		else 
		{
			status = 'R';
			content -= input;
		}
		remaining = content - orate;
		if(remaining<0)
		{
			remaining = 0;
		}
		System.out.println(input + "\t" + content + "\t" + status + "\t" + remaining);
		content = remaining;
	}
}
