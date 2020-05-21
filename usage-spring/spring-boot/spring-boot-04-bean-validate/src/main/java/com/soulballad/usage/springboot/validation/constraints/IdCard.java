package com.soulballad.usage.springboot.validation.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;

import com.soulballad.usage.springboot.validation.IdCardValidator;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : 自定义注解校验 {@link com.soulballad.usage.springboot.model.User} 中的idCard字段
 *  该注解中参数和 {@link NotNull} 中成员一致，不过 {@link NotNull} 中通过 {@link Repeatable} 声明了它是可复用的，
 *  并通过 {@link Constraint} 注解声明注解的功能实现类
 * @since ：2020/5/21 19:33
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {IdCardValidator.class})
public @interface IdCard {

    // ValidationMessages.properties 扩展自
    // org.hibernate.validator.hibernate-validator.6.0.19.Final.hibernate-validator-6.0.19.Final.jar!\org\hibernate\validator\ValidationMessages.properties
    String message() default "{com.soulballad.usage.model.validation.id.card.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
