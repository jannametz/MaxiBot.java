package hpi.proj1ct.maxivitaminbot.dto.VitaminDto;

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
public class VitaminResponseDto {
    private Long vitaminID;
    private Long productID;
    private Long userID;
    private String vitaminName;
    private String benefit;
}
