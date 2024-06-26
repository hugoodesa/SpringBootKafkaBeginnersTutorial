package br.com.stapassoli.kafkaWithSpringFromScrach.config.kafka;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String server;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, server);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topicBaeldung() {
        return new NewTopic("baeldung", 1, (short) 1);
    }

    @Bean
    public NewTopic topicGreeting() {
        return new NewTopic("greetingTopic", 1, (short) 1);
    }

}
