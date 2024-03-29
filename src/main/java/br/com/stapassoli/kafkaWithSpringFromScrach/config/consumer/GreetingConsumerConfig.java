package br.com.stapassoli.kafkaWithSpringFromScrach.config.consumer;

import br.com.stapassoli.kafkaWithSpringFromScrach.handler.KafkaErrorHandler;
import br.com.stapassoli.kafkaWithSpringFromScrach.messageConverter.Greeting;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class GreetingConsumerConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String server;

    @Bean
    public DefaultKafkaConsumerFactory<String, Greeting> greetingConsumerFactory() {

        final String groupId = "order"; // according to the group id
        Map<String, Object> config = new HashMap<>();

        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, server);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JsonDeserializer<>(Greeting.class));
    }

    @Bean
    CommonErrorHandler commonErrorHandler() {
        return new KafkaErrorHandler();
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Greeting> greetingKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Greeting> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(greetingConsumerFactory());
        factory.setCommonErrorHandler(commonErrorHandler());

        return factory;
    }

}
