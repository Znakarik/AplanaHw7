
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetRequest {
    static String sURL = "http://speller.yandex.net/services/spellservice";

    public static void main(String[] args) throws IOException {

        CloseableHttpResponse response1 = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(sURL + "/checkText?text=кагда+нибудь+я+стану+праграмистом");

            response1 = httpClient.execute(httpGet);
            System.out.println(EntityUtils.toString(response1.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert response1 != null;
                response1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
