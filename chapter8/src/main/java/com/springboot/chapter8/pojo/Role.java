package com.springboot.chapter8.pojo;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter8.pojo
 * @className : Role
 * @description : TODO
 * @date : 2022/11/21 23:59
 */
@Document
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = 9222705634062929844L;

    private Long id;
    @Field("role_name")
    private String roleName = null;
    private String note = null;

}
