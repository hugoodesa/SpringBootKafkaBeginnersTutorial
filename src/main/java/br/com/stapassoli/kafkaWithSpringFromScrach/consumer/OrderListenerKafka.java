package br.com.stapassoli.kafkaWithSpringFromScrach.consumer;

import br.com.stapassoli.kafkaWithSpringFromScrach.DTO.OrderDTO;
import br.com.stapassoli.kafkaWithSpringFromScrach.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderListenerKafka {

    private final OrderService orderService;

    @KafkaListener(
        id = "orderConsumerClient", //id do listener que pode ser omitido e será criado dinamicamente
        topics = "order.created", //de qual tópico vai 'escutar'
        groupId = "order" //grupo
    )
    public void listen(OrderDTO orderDTO) {
        log.info("Recieve message : " + orderDTO);
        orderService.process(orderDTO);
    }

}
