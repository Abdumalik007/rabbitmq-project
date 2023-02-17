package rabbitmq.system.rabbroker.publisher;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import rabbitmq.system.rabbroker.dto.User;


@Service
@RequiredArgsConstructor
public class RabbitMQJsonProducer {
    private final RabbitTemplate rabbitTemplate;

    private final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);


    public void sendMessage(User user){
        LOGGER.info(String.format("Message sent -> %s", user.toString()));
        rabbitTemplate.convertAndSend("json_exchange", "json_routing_key", user);
    }

}
