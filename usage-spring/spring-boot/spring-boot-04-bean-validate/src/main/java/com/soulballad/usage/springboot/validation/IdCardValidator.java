package com.soulballad.usage.springboot.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.soulballad.usage.springboot.validation.constraints.IdCard;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : IdCard校验：注解{@link IdCard}的校验功能实现，需要实现{@link ConstraintValidator}接口， 泛型中两个参数分别为 {@link IdCard} 和 @IdCard
 *          修饰的字段对应类型
 * @since ：2020/5/21 19:38
 */
public class IdCardValidator implements ConstraintValidator<IdCard, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 校验身份证号：正规身份证号 18=2(省)+2(市)+2(区/县)+8(出生日期)+2(顺序码)+1(性别)+1(校验码)
        // 这里使用正则简单校验一下
        if (value.length() != 18) {
            return false;
        }

        // 身份证号正则表达式
        String regex = "^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";

        return Pattern.matches(regex, value);
    }

    @Override
    public void initialize(IdCard constraintAnnotation) {

    }
}
