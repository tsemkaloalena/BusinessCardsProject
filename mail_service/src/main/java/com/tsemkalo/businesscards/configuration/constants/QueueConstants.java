package com.tsemkalo.businesscards.configuration.constants;

import java.util.ArrayList;
import java.util.List;

public class QueueConstants {
    public final static String EXCHANGE_NAME = "x.direct-exchange";
    public final static String DELAYED_EXCHANGE_NAME = "x.delayed-exchange";
    public final static String DLQ_EXCHANGE_NAME = "x.dead-letter-exchange";

    public static final String FORGOT_PASSWORD_MAIL = "q.forgot-password-mail";
    public static final String ACTIVATE_ACCOUNT_MAIL = "q.activate-account-mail";

    public static final String SEND_NOTIFICATION = "q.send-notification";

    public static List<String> getQueueNames() {
        return new ArrayList<String>(List.of(new String[]{FORGOT_PASSWORD_MAIL, ACTIVATE_ACCOUNT_MAIL}));
    }

    public static List<String> getDelayedQueueNames() {
        return new ArrayList<>(List.of(new String[] {}));
    }
}
