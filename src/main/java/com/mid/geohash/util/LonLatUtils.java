package com.mid.geohash.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * @author Ivan.Guo
 * @version 11.0
 * Created by Ivan.Guo on 2024/1/2
 */
public class LonLatUtils {
    /**
     * @param MinLon 最小经度
     * @param MaxLon 最大经度
     * @param MinLat 最小纬度
     * @param MaxLat 最大纬度
     * @return
     * @throws
     * @Title: randomLonLat
     * @Description: 在矩形内随机生成经纬度
     */
    public static String randomLonLat(double MinLon, double MaxLon, double MinLat, double MaxLat) {
        Random random = new Random();
        BigDecimal db = new BigDecimal(Math.random() * (MaxLon - MinLon) + MinLon);
        String lon = db.setScale(6, RoundingMode.HALF_UP).toString();// 小数后6位
        db = new BigDecimal(Math.random() * (MaxLat - MinLat) + MinLat);
        String lat = db.setScale(6, RoundingMode.HALF_UP).toString();
        return lon + "," + lat;
    }

}
