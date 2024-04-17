import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int productCode = sc.nextInt();
		int gasoline = 0;
		int diesel = 0;
		int alcohol = 0;

	

		while (true) {
			if (productCode == 1) {
				alcohol = alcohol + 1;
			} else if (productCode == 2) {
				gasoline = gasoline + 1;
			} else if (productCode == 3) {
				diesel = diesel + 1;
			} else if (productCode == 4) {
				System.out.println("PROGRAMA FINALIZADO! MUITO OBRIGADO!");
				break;
			} else if (productCode > 4 || productCode < 1) {
				System.out.println("Entrada inválida. Digite novamente o código: ");
			}
			productCode = sc.nextInt();

		}

		System.out.println("GASOLINA: " + gasoline);
		System.out.println("DIESEL: " + diesel);
		System.out.println("ÁLCOOL: " + alcohol);

		sc.close();

	}

}
