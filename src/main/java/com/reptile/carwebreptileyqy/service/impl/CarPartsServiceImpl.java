package com.reptile.carwebreptileyqy.service.impl;

import com.reptile.carwebreptileyqy.dto.CarPartsDTO;
import com.reptile.carwebreptileyqy.entity.AutoPartsInfoEntity;
import com.reptile.carwebreptileyqy.entity.CarPartsEntity;
import com.reptile.carwebreptileyqy.exception.ServiceException;
import com.reptile.carwebreptileyqy.mapper.CarPartsMapper;
import com.reptile.carwebreptileyqy.service.CarPartsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CarPartsServiceImpl implements CarPartsService {

    private static final String SUFFIX_2003 = ".xls";
    private static final String SUFFIX_2007 = ".xlsx";

    @Resource
    CarPartsMapper carPartsMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String upload(MultipartFile file) {
        //获取文件的名字
        String originalFilename = file.getOriginalFilename();
        Workbook workbook = null;
        try {
            if (originalFilename.endsWith(SUFFIX_2003)) {
                workbook = new HSSFWorkbook(file.getInputStream());
            } else if (originalFilename.endsWith(SUFFIX_2007)) {
                workbook = new XSSFWorkbook(file.getInputStream());
            }
        } catch (Exception e) {
            log.info(originalFilename);
            e.printStackTrace();
        }
        if (workbook == null) {
            log.info(originalFilename);
            //throw new BusinessException(ReturnCode.CODE_FAIL, "格式错误");
        } else {
            //获取所有的工作表的的数量
            int numOfSheet = workbook.getNumberOfSheets();
            //遍历这个这些表
            for (int i = 0; i < numOfSheet; i++) {
                //获取一个sheet也就是一个工作簿
                Sheet sheet = workbook.getSheetAt(i);
                String sheetName = sheet.getSheetName();
                int lastRowNum = sheet.getLastRowNum();
                //从第一行开始第一行一般是标题
                for (int j = 1; j <= lastRowNum; j++) {
                    Row row = sheet.getRow(j);
                    CarPartsEntity carPartsEntity = new CarPartsEntity();

                    if (row.getCell(0) != null) {
                        row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                        String from = row.getCell(0).getStringCellValue();
                        carPartsEntity.setFromTime(from);
                    }

                    if (row.getCell(1) != null&&!row.getCell(1).toString().equals("")) {
                        System.out.println("sheetName:"+sheetName+"j:"+j);
                        row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                        String to = row.getCell(1).getStringCellValue();
                        carPartsEntity.setToTime(to);
                    }

                    if (row.getCell(2) != null) {
                        row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                        String partsNo = row.getCell(2).getStringCellValue();
                        carPartsEntity.setPartsNo(partsNo);
                    }

                    if (row.getCell(3) != null) {
                        row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                        String partsName = row.getCell(3).getStringCellValue();
                        carPartsEntity.setPartsName(partsName);
                    }

                    if (row.getCell(4) != null) {
                        row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                        String instruction = row.getCell(4).getStringCellValue();
                        carPartsEntity.setInstruction(instruction);
                    }

                    if (row.getCell(5) != null) {
                        row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                        String groupNo = row.getCell(5).getStringCellValue();
                        carPartsEntity.setGroupNo(groupNo);
                    }

                    if (row.getCell(6) != null) {
                        row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
                        String pnc = row.getCell(6).getStringCellValue();
                        carPartsEntity.setPnc(pnc);
                    }
                    carPartsEntity.setCreateTime(new Date());
                    carPartsMapper.insertCarParts(carPartsEntity);
                }
            }
        }
        return "上传成功";
    }

    @Override
    public List<CarPartsEntity> list(CarPartsDTO carPartsDTO) {
        return carPartsMapper.list(carPartsDTO);
    }

    @Override
    public int total(CarPartsDTO carPartsDTO) {
        return carPartsMapper.total(carPartsDTO);
    }

    @Override
    public List<CarPartsEntity> queryCarPartsByDetailId(CarPartsDTO carPartsDTO) {
        return carPartsMapper.queryCarPartsByDetailId(carPartsDTO);
    }

    @Override
    public int totalQueryCarPartsByDetailId(CarPartsDTO carPartsDTO) {
        return carPartsMapper.totalQueryCarPartsByDetailId(carPartsDTO);
    }

    @Override
    public String importAutoPartsInfo(MultipartFile file) {
        //获取文件的名字
        String originalFilename = file.getOriginalFilename();
        Workbook workbook = null;
        try {
            if (originalFilename.endsWith(SUFFIX_2003)) {
                workbook = new HSSFWorkbook(file.getInputStream());
            } else if (originalFilename.endsWith(SUFFIX_2007)) {
                workbook = new XSSFWorkbook(file.getInputStream());
            }
        } catch (Exception e) {
            log.info(originalFilename);
            e.printStackTrace();
        }
        if (workbook == null) {
            log.info(originalFilename);
            throw new ServiceException("202", "格式错误");
        } else {
            //获取所有的工作表的的数量
            int numOfSheet = workbook.getNumberOfSheets();
            //遍历这个这些表
            for (int i = 0; i < 1; i++) {
                //获取一个sheet也就是一个工作簿
                Sheet sheet = workbook.getSheetAt(i);
                String sheetName = sheet.getSheetName();
                int lastRowNum = sheet.getLastRowNum();
                //从第二行开始第一行一般是标题
                for (int j = 1; j <= lastRowNum; j++) {
                    Row row = sheet.getRow(j);
                    AutoPartsInfoEntity autoPartsInfoEntity = new AutoPartsInfoEntity();

                    if (!StringUtils.isEmpty(row.getCell(0))) {
                        row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                        String productNumber = row.getCell(0).getStringCellValue().trim();
                        autoPartsInfoEntity.setProductNumber(productNumber);
                    }

                    if (!StringUtils.isEmpty(row.getCell(1))) {
                        System.out.println("sheetName:"+sheetName+"j:"+j);
                        row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                        String productName = row.getCell(1).getStringCellValue().trim();
                        autoPartsInfoEntity.setProductName(productName);
                    }

                    if (!StringUtils.isEmpty(row.getCell(2))) {
                        row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                        String vehicleModel = row.getCell(2).getStringCellValue().trim();
                        autoPartsInfoEntity.setVehicleModel(vehicleModel);
                    }

                    if (!StringUtils.isEmpty(row.getCell(3))) {
                        row.getCell(3).setCellType(Cell.CELL_TYPE_NUMERIC);
                        BigDecimal wholesalePrize = new BigDecimal(row.getCell(3).getNumericCellValue());
                        autoPartsInfoEntity.setWholesalePrize(wholesalePrize);
                    }

                    if (!StringUtils.isEmpty(row.getCell(4))) {
                        row.getCell(4).setCellType(Cell.CELL_TYPE_NUMERIC);
                        BigDecimal retailPrice = new BigDecimal(row.getCell(4).getNumericCellValue());
                        autoPartsInfoEntity.setRetailPrice(retailPrice);
                    }

                    if (!StringUtils.isEmpty(row.getCell(5))) {
                        row.getCell(5).setCellType(Cell.CELL_TYPE_NUMERIC);
                        BigDecimal discountPrize = new BigDecimal(row.getCell(5).getNumericCellValue());
                        autoPartsInfoEntity.setDiscountPrize(discountPrize);
                    }

                    if (!StringUtils.isEmpty(row.getCell(6))) {
                        row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
                        String factoryNumber = row.getCell(6).getStringCellValue().trim();
                        autoPartsInfoEntity.setFactoryNumber(factoryNumber);
                    }

                    if (!StringUtils.isEmpty(row.getCell(7))) {
                        row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
                        String specification = row.getCell(7).getStringCellValue().trim();
                        autoPartsInfoEntity.setSpecification(specification);
                    }
                    carPartsMapper.insertAutoPartsInfo(autoPartsInfoEntity);
                }
            }
        }
        return "上传成功";
    }

    @Override
    public String updateAutoPartsInfo(MultipartFile file) {
        //获取文件的名字
        String originalFilename = file.getOriginalFilename();
        Workbook workbook = null;
        try {
            if (originalFilename.endsWith(SUFFIX_2003)) {
                workbook = new HSSFWorkbook(file.getInputStream());
            } else if (originalFilename.endsWith(SUFFIX_2007)) {
                workbook = new XSSFWorkbook(file.getInputStream());
            }
        } catch (Exception e) {
            log.info(originalFilename);
            e.printStackTrace();
        }
        if (workbook == null) {
            log.info(originalFilename);
            throw new ServiceException("202", "格式错误");
        } else {
            //获取所有的工作表的的数量
            int numOfSheet = workbook.getNumberOfSheets();
            //遍历这个这些表
            for (int i = 0; i < 1; i++) {
                //获取一个sheet也就是一个工作簿
                Sheet sheet = workbook.getSheetAt(i);
                String sheetName = sheet.getSheetName();
                int lastRowNum = sheet.getLastRowNum();
                //从第二行开始第一行一般是标题
                for (int j = 1; j <= lastRowNum; j++) {
                    Row row = sheet.getRow(j);
                    String productNumber = "";
                    String productName = "";
                    BigDecimal retailPrice = new BigDecimal(0);
                    if (!StringUtils.isEmpty(row.getCell(0))) {
                        row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                        productNumber = row.getCell(0).getStringCellValue().trim();
                    }

                    if (!StringUtils.isEmpty(row.getCell(1))) {
                        System.out.println("sheetName:"+sheetName+"j:"+j);
                        row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                        productName = row.getCell(1).getStringCellValue().trim();

                    }
                    if (!StringUtils.isEmpty(row.getCell(2))) {
                        row.getCell(2).setCellType(Cell.CELL_TYPE_NUMERIC);
                        retailPrice = new BigDecimal(row.getCell(2).getNumericCellValue());
                    }
                    //查询数据库中是否存在配件
                    AutoPartsInfoEntity autoPartsInfoEntity =  carPartsMapper.selectPatsByProductNo(productNumber);
                    if(autoPartsInfoEntity!=null){
                        AutoPartsInfoEntity updatePartsEntity = new AutoPartsInfoEntity();
                        updatePartsEntity.setId(autoPartsInfoEntity.getId());
                        updatePartsEntity.setRetailPrice(retailPrice);
                        carPartsMapper.updateAutoPartsInfo(updatePartsEntity);
                    }else{
                        AutoPartsInfoEntity insertPartsEntity = new AutoPartsInfoEntity();
                        insertPartsEntity.setProductNumber(productNumber);
                        insertPartsEntity.setProductName(productName);
                        insertPartsEntity.setRetailPrice(retailPrice);
                        carPartsMapper.insertAutoPartsInfo(insertPartsEntity);
                    }
                }
            }
        }
        return "上传成功";
    }
}
