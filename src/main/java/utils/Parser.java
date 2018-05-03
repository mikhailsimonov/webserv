package utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parser {
    private static final String FILENAME = "src\\main\\resources\\files\\К какому оператору сотовой связи можно подключить МБ.json";
    static String answer = "";
    static String request = "";

    public static String getAnswer() {
        Gson gson = new Gson();

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(FILENAME));
            String s;
            while ((s = reader.readLine()) != null){
                answer +=s;
            }
            answer = answer.substring(1, answer.length() - 1);
            System.out.println(answer);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Parser.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonObject jsonObject = new JsonParser().parse(answer).getAsJsonObject();
        JsonElement ans = jsonObject.getAsJsonObject().get("answer");

        return ans.toString();
    }

    public static String getRequest() {
        Gson gson = new Gson();

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(FILENAME));
            String s;
            while ((s = reader.readLine()) != null){
                request +=s;
            }
            request = request.substring(1, request.length() - 1);
            System.out.println(request);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Parser.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonObject jsonObject = new JsonParser().parse(request).getAsJsonObject();
        JsonElement ans = jsonObject.getAsJsonObject().get("master_question");

        return ans.toString();
    }
}

