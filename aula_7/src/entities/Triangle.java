package entities;

public class Triangle {
	public double side1;
	public double side2;
	public double side3;

	public double GetArea() {
		double perimeter = (side1 + side2 + side3) / 2;
		return Math.sqrt(perimeter * (perimeter - side1) * (perimeter - side2) * (perimeter - side3));

		 
	}
}
