package support.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    @Builder.Default
    private String id = "0";
    @Builder.Default
    private String username = "theUser";
    @Builder.Default
    private String firstName = "John";
    @Builder.Default
    private String lastName = "James";
    @Builder.Default
    private String email = "john@email.com";
    @Builder.Default
    private String password = "12345";
    @Builder.Default
    private String phone = "12345";
    @Builder.Default
    private String userStatus = "12345";

    
}
