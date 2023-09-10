package com.api.model.commons;

public interface Constants {

    String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    String PHONE_PATTERN_ONE = "\\d-\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}";
    String PHONE_PATTERN_TWO = "\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}";
    String PHONE_PATTERN_THREE = "\\d-\\d{3}-\\d{3}-\\d{4}";
    String PHONE_PATTERN_FOUR = "\\(?\\d{3}\\)?-? *\\d{3}-? *-?\\d{4}";
    String PHONE_PATTERN_FIVE = "\\d{3}.\\d{3}.\\d{4}";
    String PHONE_PATTERN_SIX = "\\d{3}.\\d{3}.\\d{4}\\s(x|(ext))\\d{3,5}";
    String PHONE_PATTERN_SEVEN = "\\(?\\d{3}\\)?-? *\\d{3}-? *-?\\d{4}\\s(x|(ext))\\d{3,5}";
}
