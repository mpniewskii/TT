import java.io.InputStream;
import java.net.URI;
import java.net.URLConnection;
import org.json.JSONTokener;
import org.json.JSONObject;

public class Api {
    public static JSONObject pobierz(String adres) throws Exception {
        URLConnection polaczenie = URI.create(adres)
                .toURL()
                .openConnection();

        polaczenie.setConnectTimeout(20000);
        polaczenie.setReadTimeout(20000);

        try (InputStream dane = polaczenie.getInputStream()) {
            return new JSONObject(new JSONTokener(dane));
        }
    }
}