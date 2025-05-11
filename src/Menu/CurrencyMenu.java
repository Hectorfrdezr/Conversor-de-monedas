package Menu;

import java.util.*;

public class CurrencyMenu {
    private static final Map<Integer, String> currencies = new LinkedHashMap<>();

    static {
        currencies.put(1, "USD");
        currencies.put(2, "EUR");
        currencies.put(3, "GBP");
        currencies.put(4, "JPY");
        currencies.put(5, "MXN");
        currencies.put(6, "CAD");
        currencies.put(7, "BRL");
        currencies.put(8, "ARS");
        currencies.put(9, "CLP");
        currencies.put(10, "CNY");
    }

    public static void showMenu() {
        System.out.println("\nMonedas disponibles:");
        for (Map.Entry<Integer, String> entry : currencies.entrySet()) {
            System.out.printf("%d. %s%n", entry.getKey(), entry.getValue());
        }
    }

    public static String chooseCurrency(Scanner scanner, String prompt) {
        int option;
        while (true) {
            System.out.print(prompt);
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (currencies.containsKey(option)) {
                    return currencies.get(option);
                } else {
                    System.out.println("⚠️ Opción inválida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida. Escriba solo el número de la opción.");
            }
        }
    }
}
