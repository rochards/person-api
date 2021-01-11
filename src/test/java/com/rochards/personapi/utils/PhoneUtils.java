package com.rochards.personapi.utils;

import com.rochards.personapi.dto.request.PhoneDTO;
import com.rochards.personapi.entities.Phone;
import com.rochards.personapi.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "(34)998722713";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build(); // esse builder, build veio do @builder do lambok na classe PhoneDTO
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
