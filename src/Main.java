import Apis.CurrencyService;
import Menu.CurrencyMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Conversor de Monedas con Menú ===");

        while (true) {
            CurrencyMenu.showMenu();

            String baseCurrency = CurrencyMenu.chooseCurrency(scanner, "Seleccione la moneda **base** (número): ");
            String targetCurrency = CurrencyMenu.chooseCurrency(scanner, "Seleccione la moneda **destino** (número): ");

            System.out.print("Ingrese el monto a convertir: ");
            double amount = Double.parseDouble(scanner.nextLine());

            CurrencyService.convertCurrency(baseCurrency, targetCurrency, amount);

            System.out.print("\n¿Desea realizar otra conversión? (s/n): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("s")) break;
        }

        scanner.close();
        System.out.println("¡Gracias por usar el conversor!");
    }
}
