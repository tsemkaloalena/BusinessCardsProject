package com.tsemkalo.businesscards.configuration;

import java.util.ArrayList;
import java.util.List;

// TODO replace to each service
public class QueueConstants {
    public final static String EXCHANGE_NAME = "x.direct-exchange";
    public final static String DELAYED_EXCHANGE_NAME = "x.delayed-exchange";
    public final static String DLQ_EXCHANGE_NAME = "x.dead-letter-exchange";

//    public static final String DELETE_IF_NOT_ACTIVATED = "q.delete-if-not-activated";

    public static List<String> getQueueNames() {
        return new ArrayList<String>(List.of(new String[]{}));
    }

    public static List<String> getDelayedQueueNames() {
        return new ArrayList<>(List.of(new String[]{}));
    }
}
