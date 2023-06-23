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
@Entity(name = "subscriptionDatabase Table")
@Table(name = "subscription")
@Data
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id", length = 45, nullable = false, columnDefinition = "VARCHAR (255)")
    private Long subscriptionID;
    @NotBlank(message = "subscription_name isn't blank")
    @Column(name = "SubscriptionName", length = 300, nullable = false)
    private String subscriptionName;
    @Column(name = "user_id", length = 45, nullable = false, columnDefinition = "VARCHAR (255)")
    private Long userID;
    @NotBlank(message = "title isn't blank")
    @Column(name = "title", length = 300, nullable = false)
    private Long title;

    @NotBlank(message = "url isn't blank")
    @Column(name = "url", length = 300, nullable = false)
    private Long url;

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription subscription = (Subscription) o;
        return Objects.equals(id, subscription.subscriptionID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);

    }
}

