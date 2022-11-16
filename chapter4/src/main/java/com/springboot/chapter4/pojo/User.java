package com.springboot.chapter4.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter4.pojo
 * @className : User
 * @description : TODO
 * @date : 2022/11/16 19:14
 */

@Data
public class User {

    private Long id;
    private String userName;
    private String note;

}
