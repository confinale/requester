import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Request {
  public static void main(String[] args) throws IOException, InterruptedException {

    System.out.println("start request");
    HttpClient.Builder builder = HttpClient.newBuilder();
    if(args.length>1){
      builder.proxy(ProxySelector.of(new InetSocketAddress(args[1], Integer.parseInt(args[2]))));
    }
    String body = builder
              .build()
              .send(HttpRequest
                      .newBuilder()
                      .uri(URI.create(args[0]))
                      .build(), HttpResponse.BodyHandlers.ofString()).body();

    System.out.println("finished request (body):" + body);
  }
}
