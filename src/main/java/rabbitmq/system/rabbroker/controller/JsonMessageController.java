package rabbitmq.system.rabbroker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rabbitmq.system.rabbroker.dto.User;
import rabbitmq.system.rabbroker.publisher.RabbitMQJsonProducer;
import rabbitmq.system.rabbroker.publisher.RabbitMQPublisher;

@RestController
@RequestMapping("/api/v1/json")
@RequiredArgsConstructor
public class JsonMessageController {
    private final RabbitMQJsonProducer rabbitMQJsonProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        rabbitMQJsonProducer.sendMessage(user);
        return ResponseEntity.ok("Successfully sent!");
    }
}
