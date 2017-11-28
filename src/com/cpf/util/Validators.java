package com.cpf.util;

/**
 * Created by Administrator on 2017-11-03.
 */
public class Validators {
    /**
     * 校验字符串是否为数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

}
