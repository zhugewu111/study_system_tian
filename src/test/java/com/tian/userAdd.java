package com.tian;

import com.tian.pojo.User;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class userAdd {

    public User add() {
        User user = new User();
        String name = getStringRandom(8);
        user.setUsername(name);
        user.setPassword(getStringRandom(6));
        user.setEmail(name + "@qq.com");
        user.setSex((Math.random()*2)+1 >= 1 ? "男" : "女");
        user.setPhone("1" +  (int)((Math.random()*5)+4) + (int)(Math.random()*10) + (int) (Math.random() * 100000000));
        user.setAge((int) (Math.random() * 12)+18);
        return user;
    }

    @Test
    public void addUser() {
        for (int i = 0; i < 100; i++) {
//            UserMapper.addUser(add());
        }
    }
    //自动生成名字(中文)
//    public static String getRandomJianHan(int len) {
//        String ret = "";
//        for (int i = 0; i < len; i++) {
//            String str = null;
//            int hightPos, lowPos; // 定义高低位
//            Random random = new Random();
//            hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
//            lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
//            byte[] b = new byte[2];
//            b[0] = (new Integer(hightPos).byteValue());
//            b[1] = (new Integer(lowPos).byteValue());
//            try {
//                str = new String(b, "GBK"); // 转成中文
//            } catch (UnsupportedEncodingException ex) {
//                ex.printStackTrace();
//            }
//            ret += str;
//        }
//        return ret;
//    }

    //生成随机用户名，数字和字母组成,
    public String getStringRandom(int length) {

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
}
