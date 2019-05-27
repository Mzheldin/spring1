package com.geekbrains.geekspring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {

    private Pattern pattern;
    private Matcher matcher;
    private static final String PHONE_PATTERN = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";

    @Override
    public boolean isValid(final String phone, final ConstraintValidatorContext constraintValidatorContext) {
        pattern = Pattern.compile(PHONE_PATTERN);
        if (phone == null) return false;
        matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
