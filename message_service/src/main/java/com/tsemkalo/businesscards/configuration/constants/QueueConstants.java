package com.tsemkalo.businesscards.configuration.constants;

import java.util.ArrayList;
import java.util.List;

public class QueueConstants {
    public final static String EXCHANGE_NAME = "x.direct-exchange";
    public final static String DELAYED_EXCHANGE_NAME = "x.delayed-exchange";
    public final static String DLQ_EXCHANGE_NAME = "x.dead-letter-exchange";

    public static final String MARK_MESSAGE_AS_READ = "q.mark-message-as-read";
    public static final String MARK_CHAT_MESSAGES_AS_READ = "q.mark-chat-messages-as-read";

    public static List<String> getQueueNames() {
        return new ArrayList<String>(List.of(new String[]{MARK_MESSAGE_AS_READ, MARK_CHAT_MESSAGES_AS_READ}));
    }

    public static List<String> getDelayedQueueNames() {
        return new ArrayList<>(List.of(new String[]{}));
    }
}
