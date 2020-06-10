package com.soulballad.usage.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.soulballad.usage.springboot.validation.constraints.IdCard;

import java.io.Serializable;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/5/21 19:25
 */
@Entity
// without @JsonIgnoreProperties, error occurs
// No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor and no properties discovered to create BeanSerializer
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 2, max = 20, message = "{model.user.NAME_SIZE_BETWEEN_2_AND_20}")
    @NotBlank(message = "{model.user.NAME_NOT_BLANK}")
    private String name;

    @Min(value = 1, message = "{model.user.AGE_MIN_1}")
    @Max(value = 200, message = "{model.user.AGE_MAX_200}")
    @NotNull(message = "{model.user.AGE_NOT_NULL}")
    private Integer age;

    @IdCard
    @NotNull(message = "{model.user.ID_CARD_NOT_NULL}")
    private String idCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public User() {}

    public User(String name, Integer age, String idCard) {
        this.name = name;
        this.age = age;
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", idCard='" + idCard + '\'' + '}';
    }
}
