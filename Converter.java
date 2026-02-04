package CurrencyConverter;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Converter {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://v6.exchangerate-api.com/v6/be92ae17fd7c588675038ca9/latest/USD")) // 1 usd to x currency (daily refreshed)
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(getRequest, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        
        if (!json.contains("\"result\":\"success\""))
            System.out.println("API call was unsuccessful. Response:");
            System.out.println(json);
            return;
    }
}
