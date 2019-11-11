import java.io.*;
import java.security.*;
import java.math.*;
public class rsa {
	private BigInteger n,p,q,phi,d,e;
	private int bitlen;
	 public rsa(int bits)
	{
		SecureRandom r = new SecureRandom();
		bitlen = bits;
		p = new BigInteger(bitlen/2,100,r);
		q = new BigInteger(bitlen/2,100,r);
		n = p.multiply(q); // public key
		phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)); // private key
		e = new BigInteger(bitlen/2,100,r);
		while(e.compareTo(BigInteger.ONE)>0 && e.compareTo(phi)<0)
		{
			if(phi.gcd(e).equals(BigInteger.ONE))
				break;
		}
		System.out.println("value of e: "+e);
		d = e.modInverse(phi);
		System.out.println("value of d: "+d);
		
		
		
	}
	 
	 public BigInteger encryption(BigInteger M)
	 {
		 return M.modPow(e,n);
	 }
	 
	 public BigInteger decryption(BigInteger C)
	 {
		 return C.modPow(d, n);
	 }
	 public static void main(String args[]) throws IOException
	 {
		 rsa rs = new rsa(1024);
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String text1,text2;
		 BigInteger plaintext,ciphertext;
		 System.out.println("Enter plaintext: ");
		 text1 = br.readLine();
		 plaintext = new BigInteger(text1.getBytes());
		 System.out.println("Ciphertext: ");
		 ciphertext = rs.encryption(plaintext);
		 System.out.println(ciphertext);
		 plaintext = rs.decryption(ciphertext);
		 text2 = new String(plaintext.toByteArray());
		 System.out.println("Decrypted message: ");
		 System.out.println(text2);
	 }
}
