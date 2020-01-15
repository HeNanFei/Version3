package com.zjt.manager.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Bcry {

    public static String bcry(String strings){

        String hashpw = BCrypt.hashpw(strings, BCrypt.gensalt());


        return hashpw;

    }

}
