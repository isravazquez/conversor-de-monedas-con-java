import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {


    public TasaDeCambio buscaMoneda(String codigoDeMoneda){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/f99a0dd218facc360703b04a/latest/"+codigoDeMoneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Gson gson = new Gson();

            JsonElement je = gson.fromJson(json, JsonElement.class);
            JsonObject jo = je.getAsJsonObject();
            JsonObject conversion_rates = jo.getAsJsonObject("conversion_rates");
            double ars = conversion_rates.get("ARS").getAsDouble();
            double brl = conversion_rates.get("BRL").getAsDouble();
            double cop = conversion_rates.get("COP").getAsDouble();

            return new TasaDeCambio(ars,brl,cop);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
