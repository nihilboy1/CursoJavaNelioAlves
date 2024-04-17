import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		
		if (number > 0) {
			System.out.println("NUMERO POSITIVO!");
		}else if (number == 0 ) {
			System.out.println("ZERO");
		}else {
			System.out.println("NUMERO NEGATIVO!");
		}
		
		
		
		sc.close();

	}

}
