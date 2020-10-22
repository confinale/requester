import io.ktor.client.HttpClient
import io.ktor.client.request.header
import io.ktor.client.request.put
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.util.cio.toByteArray
import io.ktor.utils.io.core.String
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    runBlocking {
        val client = HttpClient() {
            followRedirects = true
        }

        val response: HttpResponse = client.put<HttpResponse> {
            url("https://vstde-t.estv.admin.ch/api/md/m2m/register/bo")
            header("Authorization", System.getenv().get("token"))
            body = "{\n" +
                    "   \"person\":{\n" +
                    "      \"type\":\"natural\",\n" +
                    "      \"firstName\":\"Christian\",\n" +
                    "      \"lastName\":\"Brüesch\",\n" +
                    "      \"birthDate\":\"1980-03-09\"\n" +
                    "   },\n" +
                    "   \"zip\":\"10115\",\n" +
                    "   \"city\":\"Berlin\",\n" +
                    "   \"state\":\"DE\",\n" +
                    "   \"taxId\":{\n" +
                    "      \"taxNumber\":\"013/345/67891\"\n" +
                    "   }\n" +
                    "}"
        }
        println(String(response.content.toByteArray()))
    }
}
