package br.com.stapassoli.kafkaWithSpringFromScrach.messageConverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Farewell {

    private String message;
    private Integer remainingMinutes;

}
