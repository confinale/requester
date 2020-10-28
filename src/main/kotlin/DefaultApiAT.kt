import io.ktor.client.HttpClient
import io.ktor.client.engine.ProxyBuilder
import io.ktor.client.engine.http
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.util.cio.toByteArray
import io.ktor.utils.io.core.String
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    runBlocking {

        val proxyHost = System.getProperty("https.proxyHost")
        println("proxyHost: "+proxyHost)
        val proxyPort = System.getProperty("https.proxyPort")
        println("proxyPort: "+proxyPort)

        val client = HttpClient(OkHttp) {
            followRedirects = true
        }

        try {
            val response: HttpResponse = client.get(args[0])
            //val response: HttpResponse = client.get("https://www.formularservice.gv.at/site/fsrv/user/formular.aspx?pid=09e05dcbe1f84f51afb7b482d272accb&pn=B9d218f001088468a9727ec6fffd85b1b")
            //println(String(response.content.toByteArray()))
            println("------------- response.status -------------")
            println(response.status)
            println("------------- response.headers -------------")
            response.headers.forEach { s, list -> println(s + ": " + list) }
            println("------------- response.content -------------")
            println(String(response.content.toByteArray()))

        } catch (e: Exception) {
            println(e.message)
        } finally {
            client.close()
        }
    }
}
