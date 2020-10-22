import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.features.HttpTimeout
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.cio.*
import io.ktor.utils.io.*
import io.ktor.utils.io.core.String
import kotlinx.coroutines.runBlocking
import java.io.*
import java.net.*

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
