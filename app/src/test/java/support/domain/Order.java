package support.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order {
    @Builder.Default
    private int id = 10;
    @Builder.Default
    private int petId = 0;
    @Builder.Default
    private int quantity = 1;
    @Builder.Default
    private String shipDate = "2022-06-29T00:00:26.579Z";
    @Builder.Default
    private String status = "approved";
    @Builder.Default
    private boolean complete = true;
}
