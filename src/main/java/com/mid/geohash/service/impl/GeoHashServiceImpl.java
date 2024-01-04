package com.mid.geohash.service.impl;

import ch.hsr.geohash.GeoHash;
import ch.hsr.geohash.WGS84Point;
import com.mid.geohash.service.GeoHashService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivan.Guo
 * @version 11.0
 * Created by Ivan.Guo on 2024/1/2
 */
@Service
class GeoHashServiceImpl implements GeoHashService {

    @Override
    public String geoToHash(double latitude, double longitude, int precision) {
        GeoHash geoHash = GeoHash.withCharacterPrecision(latitude, longitude, precision);
        return geoHash.toBase32();
    }

    @Override
    public Map<String, Double> hashToGeo(String geoHash) {
        GeoHash geoHashObj = GeoHash.fromGeohashString(geoHash);
        WGS84Point originatingPoint = geoHashObj.getOriginatingPoint();
        Map<String, Double> result = new HashMap<>();
        result.put("latitude", originatingPoint.getLatitude());
        result.put("longitude", originatingPoint.getLongitude());
        return result;
    }
}
