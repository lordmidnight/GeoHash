package com.mid.geohash.service;

import java.util.Map;

/**
 * @author Ivan.Guo
 * @version 11.0
 * Created by Ivan.Guo on 2024/1/2
 */
public interface GeoHashService {
    String geoToHash(double latitude, double longitude, int precision);

    Map<String, Double> hashToGeo(String geoHash);
}
