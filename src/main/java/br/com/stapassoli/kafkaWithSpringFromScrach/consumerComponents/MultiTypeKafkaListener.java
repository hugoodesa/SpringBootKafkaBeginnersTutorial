package br.com.stapassoli.kafkaWithSpringFromScrach.consumerComponents;

import br.com.stapassoli.kafkaWithSpringFromScrach.messageConverter.Farewell;
import br.com.stapassoli.kafkaWithSpringFromScrach.messageConverter.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@KafkaListener(id = "multiGroup", topics = "multitype")
public class MultiTypeKafkaListener {

    @KafkaHandler
    public void handleGreeting(Greeting greeting) {
        System.out.println("=== MULTI ===");
        System.out.println("Greeting received: " + greeting);
        System.out.println("=== ===== ===");
    }

    @KafkaHandler
    public void handleFarewell(Farewell farewell) {
        System.out.println("=== MULTI ===");
        System.out.println("Farewell received: " + farewell);
        System.out.println("=== ===== ===");
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        System.out.println("=== MULTI ===");
        System.out.println("Unkown type received: " + object);
        System.out.println("=== ===== ===");
    }

}
