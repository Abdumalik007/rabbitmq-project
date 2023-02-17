package rabbitmq.system.rabbroker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rabbitmq.system.rabbroker.publisher.RabbitMQPublisher;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MessageController {

    private final RabbitMQPublisher rabbitMQPublisher;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam String message){
        rabbitMQPublisher.sendMessage(message);
        return ResponseEntity.ok("Successfully sent!");
    }

}
