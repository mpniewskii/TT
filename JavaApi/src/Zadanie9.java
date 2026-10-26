import org.json.JSONArray;
import org.json.JSONObject;

public class Zadanie9 {
    public static void main(String[] args) throws Exception {
        String adres = "https://store.steampowered.com/api/featuredcategories/?cc=pl&l=polish";

        JSONObject odpowiedz = Api.pobierz(adres);
        JSONObject specials = odpowiedz.getJSONObject("specials");
        JSONArray items = specials.getJSONArray("items");

        int minimalnyRabat = 75;

        for (int indeks = 0; indeks < items.length(); indeks++) {
            JSONObject oferta = items.getJSONObject(indeks);

            int rabat = oferta.getInt("discount_percent");

            if (rabat >= minimalnyRabat) {
                String nazwa = oferta.getString("name");

                System.out.println(nazwa);
                System.out.println("Rabat: " + rabat + "%");
            }
        }
    }
}