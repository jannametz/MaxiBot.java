package hpi.proj1ct.maxivitaminbot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Objects;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * @author Jana Metz on 01.06.23
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "vitaminDatabase Table")
@Table(name = "vitamin")
@Data
public class Vitamin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vitamin_id", length = 45, nullable = false, columnDefinition = "VARCHAR (255)")
    private Long vitaminID;

    @NotBlank(message = "product_id")
    @Column(name = "ProductID", length = 45, nullable = false)
    private Long productID;

    @NotBlank(message = "user_id")
    @Column(name = "UserID", length = 45, nullable = false)
    private Long userID;
    @NotBlank(message = "vitamin_name isn't blank")
    @Column(name = "VitaminName", length = 300, nullable = false)
    private String vitaminName;
    @NotBlank(message = "benefit isn't blank")
    @Column(name = "benefit", length = 300, nullable = false)
    private String benefit;

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vitamin vitamin = (Vitamin) o;
        return Objects.equals(id, vitamin.vitaminID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);

    }
}
