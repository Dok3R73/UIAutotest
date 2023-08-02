package utils;

import com.google.gson.Gson;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.json.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Set;

public class CookiesMapper {

    public Boolean existsFileCookies() {
        File cookiesFile = new File("cookies.json");
        return cookiesFile.exists();
    }

    public Set<Cookie> readCookiesFromFile() {
        Set<Cookie> cookies = null;
        try (Reader reader = new FileReader("cookies.json")) {
            Gson gson = new Gson();
            Type setType = new TypeToken<Set<Cookie>>() {
            }.getType();
            cookies = gson.fromJson(reader, setType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cookies;
    }

    public void saveCookiesToFile(Set<Cookie> cookies) {
        try (FileWriter fileWriter = new FileWriter("cookies.json")) {
            Gson gson = new Gson();
            gson.toJson(cookies, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFileCookies() {
        File file = new File("cookies.json");
        if (file.exists()) {
            file.delete();
        }
    }
}
