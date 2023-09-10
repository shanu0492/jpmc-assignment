package com.api.validations.commons;

import com.api.model.commons.Constants;

import java.util.regex.Pattern;

public class Common {

    public void isEmailValid(String email){

        Pattern pat = Pattern.compile(Constants.EMAIL_REGEX);
        if(!pat.matcher(email).matches())
            throw new AssertionError("Email Id is invalid "+email);
    }

    public void isValidUsPhoneNumber(String phone){
        boolean var= false;
        if(Pattern.compile(Constants.PHONE_PATTERN_ONE).matcher(phone).matches())
            var = true;
        if(Pattern.compile(Constants.PHONE_PATTERN_TWO).matcher(phone).matches())
            var = true;
        if(Pattern.compile(Constants.PHONE_PATTERN_THREE).matcher(phone).matches())
            var = true;
        if(Pattern.compile(Constants.PHONE_PATTERN_FOUR).matcher(phone).matches())
            var = true;
        if(Pattern.compile(Constants.PHONE_PATTERN_FIVE).matcher(phone).matches())
            var = true;
        if(Pattern.compile(Constants.PHONE_PATTERN_SIX).matcher(phone).matches())
            var = true;
        if(Pattern.compile(Constants.PHONE_PATTERN_SEVEN).matcher(phone).matches())
            var = true;
        if(!var)
            throw new AssertionError("Phone number is invalid "+phone);
    }
}
