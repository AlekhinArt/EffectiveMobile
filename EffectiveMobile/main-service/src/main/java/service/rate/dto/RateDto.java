package service.rate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class RateDto {
    private String name;
    private Integer rate;
}
