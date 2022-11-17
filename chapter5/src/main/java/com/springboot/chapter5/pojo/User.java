package com.springboot.chapter5.pojo;

import com.springboot.chapter5.converter.SexConverter;
import com.springboot.chapter5.enumeraction.SexEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter5.pojo
 * @className : User
 * @description : TODO
 * @date : 2022/11/17 10:20
 */
//@Entity(name = "user")
@Getter
@Setter
@Table(name = "t_user")
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(name = "user_name")
    private String userName = null;

    @Convert(converter = SexConverter.class)
    private SexEnum sex = null;

    @Column(name = "note")
    private String note = null;


}
