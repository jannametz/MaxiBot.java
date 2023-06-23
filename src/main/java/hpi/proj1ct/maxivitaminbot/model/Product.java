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

@Entity(name = "productDatabase Table")
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", length = 45, nullable = false, columnDefinition = "VARCHAR (255)")
    private Long productID;
    @NotBlank(message = "product_name isn't blank")
    @Column(name = "ProductName", length = 300, nullable = false)

    private String productName;
    @NotBlank(message = "product_description isn't blank")
    @Column(name = "ProductDescription", length = 300, nullable = false)
    private String productDescription;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.productID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);

    }

}
