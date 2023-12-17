package utils;

import java.util.Random;

public class RandomUtils {
    Random random = new Random();

    public String createString (int length) {
        String res = "";
        String characters = "abcdefghijklmnopqrstuvwxyz";
        int index = 0;
        int strLength = characters.length();
        for(int i = 0; i<length; i++) {
            index = random.nextInt(strLength);
            res = res + characters.charAt(index);
        }
        return res;
    }
}