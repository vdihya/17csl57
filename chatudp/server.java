package chatudp;

import java.io.*;
import java.net.*;

public class server 
{
	@SuppressWarnings("resource")
	public static void main(String args[]) throws Exception
	{
		DatagramSocket ds = new DatagramSocket();
		/*Constructs a datagram socket and binds it to any available port on the local host machine.
		The socket will be bound to the wildcard address,an IP address chosen by the kernel.
		*/ 
		InetAddress ip = InetAddress.getByName("localhost");
		/* InetAddress = IP address class to rep an IP address
		 * getByName = Determines the IP address of a host, given the host's name. 
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int port = 5000;
		String msg;
		while(true)
		{
			msg=br.readLine();
			DatagramPacket dp = new DatagramPacket(msg.getBytes(),msg.length(),ip,port);
			/*Constructs a datagram packet for sending packets of length length to the specified port number on the specified host.
			 	The length argument must be less than or equal to buf.length.
				Parameters:
				buf the packet data.
				length the packet length.
				address the destination address.
				port the destination port number. 
			*/
			if(!msg.equals("quit"))
			{
				ds.send(dp);
				
			}
			else
				break;
			
		}
		
	}
}
