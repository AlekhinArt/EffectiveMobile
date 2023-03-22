package service.feedback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class FeedBackDto {
    private String text;
    private String authorName;
    private String productName;
}
