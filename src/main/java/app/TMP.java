package app;

public class TMP {

    public static final String FORMATS = "-------------------------------------------------------CHATBOT INNER FORMAT-------------------------------------------------------\n" +
            "//внутрениий формат сообщений чат бота\n" +
            "//kafka (paTopic, vochHandlerTopic, aiHandlerTopic, sbermessHandlerTopic, telegramHandlerTopic)\n" +
            "//обработка реализована - планируется сделать в 02.002.00\n" +
            "{\n" +
            "  \"messageId\" : 48,\n" +
            "  \"messageName\" : \"MESSAGE_FROM_USER\",\n" +
            "  \"userChannel\" : \"SBERBANK_MESSENGER\",\n" +
            "  \"nextSystem\" : \"\",\n" +
            "  \"handlerName\" : \"SBERMESS\",\n" +
            "  \"uuid\" : {\n" +
            "    \"userChannel\" : \"SBERBANK_MESSENGER\",\n" +
            "    \"userId\" : \"48\",\n" +
            "    \"chatId\" : \"48\"\n" +
            "  },\n" +
            "  \"payload\" : {\n" +
            "    \"message\" : \"а мобильный банк платный?\"\n" +
            "  }\n" +
            "}\n" +
            "\n" +
            "\n" +
            "-------------------------------------------------------MESSENGER FORMATS-------------------------------------------------------\n" +
            "FROM MESSENGER TO CHATBOT:\n" +
            "\n" +
            "!!! сообщения могут приходить как по вебхукам так и с помощью полинга в http response.\n" +
            "Для полинга оберткой является следующий формат:\n" +
            "{\n" +
            "  \"success\":true,\n" +
            "  \"messages\":[...]\n" +
            "}\n" +
            "\n" +
            "Для вебхука оберткой является следующий формат:\n" +
            "{\n" +
            "  \"token\" : \"e23742fe-1171-4eca-92c1-ec2cad7264\"\n" +
            "  \"messages\":[...]\n" +
            "}\n" +
            "\n" +
            "Внутренняя структура сообщений:\n" +
            "обычное сообщение от пользователя\n" +
            "POST, /api/handler/sendMessage\n" +
            "обработка реализована - да\n" +
            "Request:\n" +
            "    {\n" +
            "      \"message_id\":\"1\",\n" +
            "      \"conversation_id\":2,\n" +
            "      \"sender\":{\n" +
            "        \"id\":4\n" +
            "      },\n" +
            "      \"type\": 0,\n" +
            "      \"message_name\":\"MESSAGE_FROM_USER\",\n" +
            "      \"content\": {\n" +
            "        \"message\" : \"hello to bot\"\n" +
            "      }\n" +
            "    }\n" +
            "Response:\n" +
            "    {\n" +
            "      \"status\" : \"OK\"\n" +
            "    }\n" +
            "\n" +
            "результат выполнения команды на МП\n" +
            "POST, /api/handler/sendMessage\n" +
            "обработка реализована - да\n" +
            "Request\n" +
            "    {\n" +
            "      \"message_id\":\"1\",\n" +
            "      \"conversation_id\":2,\n" +
            "      \"sender\":{\n" +
            "        \"id\":4\n" +
            "      },\n" +
            "      \"type\":6,\n" +
            "      \"message_name\":\"UFS_SESSION_TOKEN\",\n" +
            "      \"content\": {\n" +
            "        \"token\" : \"ferwfsdf34r23d2\"\n" +
            "      }\n" +
            "    }\n" +
            "Response:\n" +
            "    {\n" +
            "      \"status\" : \"OK\"\n" +
            "    }\n" +
            "\n" +
            "системное сообщение о создании нового чата\n" +
            "POST, /api/handler/sendMessage\n" +
            "обработка реализована - да\n" +
            "Request\n" +
            "    {\n" +
            "      \"message_id\":\"1\",\n" +
            "      \"conversation_id\":2,\n" +
            "      \"sender\":{\n" +
            "        \"id\":4\n" +
            "      },\n" +
            "      \"type\":1,\n" +
            "      \"message_name\":\"CHAT_CREATED\",\n" +
            "      \"content\": {\n" +
            "        \"timestamp\" : 12345\n" +
            "      }\n" +
            "    }\n" +
            "Response:\n" +
            "    {\n" +
            "      \"status\" : \"OK\"\n" +
            "    }\n" +
            "\n" +
            "пользователь пишет сообщение\n" +
            "POST, /api/handler/sendMessage\n" +
            "обработка реализована - нет\n" +
            "Request\n" +
            "    {\n" +
            "      \"message_id\": \"1213125\",\n" +
            "      \"conversation_id\": 2,\n" +
            "      \"sender\": {\n" +
            "        \"id\": 4\n" +
            "      },\n" +
            "      \"type\": 9,\n" +
            "      \"message_name\": \"TYPING\",\n" +
            "      \"content\": {}\n" +
            "    }\n" +
            "\n" +
            "пользователь прочитал сообщения\n" +
            "POST, /api/handler/sendMessage\n" +
            "обработка реализована - нет\n" +
            "Request\n" +
            "    {\n" +
            "      \"message_id\": \"123456\",\n" +
            "      \"conversation_id\": 2,\n" +
            "      \"sender\": {\n" +
            "        \"id\": 4\n" +
            "      },\n" +
            "      \"type\": 2,\n" +
            "      \"message_name\": \"MESSAGES_READ\",\n" +
            "        \"content\": {\n" +
            "        \"last_read_message_id\": 13\n" +
            "      }\n" +
            "    }\n" +
            "\n" +
            "\n" +
            "\n" +
            "FROM CHATBOT TO MESSENGER\n" +
            "текстовый ответ пользователю\n" +
            "POST, /api/channel/sendText\n" +
            "обработка реализована - да\n" +
            "Request\n" +
            "    {\n" +
            "      \"conversation_id\" : 25,\n" +
            "      \"text\" : \"Кредиты выдаются гражданам РФ в возрасте от 18 до 75 лет (не включая) при ...\",\n" +
            "      \"message_type\" : 0,\n" +
            "      \"token\" : \"e23742fe-1171-4eca-92c1-ec2cad726412\"\n" +
            "    }\n" +
            "Response:\n" +
            "    {\n" +
            "      \"success\": true,\n" +
            "      \"message\": {\n" +
            "         \"id\": 34,\n" +
            "         \"conversation_id\": 25,\n" +
            "         \"sender\": {\n" +
            "            \"id\": ?,\n" +
            "         }\n" +
            "         \"type\": 0,\n" +
            "         \"content\": “Кредиты выдаются гражданам РФ в возрасте от 18 до 75 лет (не включая) при ...”\n" +
            "         \"channel_token_id\": ?\n" +
            "      }\n" +
            "    }\n" +
            "\n" +
            "Запрос токена ЕФС\n" +
            "POST, /api/channel/sendText\n" +
            "обработка реализована - да\n" +
            "Request\n" +
            "    {\n" +
            "      \"conversation_id\" : 22,\n" +
            "      \"token\" : \"e23742fe-1171-4eca-92c1-ec2cad726412\",\n" +
            "      \"command_id\" : \"b287c70b-9293-4e26-b7e5-be071f039b9c\"\n" +
            "    }\n" +
            "Response:\n" +
            "    {\n" +
            "        \"success\":true\n" +
            "    }\n" +
            "\n" +
            "-------------------------------------------------------AI FORMATS-------------------------------------------------------\n" +
            "FROM CHATBOT TO AI:\n" +
            "\n" +
            "Cообщение от пользователя.\n" +
            "Kafka, toAi topic\n" +
            "обработка реализована - 02.002.00\n" +
            "{\n" +
            "  \"messageId\" : 9,\n" +
            "  \"messageName\" : \"MESSAGE_FROM_USER\",\n" +
            "  \"uuid\" : {\n" +
            "    \"userChannel\" : \"SBERBANK_MESSENGER\",\n" +
            "    \"userId\" : \"9\",\n" +
            "    \"chatId\" : \"9\"\n" +
            "  },\n" +
            "  \"payload\" : {\n" +
            "    \"message\" : \"а мобильный банк платный?\"\n" +
            "  }\n" +
            "}\n" +
            "\n" +
            "Cообщение о закрытии чата с вотчем.\n" +
            "Kafka, toAi topic\n" +
            "обработка реализована - планируется в 02.003.00\n" +
            " {\n" +
            "   \"messageId\" : 15,\n" +
            "   \"messageName\" : \"VOTCH_CLOSE_CHAT\"\n" +
            "   \"uuid\" : {\n" +
            "     \"userChannel\" : \"SBERBANK_MESSENGER\",\n" +
            "     \"userId\" : \"35\",\n" +
            "     \"chatId\" : \"25\"\n" +
            "   }\n" +
            " }\n" +
            "\n" +
            "\n" +
            "\n" +
            "FROM AI TO CHATBOT:\n" +
            "\n" +
            "Текстовый ответ от AI для пользователя\n" +
            "Kafka, fromAi topic\n" +
            "обработка реализована - 02.002.00\n" +
            " {\n" +
            "   \"messageId\" : 15,\n" +
            "   \"ai_version\" : \"02.002.00\",\n" +
            "   \"uuid\" : {\n" +
            "     \"userChannel\" : \"SBERBANK_MESSENGER\",\n" +
            "     \"userId\" : \"35\",\n" +
            "     \"chatId\" : \"25\"\n" +
            "   },\n" +
            "   \"messages\" : [\n" +
            "     {\n" +
            "        \"message_name\" : \"ANSWER_TO_USER\",\n" +
            "        \"payload\" : {\n" +
            "            \"answer\" : \"первое ответное сообщение\"\n" +
            "        }\n" +
            "     },\n" +
            "     {\n" +
            "        \"message_name\" : \"ANSWER_TO_USER\",\n" +
            "        \"payload\" : {\n" +
            "            \"answer\" : \"второе ответное сообщение\"\n" +
            "        }\n" +
            "     }\n" +
            "   ]\n" +
            " }\n" +
            "\n" +
            "Команда на открытие чата с оператором\n" +
            "Kafka, fromAi topic\n" +
            "обработка реализована - 02.002.00\n" +
            "{\n" +
            "  \"messageId\" : 10,\n" +
            "  \"uuid\" : {\n" +
            "    \"userChannel\" : \"SBERBANK_MESSENGER\",\n" +
            "    \"userId\" : \"10\",\n" +
            "    \"chatId\" : \"10\"\n" +
            "  },\n" +
            "  \"ai_version\" : \"02.002.00\",\n" +
            "  \"messages\" : [ {\n" +
            "    \"message_name\" : \"open_chat\",\n" +
            "    \"payload\" : {\n" +
            "      \"answer\" : \"2018-03-22 19:41:42 : incoming : открой чат с оператором, 10\"\n" +
            "    }\n" +
            "  } ]\n" +
            "}\n" +
            "\n" +
            "\n" +
            " ---------------------------------------------------------VOTCH (UFS CHAT) formats-------------------------------------------------------\n" +
            "FROM UFS TO vochHandler\n" +
            "\n" +
            "сообщение от оператора для пользователя\n" +
            "POST, /api/handler/sendMessage\n" +
            "обработка реализована - да\n" +
            "req\n" +
            "  {\n" +
            "       \"txt\":\"txtValue\",\n" +
            "       \"type\":\"MSG_TO_CHAT\",\n" +
            "       \"userId\":\"userIdValue\"\n" +
            "  }\n" +
            "res\n" +
            "  {\n" +
            "        \"status\": 0,\n" +
            "        \"message\": \"a message was sent from the votch handler to the messenger's server\"\n" +
            "  }\n" +
            "\n" +
            "сообщение от оператора для пользователя\n" +
            "POST, /api/handler/sendMessage\n" +
            "обработка реализована - да\n" +
            "req\n" +
            "  {\n" +
            "       \"txt\":\"txtValue\",\n" +
            "       \"type\":\"OPERATOR_CONNECT\",\n" +
            "       \"userId\":\"userIdValue\"\n" +
            "  }\n" +
            "res\n" +
            "  {\n" +
            "        \"status\": 0,\n" +
            "        \"message\": \"a message was sent from the votch handler to the messenger's server\"\n" +
            "  }\n" +
            "\n" +
            "сообщение от оператора для пользователя\n" +
            "POST, /api/handler/sendMessage\n" +
            "обработка реализована - да\n" +
            "req\n" +
            "  {\n" +
            "       \"txt\":\"txtValue\",\n" +
            "       \"type\":\"CHAT_CLOSE\",\n" +
            "       \"userId\":\"userIdValue\"\n" +
            "  }\n" +
            "res\n" +
            "  {\n" +
            "        \"status\": 0,\n" +
            "        \"message\": \"a message was sent from the votch handler to the messenger's server\"\n" +
            "  }\n" +
            "\n" +
            "\n" +
            "FROM vochHandler to UFS\n" +
            "\n" +
            "создание авторизованного чата в ЕФС\n" +
            "POST, /services/rest/chatbot/createAuthChat\n" +
            "req\n" +
            "{\n" +
            "  \"conversationId\" : \"20\",\n" +
            "  \"ufsSessionId\" : \"117a4bf2-0ed8-4048-9b91-ce159610de5a\",\n" +
            "  \"channel\" : \"900\",\n" +
            "  \"deviceType\" : \"MOBILE\",\n" +
            "  \"clientType\" : \"RETAIL\"\n" +
            "}\n" +
            "res\n" +
            "{\n" +
            "  \"errorCode\":0,\n" +
            "  \"errorMsg\" : null\n" +
            "}\n" +
            "\n" +
            "\n" +
            "сообщение от пользователя в ЕФС\n" +
            "POST, /services/rest/chatbot/sendMsg\n" +
            "req\n" +
            "  {\n" +
            "     \"message\": \"mgsValue\",\n" +
            "     \"conversationId\": \"userIdValue\"\n" +
            "  }\n" +
            "res\n" +
            "  {\n" +
            "     \"errorCode\":0\n" +
            "  }\n" +
            "\n" +
            "\n" +
            "-------------------------------------------------------Telegram-------------------------------------------------------\n" +
            "FROM Telegram handler TO Telegram\n" +
            "{\n" +
            "\t\"chat_id\" : \"3434344\",\n" +
            "\t\"text\" : \"Тестовый текст сообещния для клиента телеграма\"\n" +
            "}\n" +
            "\n" +
            "\n" +
            "\n" +
            "FROM Telegram TO Telegram Handler\n" +
            "{\n" +
            "  \"ok\": true,\n" +
            "  \"result\": [\n" +
            "//это обычное сообщение от клиента, либо команда(если это команда, то телеграм передает его просто как текст через /)\n" +
            "    {\n" +
            "      \"update_id\": 52682911,\n" +
            "      \"message\": {\n" +
            "        \"message_id\": 3621,\n" +
            "        \"from\": {\n" +
            "          \"id\": 446835240,\n" +
            "          \"is_bot\": false,\n" +
            "          \"first_name\": \"Yeldos\",\n" +
            "          \"last_name\": \"Tanikin\",\n" +
            "          \"username\": \"TanikinYeldos\",\n" +
            "          \"language_code\": \"ru-RU\"\n" +
            "        },\n" +
            "        \"chat\": {\n" +
            "          \"id\": 446835240,\n" +
            "          \"first_name\": \"Yeldos\",\n" +
            "          \"last_name\": \"Tanikin\",\n" +
            "          \"username\": \"TanikinYeldos\",\n" +
            "          \"type\": \"private\"\n" +
            "        },\n" +
            "        \"date\": 1519898471,\n" +
            "        \"text\": \"HI\"\n" +
            "      }\n" +
            "    },\n" +
            "//события которые передает телеграм если сообщение было отредактировано, передается простое сообщение в поле edited_message\n" +
            "    {\n" +
            "      \"update_id\": 52682913,\n" +
            "      \"edited_message\": {\n" +
            "        \"message_id\": 3622,\n" +
            "        \"from\": {\n" +
            "          \"id\": 446835240,\n" +
            "          \"is_bot\": false,\n" +
            "          \"first_name\": \"Yeldos\",\n" +
            "          \"last_name\": \"Tanikin\",\n" +
            "          \"username\": \"TanikinYeldos\",\n" +
            "          \"language_code\": \"ru-RU\"\n" +
            "        },\n" +
            "        \"chat\": {\n" +
            "          \"id\": 446835240,\n" +
            "          \"first_name\": \"Yeldos\",\n" +
            "          \"last_name\": \"Tanikin\",\n" +
            "          \"username\": \"TanikinYeldos\",\n" +
            "          \"type\": \"private\"\n" +
            "        },\n" +
            "        \"date\": 1519898478,\n" +
            "        \"edit_date\": 1519898652,\n" +
            "        \"text\": \"How am I?\"\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}\n" +
            "\n" +
            "\n" +
            "\n";

}
