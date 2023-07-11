package com.tsemkalo.businesscards.configuration.constants;

import java.util.ArrayList;
import java.util.List;

public class QueueConstants {
    public final static String EXCHANGE_NAME = "x.direct-exchange";
    public final static String DELAYED_EXCHANGE_NAME = "x.delayed-exchange";
    public final static String DLQ_EXCHANGE_NAME = "x.dead-letter-exchange";

    public static final String FORGOT_PASSWORD_MAIL = "q.forgot-password-mail";
    public static final String ACTIVATE_ACCOUNT_MAIL = "q.activate-account-mail";
    public static final String ADD_TECH_SUPPORTER_REQUEST = "q.add-tech-supporter";
    public static final String REJECT_ADDING_TECH_SUPPORT_MAIL = "q.reject-adding-tech-support-mail";
    public static final String DELETE_IF_NOT_ACTIVATED = "q.delete-if-not-activated";
    public static final String SEND_ERROR_TO_ADMIN = "q.send-error-to-admin";

    public static final String MARK_MESSAGE_AS_READ = "q.mark-message-as-read";
    public static final String MARK_CHAT_MESSAGES_AS_READ = "q.mark-chat-messages-as-read";

    public static final String SEND_NOTIFICATION = "q.send-notification";

    public static final int MESSAGE_DELAY_TIME = 1000 * 60 * 60 * 24;

    public static List<String> getQueueNames() {
        return new ArrayList<String>(List.of(new String[]{
                FORGOT_PASSWORD_MAIL,
                ACTIVATE_ACCOUNT_MAIL,
                ADD_TECH_SUPPORTER_REQUEST,
                REJECT_ADDING_TECH_SUPPORT_MAIL,
                MARK_MESSAGE_AS_READ,
                MARK_CHAT_MESSAGES_AS_READ,
                SEND_ERROR_TO_ADMIN
        }));
    }

    public static List<String> getDelayedQueueNames() {
        return new ArrayList<>(List.of(new String[]{DELETE_IF_NOT_ACTIVATED}));
    }
}
