package rabbitmq.system.rabbroker.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQConsume {

    private final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsume.class);

    @RabbitListener(queues = {"${spring.rabbitmq.template.default-receive-queue}"})
    public void consume(String message){
        LOGGER.info(String.format("Message received -> %s", message));
    }


}
