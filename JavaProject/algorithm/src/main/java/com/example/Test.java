package com.example;

/**
 * Created by tongzhichao on 17-7-7.
 */

public class Test {
    public static void main(String[] args) {
        String s = "43000000000055f9000803018604840000010001010000000000003200000000000000000008bf010100000e2300007093204e204e000005001a9a48990000af00c8000100005801000000013203000042000000000055f9000803018604840000010001";
        parseDataInfo(s);
    }

    private static void parseDataInfo(String s) {
        String id = s.substring(0, 2); //0x42
        String strGearLevel = s.substring(2, 4);//档位
        String strSoc = s.substring(152, 156); //电池电量百分比
        String strDriveMode = s.substring(80, 82);//驾驶模式
        String error = s.substring(82, 84); //错误信息
        String strRecycleMode = s.substring(78, 80);//回收模式
        String strSpeed = s.substring(122, 126);//车速
        String strMileage = s.substring(126, 130); //剩余里程
        String strConsumption = s.substring(130, 134); //总里程平均能耗
        String strCurrentMileage = s.substring(134, 140);//当前里程
        String strOdo = s.substring(140, 146); //总里程
        ;
        byte soc = (byte) (Math.round(Integer.parseInt(parseData(strSoc), 16) * 0.1));
        System.out.println(strSoc + ":" + soc);
    }

    private static String parseData(String original) {
        String result = original;
        String byte1;
        String byte2;
        String byte3;
        if (original.length() == 4) {
            original = original + "";
            byte1 = original.substring(0, 2);
            byte2 = original.substring(2, 4);
            result = byte2 + byte1;
        } else if (original.length() == 6) {
            original = original + "";
            byte1 = original.substring(0, 2);
            byte2 = original.substring(2, 4);
            byte3 = original.substring(4, 6);
            result = byte3 + byte2 + byte1;
        }
        return result;
    }
}
