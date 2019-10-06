package com.mars.elleshop.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.Random;

public class MessageUtils {

    public static Boolean sendMessage(String phone, String code) throws ClientException {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FqV89S4jJKJPZkKJo9k", "xLPZCyn9IVeNSolCBGQdfIvedhjdac");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "ELLESHOP");
        request.putQueryParameter("TemplateCode", "SMS_174993650");

        request.putQueryParameter("TemplateParam", "{code:" + code + "}");
        CommonResponse response = client.getCommonResponse(request);
        System.out.println(response.getData());

        if (response.getData().contains("OK")){
            return true;
        }
        return false;
    }




}