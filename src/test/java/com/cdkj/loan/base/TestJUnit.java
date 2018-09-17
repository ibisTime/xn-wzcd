package com.cdkj.loan.base;

import java.io.IOException;

import org.unitils.UnitilsJUnit4;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TestJUnit extends UnitilsJUnit4 {

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
            .url(
                "http://apis.haoservice.com/idcard/VerifyIdcard?cardNo=14272719950821351X&realName=柴运来&key=9665866375902170")
            .get().build();

        Response response = client.newCall(request).execute();
        System.out.println(response);
    }
}
