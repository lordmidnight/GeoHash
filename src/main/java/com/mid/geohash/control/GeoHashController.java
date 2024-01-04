package com.mid.geohash.control;

import com.mid.geohash.model.ResultResponse;
import com.mid.geohash.service.GeoHashService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ivan.Guo
 * @version 11.0
 * Created by Ivan.Guo on 2024/1/2
 */
@RestController
@RequestMapping("/{version}/geo")
public class GeoHashController {

    @Resource
    GeoHashService geoHashService;

    @GetMapping("/geoToHash")
    public ResultResponse geoToHash(HttpServletRequest request, HttpServletResponse response, @PathVariable String version, @RequestParam Double latitude, @RequestParam Double longitude, @RequestParam Integer precision) {
        return ResultResponse.success(geoHashService.geoToHash(latitude, longitude, precision));
    }

    @GetMapping("/hashToGeo")
    public ResultResponse hashToGeo(HttpServletRequest request, HttpServletResponse response, @PathVariable String version, @RequestParam String geoHash) {
        return ResultResponse.success(geoHashService.hashToGeo(geoHash));
    }
}
