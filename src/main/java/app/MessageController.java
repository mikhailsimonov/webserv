package app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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
}






