package com.springboot.chapter5.pojo;

import com.springboot.chapter5.converter.SexConverter;
import com.springboot.chapter5.enumeraction.SexEnum;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter5.pojo
 * @className : User2
 * @description : TODO
 * @date : 2022/11/17 15:52
 */
@Alias(value = "user2")
@Data
public class User2 {

    private Long id = null;

    private String user_name = null;

    private SexEnum sex = null;

    private String note = null;

}
