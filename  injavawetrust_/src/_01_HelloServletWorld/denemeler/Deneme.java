package _01_HelloServletWorld.denemeler;

public class Deneme {

	public static void main(String[] args) 
	{
		//burada c linefeed oluyor.
		char c = 0x000A;
		System.out.print("başladı");
		System.out.print(c);
		System.out.print("bitti");
		System.out.print(c);
		
		double inf = Double.POSITIVE_INFINITY;
		double j = 1.0/0;
		
		if(inf == j) 
		{
			System.out.println("önerme doğru");
		}
		
		double i =  0.0/0.0;
		
		System.out.println(i);
		
		if(Integer.MIN_VALUE == -Integer.MIN_VALUE) 
		{
			
			// HAKKATEN DOĞRU ÇIKIYOR...
			System.out.println("doğru");
		}
	}

}
