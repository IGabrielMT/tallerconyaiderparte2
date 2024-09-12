package juan.co.edu.uptc.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class JSONReader {

    @SneakyThrows
    public static <T> List<T> readJsonFromUrl(String urlString, Class<T> clazz) {
        URI uri = new URI(urlString);
        HttpURLConnection conn = createConnection(uri);
        String jsonContent = readResponse(conn);
        return parseJson(jsonContent, clazz);
    }

    private static HttpURLConnection createConnection(URI uri) throws Exception {
        URL url = uri.toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }
        return conn;
    }

    private static String readResponse(HttpURLConnection conn) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        StringBuilder jsonContent = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            jsonContent.append(output);
        }
        conn.disconnect();
        return jsonContent.toString();
    }

    private static <T> List<T> parseJson(String jsonContent, Class<T> clazz) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .registerTypeAdapter(Period.class, new PeriodAdapter())
                .create();
        return gson.fromJson(jsonContent, TypeToken.getParameterized(List.class, clazz).getType());
    }
}