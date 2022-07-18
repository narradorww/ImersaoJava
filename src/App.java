import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // pegar os dados do IMDB 
        // Fazer uma conexao http ok!
        // Fazer uma requisicao GET dos  top 250 ok!
        // Ler o conteudo da resposta ok!
        // Exibir e manipular o conteudo

        // 1. Criar uma conexao http
        String url = "https://alura-imdb-api.herokuapp.com/movies";
        HttpClient client = HttpClient.newHttpClient();
        URI endereco = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();   
        

        // Fazer um parse do conteudo (titulo, poster, classificacao, ano)

        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        System.out.println(listaDeFilmes.size());

        // Exibir os dados do filme
        for (Map<String, String > filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));

            // System.out.println(filme.get("poster"));
            // System.out.println(filme.get("rating"));
            // System.out.println(filme.get("year"));
        }

    }
}
