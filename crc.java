import java.util.*;
public class crc
{
	public static void main(String args[])
	{
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int k,flag=0,g;
		int dataR[] = new int[100];
		int data[] = new int[100];
		int gen[]  = new int[100];
		int codedata[] = new int[100];
		int codedataR[] = new int[100];
		
		System.out.println("Enter number of bits of message: ");
		k = sc.nextInt();
		System.out.println("Enter number of generator bits: ");
		g = sc.nextInt();
		System.out.println("Enter message: ");
		for(int i=0;i<k;i++)
		{
			data[i] = sc.nextInt();
		}
		System.out.println("Enter Generator: ");
		for(int i=0;i<g;i++)
		{
			gen[i] = sc.nextInt();
		}
		for(int i=k;i<k+g-1;i++)
		{
			data[i]=0;
		}
		System.out.println("\nAppended data is: \n");
		for(int i=0;i<k+g-1;i++)
		{
			System.out.print(data[i]);
		}
		
		codedata = div(data,gen,k,g);
		
		System.out.println("\nChecksum is: \n");
		for(int i=k;i<k+g-1;i++)
		{
			data[i] = codedata[i];
			System.out.print(data[i]);
		}
		System.out.println("\nSender codeword is: \n");
		for(int i=0;i<k+g-1;i++)
		{
			System.out.print(data[i]);
		}
		System.out.println("Enter the codeword received: ");
		for(int i=0;i<k+g-1;i++)
		{
			dataR[i] = sc.nextInt();
		}
		
		codedataR = div(dataR,gen,k,g);
		for(int i=k;i<k+g-1;i++)
		{
			if(codedataR[i]!=0)	flag=1;
			else flag=0;
		}
		if(flag==1)
			System.out.println("Error!");
		else System.out.println("No error.");
	}
	
	public static int[] div(int data[],int gen[],int n,int g)
	{
		int k,msb;
		int r[] = new int[100];
		for(int i=0;i<g;i++)
		{
			r[i] = data[i];
		}
		for(int i=0;i<n;i++)
		{
			k=0;
			msb = r[i];
			for(int j=i;j<g+i;j++)
			{
				if(msb==0)
					r[j]=r[j]^0;
				else
					r[j]=r[j]^gen[k];
				k++;
			}
			r[g+i]=data[g+i];
		}
		return r;
	}
}