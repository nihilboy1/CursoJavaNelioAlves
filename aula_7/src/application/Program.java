package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Triangle firstTriangle, secondTriangle;
		firstTriangle = new Triangle();
		secondTriangle = new Triangle();

		System.out.println("Enter de measures of the first triangle: ");
		firstTriangle.side1 = sc.nextDouble();
		firstTriangle.side3 = sc.nextDouble();
		firstTriangle.side3 = sc.nextDouble();
		double firstTriangleArea = firstTriangle.GetArea();

		System.out.println("Enter de measures of the second triangle: ");
		secondTriangle.side1 = sc.nextDouble();
		secondTriangle.side2 = sc.nextDouble();
		secondTriangle.side3 = sc.nextDouble();
		double secondTriangleArea = secondTriangle.GetArea();


		System.out.printf("First triangle area: %.4f%n", firstTriangleArea);
		System.out.printf("Second triangle area: %.4f%n", secondTriangleArea);

		if (secondTriangleArea > firstTriangleArea) {
			System.out.println("Larger area: First Triangle");
		} else {
			System.out.println("Larger area: Second Triangle");
		}

		sc.close();

	}

}
