package app;

public class ChatBotMessage {

    private long id;
    private Long conversation_id;
    private String text;
    private Long message_type;
    private String token;

    public ChatBotMessage(Long id, Long conversation_id, String text, Long message_type, String token) {
        this.id = id;
        this.conversation_id = conversation_id;
        this.text = text;
        this.message_type = message_type;
        this.token = token;
    }

    public ChatBotMessage() {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public Long getConversation_id() {
        return conversation_id;
    }

    public String getText() {
        return text;
    }

    public Long getMessage_type() {
        return message_type;
    }

    public String getToken() {
        return token;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId(long id) {
        this.id = id;
    }
}