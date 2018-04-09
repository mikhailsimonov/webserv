package app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import static app.TMP.FORMATS;

@RestController
public class MessageController {

    private final AtomicLong counter = new AtomicLong();

    public MessageController() throws IOException {
    }

    @RequestMapping("/")
    public String home() {
        return "WTF!?I TESTING";
    }

    @RequestMapping(value = "/chatbot/getformats", method = RequestMethod.GET)
    public String getformats(){
/*
        List<String> lines = Files.readAllLines(Paths.get("formats.txt"), StandardCharsets.UTF_8);
        for (String line : lines) {
            formats = line;
            return formats;
        }*/
        return FORMATS;
    }

    @RequestMapping(value = "/chatbot/getformat", method = RequestMethod.GET)
    public ResponseEntity<ChatBotMessage> get() {
        ChatBotMessage msg = new ChatBotMessage();
        msg.setId(counter.incrementAndGet());
        return new ResponseEntity<ChatBotMessage>(msg, HttpStatus.OK);
    }

    @RequestMapping(value = "/chatbot/send", method = RequestMethod.POST)
    public ResponseEntity<String> sendMessage(@RequestBody ChatBotMessage botMessage) {

        if (botMessage.getId() != 0 && botMessage.getConversation_id() != null
                && !botMessage.getText().isEmpty() && botMessage.getMessage_type() != null
                && !botMessage.getToken().isEmpty()) {
            return new ResponseEntity("FORMAT: SUCCESS!", HttpStatus.OK);
        } else {
            return new ResponseEntity("FORMAT ENCODING: FAIL!", HttpStatus.CONFLICT);
        }
    }
}






