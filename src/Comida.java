import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Comida {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner comida = new Scanner(System.in);
        System.out.println("Que receita você deseja? ");
        var prato = comida.nextLine();

        String pratoCodificado = URLEncoder.encode(prato, StandardCharsets.UTF_8);

        String endereco = "www.themealdb.com/api/json/v1/1/search.php?s=" + pratoCodificado;

        URI uri = URI.create("https://www.themealdb.com/api/json/v1/1/search.php?s=" + pratoCodificado);
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        HttpClient client = HttpClient.newHttpClient();
        /*HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();*/
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

    }
}



