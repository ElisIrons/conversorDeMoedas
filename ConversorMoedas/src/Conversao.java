import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversao {

    public Moeda convertendo(String base_code, String target_code) {
        URI moeda = URI.create("https://v6.exchangerate-api.com/v6/82ea9c5bde6d13c9c6b05dc0/pair/" + base_code + "/" + target_code);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(moeda)
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            if (response.body().startsWith("{")) {
                return new Gson().fromJson(response.body(), Moeda.class);
            } else {
                throw new RuntimeException("Moeda não cadastrada, por favor verifique uma moeda válida!");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao buscar moeda!", e);
        }
    }
}
