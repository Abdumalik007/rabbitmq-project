package rabbitmq.system.rabbroker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rabbitmq.system.rabbroker.publisher.RabbitMQPublisher;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MessageController {

    private final RabbitMQPublisher rabbitMQPublisher;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam String message){
        rabbitMQPublisher.sendMessage(message);
        return ResponseEntity.ok("Successfully sent!");
    }

}
