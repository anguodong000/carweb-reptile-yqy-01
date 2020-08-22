package com.reptile.carwebreptileyqy.service;

import com.reptile.carwebreptileyqy.dto.CarPartsDTO;
import com.reptile.carwebreptileyqy.entity.CarPartsEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CarPartsService {
    String upload(MultipartFile file);

    String importAutoPartsInfo(MultipartFile file);

    String updateAutoPartsInfo(MultipartFile file);

    List<CarPartsEntity> list(CarPartsDTO carPartsDTO);

    int total(CarPartsDTO carPartsDTO);

    List<CarPartsEntity> queryCarPartsByDetailId(CarPartsDTO carPartsDTO);

    int totalQueryCarPartsByDetailId(CarPartsDTO carPartsDTO);
}
