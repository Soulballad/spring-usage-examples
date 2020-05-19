package com.soulballad.usage.springboot.config.config;

import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user实体类
 * @since ：2020/5/19 20:29
 */
@Component
@Validated
@ConfigurationProperties(prefix = "user.prop")
public class UserProperties {

    @NotBlank
    private String name;

    @Range(min = 1, max = 200)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
