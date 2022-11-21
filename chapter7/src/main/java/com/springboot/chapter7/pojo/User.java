package com.springboot.chapter7.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter7.pojo
 * @className : User
 * @description : TODO
 * @date : 2022/11/21 21:41
 */
@Data
@Alias("user")
public class User implements Serializable {

    private static final long serialVersionUID = 7969691510122077296L;

    private Long id;
    private String userName;
    private String note;

}
