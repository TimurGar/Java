/**
 * class to test Cipher1 & Cipher2 classes
 * @author Timur Garifullin
 */
public class CryptoTester
{
	public static void main(String [] args)
	{
		// test Cipher 1
		Cipher1 cipher = new Cipher1();
		String encryption = cipher.encrypt("agoodday");
		System.out.println(encryption);
		System.out.println(cipher.decrypt(encryption));

		// test Cipher 2
		Cipher2 cipher2 = new Cipher2();
		encryption = cipher2.encrypt("agoodday");
		System.out.println(encryption);
		System.out.println(cipher2.decrypt(encryption));
	}
}
