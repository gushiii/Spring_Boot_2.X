package com.springboot.chapter5.converter;

import com.springboot.chapter5.enumeraction.SexEnum;

import javax.persistence.AttributeConverter;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter5.converter
 * @className : SexConverter
 * @description : TODO
 * @date : 2022/11/17 11:29
 */
public class SexConverter implements AttributeConverter<SexEnum, Integer> {
    @Override
    public Integer convertToDatabaseColumn(SexEnum sex) {
        return sex.getId();
    }

    @Override
    public SexEnum convertToEntityAttribute(Integer id) {
        return SexEnum.getEnumById(id);
    }
}
