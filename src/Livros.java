import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Livros {
          public static void main(String[] args) throws IOException, InterruptedException {
            Scanner leitura = new Scanner(System.in);
            System.out.println("Digite um livro para busca: ");
            var livro = leitura.nextLine();

            String chave = "AIzaSyB16Z6j0JGEEOdQ4hqXv4bLEnzrugbW1ZQ";
            String endereco = "https://www.googleapis.com/books/v1/volumes?q=" + livro + "&key=" + chave;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }
    }


