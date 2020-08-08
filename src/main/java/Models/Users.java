package Models;

import lombok.Data;

/**
 * Users pojo class
 */
@Data
public class Users {
    private Integer id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
}
