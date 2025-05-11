package Principal;

import java.util.Scanner;

import static Api.SolicitudDeAPi.convertCurrency;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Conversor de Monedas ===");

        while (true) {
            System.out.print("\nMoneda de origen (por ejemplo, USD): ");
            String from = scanner.nextLine().toUpperCase();

            System.out.print("Moneda de destino (por ejemplo, EUR): ");
            String to = scanner.nextLine().toUpperCase();

            System.out.print("Monto a convertir: ");
            double amount = Double.parseDouble(scanner.nextLine());

            convertCurrency(from, to, amount);

            System.out.print("¿Deseas convertir otra moneda? (s/n): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                break;
            }
        }

        scanner.close();
        System.out.println("¡Gracias por usar el conversor!");
    }
}
