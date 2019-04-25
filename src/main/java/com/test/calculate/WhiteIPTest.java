package com.test.calculate;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WhiteIPTest {

    private static List<String> list = new CopyOnWriteArrayList();

    public static boolean addWhiteIpAdress(String ip) {
        String[] split = ip.split("/");
        long ipNum = ipSringToLong(split[0]);

        String ipInfo = ipNum + "/" + split[1];
        return list.add(ipInfo);
    }

    private static long ipSringToLong(String s) {
        long[] ipArray = new long[4];
        int position1 = s.indexOf(".");
        int position2 = s.indexOf(".", position1 + 1);
        int position3 = s.indexOf(".", position2 + 1);
        ipArray[0] = Long.parseLong(s.substring(0, position1));
        ipArray[1] = Long.parseLong(s.substring(position1 + 1, position2));
        ipArray[2] = Long.parseLong(s.substring(position2 + 1, position3));
        ipArray[3] = Long.parseLong(s.substring(position3 + 1));
        return (ipArray[0] << 24) + (ipArray[1] << 16) + (ipArray[2] << 8) + ipArray[3];
    }

    public static boolean isWhiteIpAdress(String ip) {
        for (String s : list) {
            if(isWhiteIpAdress(ip, s)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isWhiteIpAdress(String ip, String s) {
        long ipNum = ipSringToLong(ip);
        String[] split = s.split("/");
        Long ips = Long.valueOf(split[0]);
        Long nets = Long.valueOf(split[1]);
        long l = (ipNum ^ ips) >> (32 - nets);
        return l == 0;
    }

    public static void main(String[] args) {
        addWhiteIpAdress("192.158.3.0/22");
        boolean whiteIpAdress = isWhiteIpAdress("192.158.1.254");
        System.out.println(whiteIpAdress);
    }
}
