package chatudp;

import java.net.*;

public class client 
{
	@SuppressWarnings("resource")
	public static void main(String args[]) throws Exception
	{
		DatagramSocket ds = new DatagramSocket(5000);
		String msg;
		byte[] buf = new byte[100];
		while(true)
		{
			DatagramPacket rdp = new DatagramPacket(buf,buf.length);
			ds.receive(rdp);
			msg = new String(rdp.getData(),rdp.getOffset(),rdp.getLength());
			/* getData() -> Returns the data buffer. 
			 * The data received or the data to be sent
			 * starts from the offset in the buffer,and runs for length long.
			 */
			System.out.println(msg);
		}
	}

}
