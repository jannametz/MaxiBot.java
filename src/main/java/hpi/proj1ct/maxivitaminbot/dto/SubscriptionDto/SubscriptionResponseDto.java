package hpi.proj1ct.maxivitaminbot.dto.SubscriptionDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * @author Jana Metz on 01.06.23
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubscriptionResponseDto {
    private String subscriptionName;
    private Long subscriptionID;
    private Long userID;
    private Long url;
    private Long title;
}
