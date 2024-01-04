package com.mid.geohash;

import ch.hsr.geohash.GeoHash;
import ch.hsr.geohash.WGS84Point;
import com.mid.geohash.util.LonLatUtils;
import org.junit.jupiter.api.Test;

public class GeoHashTests {

    /* 经纬度转hash值 */
    @Test
    public void geoToHash() {
        GeoHash geoHash = GeoHash.withCharacterPrecision(30.192973405423004, 101.88529159607815, 10);
        // System.out.println(geoHash.toBinaryString());
        System.out.println(geoHash.toBase32());
    }

    /* hash值转经纬度 */
    @Test
    public void hashToGeo() {
        GeoHash wm27y2qwg6 = GeoHash.fromGeohashString("wm27y2qwg6");
        WGS84Point originatingPoint = wm27y2qwg6.getOriginatingPoint();
        System.out.println(originatingPoint.getLongitude());
        System.out.println(originatingPoint.getLatitude());
    }

    @Test
    public void randomLonLat() {
        for (int i = 0; i < 100; i++) {
            System.out.println(LonLatUtils.randomLonLat(100.0, 180.0, 20.0, 50.0));
        }
    }

}
