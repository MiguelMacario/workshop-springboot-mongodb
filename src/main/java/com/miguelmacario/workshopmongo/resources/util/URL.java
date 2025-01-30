package com.miguelmacario.workshopmongo.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URL {

    public static String decodeParam(String str) {
        return URLDecoder.decode(str, StandardCharsets.UTF_8);
    }

}
