package com.narozhnyiyevgen.mavraguide.ui.objects;

public enum UserFields {
    ID("id"), PHONE("phone"), NAME("name"), FULL_NAME("fullName");

   private final String USER_FIELDS_VALUE;

    UserFields(String USER_FIELDS_VALUE) {
        this.USER_FIELDS_VALUE = USER_FIELDS_VALUE;
    }

    public String getUSER_FIELDS_VALUE() {
        return USER_FIELDS_VALUE;
    }
}
