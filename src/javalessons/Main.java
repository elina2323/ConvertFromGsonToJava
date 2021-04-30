package javalessons;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            Main.from_json_to_java();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void from_json_to_java() throws Exception {
        String url = "https://jsonplaceholder.typicode.com/posts";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        Gson gson = new Gson();
        Type accountListType = new TypeToken<ArrayList<BlogAccount>>(){}.getType();
        ArrayList<BlogAccount> blogAccount = gson.fromJson(response.toString(), accountListType);
//        BlogAccount[] blogAccount = gson.fromJson(response.toString(), BlogAccount[].class);
        for (BlogAccount blogAccounts : blogAccount){
            System.out.println("\n" + blogAccounts);
        }
    }
}
