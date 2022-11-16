package com.springboot.chapter3.scope.pojo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter3.scope.pojo
 * @className : ScopeBean
 * @description : TODO
 * @date : 2022/11/16 10:17
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ScopeBean {



}
