package com.nvl.validator;

import com.nvl.pojo.Menu;
import com.nvl.pojo.User;
import javax.validation.ConstraintViolation;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class WebAppValidator implements Validator {

    @Autowired
    private javax.validation.Validator beanValidator;

    private Set<Validator> validators;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz)
                || Menu.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        for (Validator validator : validators) {
            validator.validate(target, errors);
        }

        Set<ConstraintViolation<Object>> constraintViolations = beanValidator.validate(target);
        for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
            errors.rejectValue(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessageTemplate(), constraintViolation.getMessage());
        }
    }

    public void setValidators(Set<Validator> validators) {
        this.validators = validators;
    }
}
