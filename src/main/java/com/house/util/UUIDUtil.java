package com.house.util;

import java.util.UUID;

/**
 * @author wenfeng zhang @ 14/12/19
 */
public class UUIDUtil {

    public static String generateUniqueKey(){
        return UUID.randomUUID().toString().replace("-", "");
    }

}
