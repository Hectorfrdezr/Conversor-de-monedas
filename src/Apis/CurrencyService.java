package Apis;
import Json.ExchangeRateResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class CurrencyService {

    public static void convertCurrency(String base, String target, double amount) {
        try {
            String apiKey = "d7a9247be36c52aff9ee20d8"; // tu clave
            String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + base;
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            in.close();
            conn.disconnect();

            Gson gson = new Gson();
            ExchangeRateResponse exchangeRate = gson.fromJson(response.toString(), ExchangeRateResponse.class);

            if ("success".equals(exchangeRate.result) && exchangeRate.conversion_rates.containsKey(target)) {
                double rate = exchangeRate.conversion_rates.get(target);
                double convertedAmount = amount * rate;

                System.out.printf("\n%.2f %s = %.2f %s (Tasa: %.4f)%n", amount, base, convertedAmount, target, rate);
            } else {
                System.out.println("⚠️ No se pudo obtener la tasa de cambio.");
            }

        } catch (Exception e) {
            System.out.println("❌ Error durante la conversión: " + e.getMessage());
        }
    }
}
