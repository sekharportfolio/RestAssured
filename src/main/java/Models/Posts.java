package Models;

import lombok.Data;

/**
 * Posts pojo class
 */
@Data
public class Posts {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
