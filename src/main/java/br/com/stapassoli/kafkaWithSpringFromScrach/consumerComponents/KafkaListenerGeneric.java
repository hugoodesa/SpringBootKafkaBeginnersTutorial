package br.com.stapassoli.kafkaWithSpringFromScrach.consumerComponents;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaListenerGeneric {

    @KafkaListener(topics = "baeldung", groupId = "fooOne")
    public void listenGroupFooOne(String message) {
        System.out.println("Received Message in group fooOne: " + message);
    }

    @KafkaListener(topics = "baeldung", groupId = "fooTwo")
    public void listenGroupFooTwo(String message) {
        System.out.println("Received Message in group fooTwo: " + message);
    }

}
