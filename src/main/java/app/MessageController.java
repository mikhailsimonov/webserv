package app;

import com.jcraft.jsch.JSchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static utils.Parser.getAnswer;
import static utils.Parser.getRequest;
import static utils.Ssh.getTestData;

@RestController
public class MessageController {

    private final AtomicLong counter = new AtomicLong();
    static String formats;

    public MessageController() throws IOException {
    }

    @RequestMapping("/")
    public String home() {
        return "WTF!?I TESTING";
    }

    @RequestMapping(value = "/chatbot/getformats", method = RequestMethod.GET)
    public String getformats() throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("formats.txt"), StandardCharsets.UTF_8);
        for (String line : lines) {
            formats = line;
            return formats;
        }
        return formats;
    }

    @RequestMapping(value = "/chatbot/getformat", method = RequestMethod.GET)
    public ResponseEntity<ChatBotMessage> get() {
        ChatBotMessage msg = new ChatBotMessage();
        msg.setId(counter.incrementAndGet());
        return new ResponseEntity<ChatBotMessage>(msg, HttpStatus.OK);
    }

    @RequestMapping(value = "/chatbot/{send}", method = RequestMethod.POST)
    public ResponseEntity<String> sendMessage(@RequestBody ChatBotMessage botMessage) {

        if (botMessage.getId() != 0 && botMessage.getConversation_id() != null
                && !botMessage.getText().isEmpty() && botMessage.getMessage_type() != null
                && !botMessage.getToken().isEmpty() && botMessage.getId() != null
                && botMessage.getConversation_id() != null) {
            return new ResponseEntity("FORMAT: SUCCESS! -> message fly to mobile app", HttpStatus.OK);
        }
        else {
            return new ResponseEntity("FORMAT ENCODING: FAIL!", HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/chatbot/getanswer", method = RequestMethod.GET)
    public String getAns(@RequestParam ("login") String login,
                              @RequestParam ("url") String url,
                              @RequestParam ("password") String password) {

        if (login.isEmpty()){
            return ("LOGIN IS EMPTY!");
        }else if(url.isEmpty()){
            return ("URL IS EMPTY!");
        }else if(password.isEmpty()){
            return ("PASSWORD IS EMPTY!");
        }

        try {
            getTestData(login, url, password,
                    "/ai/configs/sb900-external=configs/workdata/original_files/faq",
                    "/src/main/resources/files/К какому оператору сотовой связи можно подключить МБ.json");
        } catch (JSchException e) {
            e.printStackTrace();
        }

        return getAnswer();
    }
    @RequestMapping(value = "/chatbot/getrequest", method = RequestMethod.GET)
    public String getReq(@RequestParam ("login") String login,
                              @RequestParam ("url") String url,
                              @RequestParam ("password") String password) {

        if (login.isEmpty()){
            return ("LOGIN IS EMPTY!");
        }else if(url.isEmpty()){
            return ("URL IS EMPTY!");
        }else if(password.isEmpty()){
            return ("PASSWORD IS EMPTY!");
        }

        try {
            getTestData(login, url, password,
                    "/ai/configs/sb900-external=configs/workdata/original_files/faq",
                    "/src/main/resources/files/К какому оператору сотовой связи можно подключить МБ.json");
        } catch (JSchException e) {
            e.printStackTrace();
        }

        return getRequest();
    }
}






