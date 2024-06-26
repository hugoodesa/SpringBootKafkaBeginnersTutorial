package br.com.stapassoli.kafkaWithSpringFromScrach.messageConverter;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty(value = "msg")
    private String msg;

    @JsonProperty(value = "name")
    private String name;

}
