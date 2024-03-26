package br.com.stapassoli.kafkaWithSpringFromScrach.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO {

    private Long id;

    private String item;

}
