package br.com.stapassoli.kafkaWithSpringFromScrach.config.producer;

import br.com.stapassoli.kafkaWithSpringFromScrach.messageConverter.Greeting;
import java.util.HashMap;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class GreetingProducer {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String server;

    @Bean
    public ProducerFactory<String, Greeting> greetingProducerFactory() {
        HashMap<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, String.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, Greeting> greetingKafkaTemplate() {
        return new KafkaTemplate<>(greetingProducerFactory());
    }

}