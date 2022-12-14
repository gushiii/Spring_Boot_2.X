package com.springboot.chapter3.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : chapter1
 * @package : com.springboot.chapter3.pojo
 * @className : User3
 * @description : TODO
 * @date : 2022/11/15 17:45
 */
@Data
@Component
public class User3 {

    @Value("3")
    private Long id;
    @Value("user_name_3")
    private String userName;
    @Value("note_3")
    private String note;

}
