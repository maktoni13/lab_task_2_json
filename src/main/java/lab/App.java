package lab;

import lab.model.entity.RatesCatalog;
import lab.model.parser.EntityJsonParser;
import lab.model.parser.GSonDataBindJsonParser;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String json = "[{\"r030\":36,\"txt\":\"Австралійський долар\",\"rate\":20.375627,\"cc\":\"AUD\",\"exchangedate\":\"02.10.2018\"}" +
                ",{\"r030\":124,\"txt\":\"Канадський долар\",\"rate\":22.024371,\"cc\":\"CAD\",\"exchangedate\":\"02.10.2018\"}]";
        EntityJsonParser<RatesCatalog> parser = new GSonDataBindJsonParser();
        RatesCatalog ratesCatalog = parser.parseJsonString(json);
        try{
            ratesCatalog = parser.parseJson(new URL(EntityJsonParser.FINANCE_INFO_URL));
        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        int a = 1;
    }
}
