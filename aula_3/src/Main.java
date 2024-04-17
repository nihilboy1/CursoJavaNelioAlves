import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		double pi = 3.14159;
		
		double rightTriangleArea = (a * c) / 2;
		double circleArea = pi * (c * c);
		double trapezoidArea = ((a + b) * c) / 2;
		double squareArea = b * b;
		double rectangleArea = a * b;
		
		
		System.out.println("TRIANGULO: " + rightTriangleArea);
		System.out.println("CIRCULO: " + circleArea);
		System.out.println("TRAPÉZIO: " + trapezoidArea);
		System.out.println("QUADRADO: " + squareArea);
		System.out.println("RETANGULO: " + rectangleArea);

		
		

		
		
		
		
				
				
		sc.close();

	}

}
