package lab.model.parser;

import java.io.File;
import java.net.URL;

public interface EntityJsonParser<T> {
    String ERROR_JSON_CREATING = "JSON creating error";
    String ERROR_JSON_PARSING = "JSON parsing error";
    String CHARSET_UTF = "UTF-8";
    String FINANCE_INFO_URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

    boolean createJson(T entity, File file);
    boolean createJson(T entity, String path);
    String createJsonString(T entity);
    T parseJson(File file);
    T parseJson(String path);
    T parseJson(URL url);
    T parseJsonString(String json);
}
