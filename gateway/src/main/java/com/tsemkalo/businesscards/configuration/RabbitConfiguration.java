package com.tsemkalo.businesscards.configuration;

import com.tsemkalo.businesscards.configuration.constants.QueueConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

import static com.tsemkalo.businesscards.configuration.constants.QueueConstants.DELAYED_EXCHANGE_NAME;
import static com.tsemkalo.businesscards.configuration.constants.QueueConstants.DLQ_EXCHANGE_NAME;
import static com.tsemkalo.businesscards.configuration.constants.QueueConstants.EXCHANGE_NAME;

@Slf4j
public class RabbitConfiguration {
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("localhost");
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Declarables directBindings() {
        AmqpAdmin amqpAdmin = amqpAdmin();
        Exchange exchange = new DirectExchange(EXCHANGE_NAME);
        Exchange dlqExchange = new DirectExchange(DLQ_EXCHANGE_NAME);
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("x-delayed-type", "direct");
        Exchange delayedExchange = new CustomExchange(DELAYED_EXCHANGE_NAME, "x-delayed-message", true, false, args);
        amqpAdmin.declareExchange(exchange);
        amqpAdmin.declareExchange(dlqExchange);
        amqpAdmin.declareExchange(delayedExchange);
        for (String queueName : QueueConstants.getQueueNames()) {
            Queue queue = QueueBuilder.durable(queueName).withArgument("x-dead-letter-exchange", DLQ_EXCHANGE_NAME).withArgument("x-dead-letter-routing-key", queueName + ".dlq").build();
            amqpAdmin.declareQueue(queue);
            amqpAdmin.declareBinding(BindingBuilder.bind(queue).to(exchange).with(queueName).noargs());
            declareDLQ(amqpAdmin, dlqExchange, queueName);
        }
        for (String queueName : QueueConstants.getDelayedQueueNames()) {
            Queue queue = QueueBuilder.durable(queueName).withArgument("x-dead-letter-exchange", DLQ_EXCHANGE_NAME).withArgument("x-dead-letter-routing-key", queueName + ".dlq").build();
            amqpAdmin.declareQueue(queue);
            amqpAdmin.declareBinding(BindingBuilder.bind(queue).to(delayedExchange).with(queueName).noargs());
            declareDLQ(amqpAdmin, dlqExchange, queueName);
        }
        return new Declarables();
    }

    private void declareDLQ(AmqpAdmin amqpAdmin, Exchange dlqExchange, String queueName) {
        Queue dlq = QueueBuilder.durable(queueName + ".dlq").build();
        amqpAdmin.declareQueue(dlq);
        amqpAdmin.declareBinding(BindingBuilder.bind(dlq).to(dlqExchange).with(queueName + ".dlq").noargs());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
