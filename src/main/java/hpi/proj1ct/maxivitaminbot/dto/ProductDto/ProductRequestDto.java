package hpi.proj1ct.maxivitaminbot.dto.ProductDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Id;
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

public class ProductRequestDto {

        @Id
        private Long productID;
        private String productName;
        private String productDescription;

    }
