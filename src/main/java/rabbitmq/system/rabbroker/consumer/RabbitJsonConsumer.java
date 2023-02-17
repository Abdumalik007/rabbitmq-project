package rabbitmq.system.rabbroker.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import rabbitmq.system.rabbroker.dto.User;


@Service
public class RabbitJsonConsumer {
    private final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsume.class);

    @RabbitListener(queues = {"json_queue"})
    public void consume(User user){
        LOGGER.info(String.format("Message received -> %s", user.toString()));
    }

}
