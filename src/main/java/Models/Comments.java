package Models;

import lombok.Data;
/**
 * Comments pojo class
 */
@Data
public class Comments {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;
}
