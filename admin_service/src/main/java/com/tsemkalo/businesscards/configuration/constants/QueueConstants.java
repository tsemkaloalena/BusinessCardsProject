package com.tsemkalo.businesscards.configuration.constants;

import java.util.ArrayList;
import java.util.List;
//TODO check all used
public class QueueConstants {
    public final static String EXCHANGE_NAME = "x.direct-exchange";
    public final static String DELAYED_EXCHANGE_NAME = "x.delayed-exchange";
    public final static String DLQ_EXCHANGE_NAME = "x.dead-letter-exchange";

    public static final String ADD_TECH_SUPPORTER_REQUEST = "q.add-tech-supporter";
    public static final String SEND_ERROR_MESSAGE = "q.send-error-message";

    public static List<String> getQueueNames() {
        return new ArrayList<String>(List.of(new String[]{
                ADD_TECH_SUPPORTER_REQUEST,
                SEND_ERROR_MESSAGE
        }));
    }

    public static List<String> getDelayedQueueNames() {
        return new ArrayList<>(List.of(new String[] {}));
    }
}
