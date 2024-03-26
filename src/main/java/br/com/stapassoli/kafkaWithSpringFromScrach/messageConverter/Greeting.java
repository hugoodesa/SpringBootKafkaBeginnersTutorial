package br.com.stapassoli.kafkaWithSpringFromScrach.messageConverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Greeting {

    private String msg;
    private String name;

}
