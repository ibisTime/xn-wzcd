package com.cdkj.loan.base;

import java.io.IOException;

import org.springframework.util.Base64Utils;
import org.unitils.UnitilsJUnit4;

public class TestJUnit extends UnitilsJUnit4 {

    public static void main(String[] args) throws IOException {
        String p = "123456";
        byte[] decodeFromString = Base64Utils.decodeFromString(p);
        System.out.println(decodeFromString);

        String encodeToString = Base64Utils.encodeToString(decodeFromString);
        System.out.println(encodeToString);
    }
}
