package com.reptile.carwebreptileyqy.controller;

import com.reptile.carwebreptileyqy.dto.CarPartsDTO;
import com.reptile.carwebreptileyqy.entity.CarPartsEntity;
import com.reptile.carwebreptileyqy.service.CarPartsService;
import com.reptile.carwebreptileyqy.util.BaseResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CarPartsController {

    @Resource
    CarPartsService carPartsService;

    /**
     * excel数据导入
     * @param file
     * @return
     */
    @PostMapping(value = "/carParts/upload")
    @ResponseBody
    public String uploadExcel(@RequestParam("file") MultipartFile file) {
        try {
            Object result = carPartsService.upload(file);
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败!";
        }
        return "上传成功!";
    }

    @PostMapping(value = "/carParts/list",produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    @Consumes(MediaType.APPLICATION_JSON)
    public BaseResponse listAll(
            @RequestBody CarPartsDTO carPartsDTO){
        BaseResponse baseResponse = new BaseResponse();
        Map map = new LinkedHashMap();
        List<CarPartsEntity> list = carPartsService.list(carPartsDTO);
        int total = carPartsService.total(carPartsDTO);
        map.put("total",total);
        map.put("currentPage",carPartsDTO.getCurrentPage());
        map.put("carPartsList",list);
        baseResponse.setData(map);
        return baseResponse;
    }

    @PostMapping(value = "/carParts/queryCarPartsByDetailId",produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    @Consumes(MediaType.APPLICATION_JSON)
    public BaseResponse queryCarPartsByDetailId(
            @RequestBody CarPartsDTO carPartsDTO){
        BaseResponse baseResponse = new BaseResponse();
        Map map = new LinkedHashMap();
        List<CarPartsEntity> list = carPartsService.queryCarPartsByDetailId(carPartsDTO);
        int total = carPartsService.totalQueryCarPartsByDetailId(carPartsDTO);
        map.put("total",total);
        map.put("currentPage",carPartsDTO.getCurrentPage());
        map.put("carPartsByDetailIdList",list);
        baseResponse.setData(map);
        return baseResponse;
    }

    @PostMapping(value = "/carParts/importAutoPartsInfo")
    @ResponseBody
    public String importAutoPartsInfo(@RequestParam("file") MultipartFile file) {
        try {
            Object result = carPartsService.importAutoPartsInfo(file);
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败!";
        }
        return "上传成功!";
    }

    @PostMapping(value = "/carParts/updateAutoPartsInfo")
    @ResponseBody
    public String updateAutoPartsInfo(@RequestParam("file") MultipartFile file) {
        try {
            Object result = carPartsService.updateAutoPartsInfo(file);
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败!";
        }
        return "上传成功!";
    }
}
