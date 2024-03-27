package br.com.stapassoli.kafkaWithSpringFromScrach.consumerComponents;

import br.com.stapassoli.kafkaWithSpringFromScrach.messageConverter.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GreetingConsumerComponent {

    @KafkaListener(id = "greeting", groupId = "greetingTopic", containerFactory = "greetingKafkaListenerContainerFactory", topics = "greetingTopic")
    public void readGreeting(Greeting greeting, @Header(KafkaHeaders.RECEIVED_PARTITION) String id) {
        System.out.println("===== Greeting =====");
        System.out.println("partition id : " + id);
        System.out.println(greeting);
        System.out.println("====================");
    }

}
