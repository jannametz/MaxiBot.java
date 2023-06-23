package hpi.proj1ct.maxivitaminbot.dto.UserDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.sql.Timestamp;

/**
 * @author Jana Metz on 01.06.23
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDto {
    private Long chatId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Timestamp registeredAt;
}
