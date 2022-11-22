package com.springboot.chapter8.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter8.pojo
 * @className : User
 * @description : TODO
 * @date : 2022/11/21 23:56
 */
@Document
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 4316118709256889452L;

    @Id
    private Long id;

    @Field("user_name")
    private String userName;

    private String note;

    private List<Role> roles = null;
}
