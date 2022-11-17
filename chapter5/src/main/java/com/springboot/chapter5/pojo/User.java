package com.springboot.chapter5.pojo;

import com.springboot.chapter5.enumeraction.SexEnum;
import lombok.Data;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter5.pojo
 * @className : User
 * @description : TODO
 * @date : 2022/11/17 10:20
 */
@Data
public class User {

    private Long id = null;
    private String userName = null;
    private SexEnum sex = null;
    private String note = null;

}
