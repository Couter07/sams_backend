package org.server.sams.utils;

public class UIDGenerated {
    public static String generate(Integer id) {
        String strUID = id.toString();
        int zeroCount = 4 - strUID.length();
        return "0".repeat(zeroCount) + strUID;
    }
}
