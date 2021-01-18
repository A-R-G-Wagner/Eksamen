package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HttpUtils {

    public static String fetchData(String _url) throws MalformedURLException, IOException {
        URL url = new URL(_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

//        con.setRequestProperty("Accept", "application/json;charset=UTF-8");
//        con.setRequestProperty("Accept", "application/json");
//        con.setRequestProperty("Accept-Charset", "UTF-8");
//        con.setRequestProperty("User-Agent", "server");

        Scanner scan = new Scanner(con.getInputStream(), "UTF-8");
        String jsonStr = null;
        if (scan.hasNext()) {
            jsonStr = scan.nextLine();
        }
        scan.close();
        System.out.println("HttpUtils: " + scan);
        System.out.println("HttpUtils(fetchData): " + jsonStr);
        return jsonStr;
    }
}
