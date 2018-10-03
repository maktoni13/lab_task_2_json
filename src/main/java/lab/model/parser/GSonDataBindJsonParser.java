package lab.model.parser;

import com.google.gson.Gson;
import lab.model.entity.Rate;
import lab.model.entity.RatesCatalog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class GSonDataBindJsonParser implements EntityJsonParser<RatesCatalog> {
    private static final Logger LOGGER = LoggerFactory.getLogger(GSonDataBindJsonParser.class);

    @Override
    public boolean createJson(RatesCatalog entity, String path) {
        File file = new File(path);
        return createJson(entity, file);
    }

    @Override
    public RatesCatalog parseJson(String path) {
        File file = new File(path);
        return parseJson(file);
    }

    @Override
    public boolean createJson(RatesCatalog entity, File file) {
        return true;
    }

    @Override
    public String createJsonString(RatesCatalog entity) {
        Gson gson = new Gson();
        return gson.toJson(entity.getRates());
    }

    @Override
    public RatesCatalog parseJson(File file) {
        return null;
    }

    @Override
    public RatesCatalog parseJson(URL url) {
        try {
            URLConnection con = url.openConnection();
            con.setDoOutput(false);
            con.setDoInput(true);
            con.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while((inputLine = br.readLine()) != null){
                response.append(inputLine);
            }
            return parseJsonString(response.toString());
        } catch (IOException e){
            LOGGER.error(ERROR_JSON_PARSING, e);
            return null;
        }
    }

    @Override
    public RatesCatalog parseJsonString(String json) {
        Gson gson = new Gson();
        Rate[] rates = gson.fromJson(json, Rate[].class);
        RatesCatalog ratesCatalog = new RatesCatalog();
        ratesCatalog.setRates(Arrays.asList(rates));
        return ratesCatalog;
    }
}
