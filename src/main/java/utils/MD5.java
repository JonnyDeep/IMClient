package utils;

import java.security.MessageDigest;

public class MD5 {
    public static String md5(String text) throws Exception
    {
        MessageDigest digest = MessageDigest.getInstance("md5");
        byte[] result = digest.digest(text.getBytes());
        StringBuffer buffer = new StringBuffer();
        for(byte b:result)
        {
            int number = b & 0xff;
            String str = Integer.toHexString(number);
            if(str.length()==1){
                buffer.append("0");
            }
            buffer.append(str);
        }

        return buffer.toString();
    }

}
