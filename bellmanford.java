import java.util.*;
public class bellmanford {
public static void main(String args[])
{
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number of vertices: ");
	int n  = sc.nextInt();
	System.out.println("Enter the weighted graph: ");
	int a[][] = new int[n+1][n+1];
	for(int i=1;i<=n;i++)
	{
		for(int j=1;j<=n;j++)
		{
			a[i][j] = sc.nextInt();
		}
	}
	System.out.println("Enter the source: ");
	int s = sc.nextInt();
	int d[] = new int[n+1];
	for(int i=1;i<=n;i++)
	{
		d[i] = 99;
		
	}
	d[s] = 0;
	for(int k=1;k<=n-1;k++)
	{
		for(int j=1;j<=n;j++)
		{
			for(int i=1;i<=n;i++)
			{
				if(a[i][j]!=99)
				{
					if(d[j]>d[i]+a[i][j])
						d[j] = d[i] + a[i][j];
				}
			}
		}
	}
	System.out.println("The shortest path is: ");
	for(int i=1;i<=n;i++)
	{
		System.out.println(s+" -> "+i+" = "+d[i]);
	}
}
}
