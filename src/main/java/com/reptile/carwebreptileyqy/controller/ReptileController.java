package com.reptile.carwebreptileyqy.controller;

import com.reptile.carwebreptileyqy.service.ReptileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author angd
 * @create 2019-08-21 17:54
 */
@Controller
public class ReptileController {

    @Autowired
    ReptileService reptileService;

    @RequestMapping("/main")
    public String reptileStart(ModelMap modelMap) {
        modelMap.put("list","大家好");
        return "reptileMain";
    }

    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
        modelMap.put("list","大家好");
        return "index";
    }

    @RequestMapping("/index1")
    public String index1(ModelMap modelMap) {
        modelMap.put("list","大家好");
        return "index1";
    }

    @RequestMapping("/carParts/listHtml")
    public String carPartsListHtml(ModelMap modelMap) {
        modelMap.put("list","大家好");
        return "carparts/list";
    }

    @RequestMapping("/carParts/importCarPartsHtml")
    public String importCarPartsHtml() {
        return "carparts/import_carparts";
    }

    @RequestMapping("/role")
    public String role(ModelMap modelMap) {
        return "role";
    }

    @RequestMapping("/user")
    public String user(ModelMap modelMap) {
        return "user";
    }

    @RequestMapping("/tabSwiper")
    public String tabSwiper(ModelMap modelMap) {
        return "tabSwiper";
    }

    @PostMapping(value = "/upload")
    @ResponseBody
    public String uploadExcel(@RequestParam("file") MultipartFile file) {
        Object result;
        try {
            result = reptileService.resolveExcel(file);
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败!";
        }
        return "上传成功!";
    }

    @PostMapping(value = "/uploadBddeh")
    @ResponseBody
    public String uploadBddeh(@RequestParam("file") MultipartFile file) {
        Object result;
        try {
            result = reptileService.resolveBddehExcel(file);
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败!";
        }
        return "上传成功!";
    }

    @PostMapping(value = "/grasp")
    @ResponseBody
    public String graspData() {
        try{
           /*new Thread("线程一") {
                @Override
                public void run() {
                    reptileService.graspData1();
                }
            }.start();

            new Thread("线程二") {
                @Override
                public void run() {
                    reptileService.graspData2();
                }
            }.start();

            new Thread("线程三") {
                @Override
                public void run() {
                    reptileService.graspData3();
                }
            }.start();

            new Thread("线程四") {
                @Override
                public void run() {
                    reptileService.graspData4();
                }
            }.start();

            new Thread("线程五") {
                @Override
                public void run() {
                    reptileService.graspData5();
                }
            }.start();

            new Thread("线程六") {
                @Override
                public void run() {
                    reptileService.graspData6();
                }
            }.start();

            new Thread("线程七") {
                @Override
                public void run() {
                    reptileService.graspData7();
                }
            }.start();

            new Thread("线程八") {
                @Override
                public void run() {
                    reptileService.graspData8();
                }
            }.start();

            new Thread("线程九") {
                @Override
                public void run() {
                    reptileService.graspData9();
                }
            }.start();*/
            reptileService.graspData();
        }catch (Exception e){
            return "抓取失败!";
        }
        return "抓取成功！";
    }

    @PostMapping(value = "/exportExcel1")
    @ResponseBody
    public String exportExcel1(HttpServletResponse response) {
        try{
            reptileService.exportExcel1(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel2")
    @ResponseBody
    public String exportExcel2(HttpServletResponse response) {
        try{
            reptileService.exportExcel2(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel3")
    @ResponseBody
    public String exportExcel3(HttpServletResponse response) {
        try{
            reptileService.exportExcel3(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel4")
    @ResponseBody
    public String exportExcel4(HttpServletResponse response) {
        try{
            reptileService.exportExcel4(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel5")
    @ResponseBody
    public String exportExcel5(HttpServletResponse response) {
        try{
            reptileService.exportExcel5(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel6")
    @ResponseBody
    public String exportExcel6(HttpServletResponse response) {
        try{
            reptileService.exportExcel6(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel7")
    @ResponseBody
    public String exportExcel7(HttpServletResponse response) {
        try{
            reptileService.exportExcel7(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel8")
    @ResponseBody
    public String exportExcel8(HttpServletResponse response) {
        try{
            reptileService.exportExcel8(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel9")
    @ResponseBody
    public String exportExcel9(HttpServletResponse response) {
        try{
            reptileService.exportExcel9(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel10")
    @ResponseBody
    public String exportExcel10(HttpServletResponse response) {
        try{
            reptileService.exportExcel10(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel11")
    @ResponseBody
    public String exportExcel11(HttpServletResponse response) {
        try{
            reptileService.exportExcel11(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel12")
    @ResponseBody
    public String exportExcel12(HttpServletResponse response) {
        try{
            reptileService.exportExcel12(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel13")
    @ResponseBody
    public String exportExcel13(HttpServletResponse response) {
        try{
            reptileService.exportExcel13(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel14")
    @ResponseBody
    public String exportExcel14(HttpServletResponse response) {
        try{
            reptileService.exportExcel14(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel15")
    @ResponseBody
    public String exportExcel15(HttpServletResponse response) {
        try{
            reptileService.exportExcel15(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel16")
    @ResponseBody
    public String exportExcel16(HttpServletResponse response) {
        try{
            reptileService.exportExcel16(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel17")
    @ResponseBody
    public String exportExcel17(HttpServletResponse response) {
        try{
            reptileService.exportExcel17(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel18")
    @ResponseBody
    public String exportExcel18(HttpServletResponse response) {
        try{
            reptileService.exportExcel18(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel19")
    @ResponseBody
    public String exportExcel19(HttpServletResponse response) {
        try{
            reptileService.exportExcel19(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel20")
    @ResponseBody
    public String exportExcel20(HttpServletResponse response) {
        try{
            reptileService.exportExcel20(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel21")
    @ResponseBody
    public String exportExcel21(HttpServletResponse response) {
        try{
            reptileService.exportExcel21(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel22")
    @ResponseBody
    public String exportExcel22(HttpServletResponse response) {
        try{
            reptileService.exportExcel22(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel23")
    @ResponseBody
    public String exportExcel23(HttpServletResponse response) {
        try{
            reptileService.exportExcel23(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel24")
    @ResponseBody
    public String exportExcel24(HttpServletResponse response) {
        try{
            reptileService.exportExcel24(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel25")
    @ResponseBody
    public String exportExcel25(HttpServletResponse response) {
        try{
            reptileService.exportExcel25(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel26")
    @ResponseBody
    public String exportExcel26(HttpServletResponse response) {
        try{
            reptileService.exportExcel26(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel27")
    @ResponseBody
    public String exportExcel27(HttpServletResponse response) {
        try{
            reptileService.exportExcel27(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel28")
    @ResponseBody
    public String exportExcel28(HttpServletResponse response) {
        try{
            reptileService.exportExcel28(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel29")
    @ResponseBody
    public String exportExcel29(HttpServletResponse response) {
        try{
            reptileService.exportExcel29(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel30")
    @ResponseBody
    public String exportExcel30(HttpServletResponse response) {
        try{
            reptileService.exportExcel30(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel31")
    @ResponseBody
    public String exportExcel31(HttpServletResponse response) {
        try{
            reptileService.exportExcel31(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel32")
    @ResponseBody
    public String exportExcel32(HttpServletResponse response) {
        try{
            reptileService.exportExcel32(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel33")
    @ResponseBody
    public String exportExcel33(HttpServletResponse response) {
        try{
            reptileService.exportExcel33(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel34")
    @ResponseBody
    public String exportExcel34(HttpServletResponse response) {
        try{
            reptileService.exportExcel34(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel35")
    @ResponseBody
    public String exportExcel35(HttpServletResponse response) {
        try{
            reptileService.exportExcel35(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel36")
    @ResponseBody
    public String exportExcel36(HttpServletResponse response) {
        try{
            reptileService.exportExcel36(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel37")
    @ResponseBody
    public String exportExcel37(HttpServletResponse response) {
        try{
            reptileService.exportExcel37(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel38")
    @ResponseBody
    public String exportExcel38(HttpServletResponse response) {
        try{
            reptileService.exportExcel38(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

    @PostMapping(value = "/exportExcel39")
    @ResponseBody
    public String exportExcel39(HttpServletResponse response) {
        try{
            reptileService.exportExcel39(response);
        }catch (Exception e){
            return "导出失败!";
        }
        return "导出成功！";
    }

}
