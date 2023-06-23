package hpi.proj1ct.maxivitaminbot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Jana Metz on 21.05.23
 */
@Builder
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "userDatabase Table")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 45, nullable = false, columnDefinition = "VARCHAR (255)")
    private Long chatId;
    @NotBlank(message = "first_name isn't blank")
    @Column(name = "firstName", length = 50, nullable = false)
    private String firstName;
    @NotBlank(message = "last_name isn't blank")
    @Column(name = "lastName", length = 50, nullable = false)
    private String lastName;
    @NotBlank(message = "user_name isn't blank")
    @Column(name = "UserName", length = 50, nullable = false)
    private String username;
    @NotBlank(message = "Email isn't blank")
    @Column(name = "email", length = 40, unique = true, nullable = false)
    private String email;
    private Timestamp registeredAt;




}
