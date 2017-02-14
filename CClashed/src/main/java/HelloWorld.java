package main.java;

public class HelloWorld {

	public HelloWorld(){};
	
	public int add(int a, int b)
	{
		return a + b;
	}
	
	public static void main(String[] args) {
		HelloWorld hw = new HelloWorld();
		System.out.println("Hello World ! 2+2 = " + hw.add(2, 2));
	}
}
