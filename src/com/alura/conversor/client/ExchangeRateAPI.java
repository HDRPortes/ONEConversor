package com.alura.conversor.client;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class ExchangeRateAPI {
    public static void main(String[] args) throws IOException, InterruptedException {

        /**
         Se le pide al usuario dos datos: (1) La moneda de origen, y (2) la moneda destino para su conversión.
         El primer dato se guarda en la variable origen.
         El segundo ddato se guarda en la varibale destino.
         */

        String menu = """
                
                ** Conversor de mondedas **
                ** Escriba el número de la opción deseada **
                1 - Dólar - EUR
                2 - Euro - Peso mexicano
                3 - Dólar - Libra esterlina
                4 - Salir
                """;
        Scanner teclado1 = new Scanner(System.in);
        Scanner teclado = new Scanner(System.in);
        Scanner lecturaMoneda = new Scanner(System.in);

        int opcion = 0;
        while (opcion != 4) {
            System.out.println(menu);
            opcion = teclado1.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Ingrese la cantidad a convertir");
                    double valorAConvertir1 = teclado.nextDouble();
                    String direccion = "https://v6.exchangerate-api.com/v6/533d735faca5f3e4560c81c3/pair/USD/EUR/" + valorAConvertir1;
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(direccion))
                            .build();
                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());
                    String json = response.body();

                    JsonParser parser = new JsonParser();
                    JsonObject jsonObject = parser.parse(json).getAsJsonObject();
                    String conversionResult = jsonObject.get("conversion_result").getAsString();
                    System.out.println("El resultado de "+ valorAConvertir1 + " Dólares son: " + conversionResult+" Euros");
                    break;
                case 2:
                    System.out.println("Ingrese la cantidad a convertir");
                    double valorAConvertir2 = teclado.nextDouble();
                    String direccion2 = "https://v6.exchangerate-api.com/v6/533d735faca5f3e4560c81c3/pair/EUR/MXN/" + valorAConvertir2;
                    HttpClient client2 = HttpClient.newHttpClient();
                    HttpRequest request2 = HttpRequest.newBuilder()
                            .uri(URI.create(direccion2))
                            .build();
                    HttpResponse<String> response2 = client2
                            .send(request2, HttpResponse.BodyHandlers.ofString());
                    String json2 = response2.body();

                    JsonParser parser2 = new JsonParser();
                    JsonObject jsonObject2 = parser2.parse(json2).getAsJsonObject();
                    String conversionResult2 = jsonObject2.get("conversion_result").getAsString();
                    System.out.println("El resultado de "+ valorAConvertir2 + " Euros son: " + conversionResult2+" Pesos Mexicanos");
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad a convertir");
                    double valorAConvertir3 = teclado.nextDouble();
                    String direccion3 = "https://v6.exchangerate-api.com/v6/533d735faca5f3e4560c81c3/pair/USD/GBP/" + valorAConvertir3;
                    HttpClient client3 = HttpClient.newHttpClient();
                    HttpRequest request3 = HttpRequest.newBuilder()
                            .uri(URI.create(direccion3))
                            .build();
                    HttpResponse<String> response3 = client3
                            .send(request3, HttpResponse.BodyHandlers.ofString());
                    String json3 = response3.body();

                    JsonParser parser3 = new JsonParser();
                    JsonObject jsonObject3 = parser3.parse(json3).getAsJsonObject();
                    String conversionResult3 = jsonObject3.get("conversion_result").getAsString();
                    System.out.println("El resultado de "+ valorAConvertir3 + " Dólares son: " + conversionResult3+" Libras esterlinas");
                case 4:
                    System.out.println("Finalizando el programa. Muchas gracias por usar nuestros servicios");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
            /**
             Con el uso de la librería Gson se procesa la respuesta json para su correcta interacción con el usuario.
             */

        }
    }
}