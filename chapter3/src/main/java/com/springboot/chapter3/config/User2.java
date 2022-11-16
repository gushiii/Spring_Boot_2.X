package com.springboot.chapter3.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : chapter1
 * @package : com.springboot.chapter3.pojo
 * @className : User
 * @description : TODO
 * @date : 2022/11/15 17:14
 */
@Data
@Component
public class User2 {

    @Value("2")
    private Long id;
    @Value("user_name_2")
    private String userName;
    @Value("note_2")
    private String note;

}
