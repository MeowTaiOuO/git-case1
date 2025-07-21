package org.jaz.james.tutorial;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jaz.common.CoffeeBeanMenuGenerator;
import org.jaz.common.ExcelDataImporter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class CoffeeBean {
    public CoffeeBean(){
    }

    private int id; //編號
    private int year;   //年份
    private String batch;   //批次
    private String grade;   //等級
    private Integer density;    //密度
    private Double waterContent;    //含水率
    private Double waterActivity;   //水活性
    private String country; //國家
    private String processMethod;   //處理方法
    private String region;  //產區
    private String processingPlant;     //處理廠
    private String beanType;    //豆種
    private String beanMerchant;    //豆商
    private Integer cost;   //成本
    private Integer retailPrice;    //零售
    private Integer stockGrams;    //存量g
    private String flavorDesc;      //風味描述
    private String code;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year=year;
    }
    public String getBatch() {
        return batch;
    }
    public void setBatch(String batch) {
        this.batch = batch;
    }
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getDensity() {
        return density;
    }

    public void setDensity(Integer density) {
        this.density = density;
    }

    public Double getWaterContent() {
        return waterContent;
    }

    public void setWaterContent(Double waterContent) {
        this.waterContent = waterContent;
    }

    public Double getWaterActivity() {
        return waterActivity;
    }

    public void setWaterActivity(Double waterActivity) {
        this.waterActivity = waterActivity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProcessMethod() {
        return processMethod;
    }

    public void setProcessMethod(String processMethod) {
        this.processMethod = processMethod;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProcessingPlant() {
        return processingPlant;
    }

    public void setProcessingPlant(String processingPlant) {
        this.processingPlant = processingPlant;
    }

    public String getBeanType() {
        return beanType;
    }

    public void setBeanType(String beanType) {
        this.beanType = beanType;
    }

    public String getBeanMerchant() {
        return beanMerchant;
    }

    public void setBeanMerchant(String beanMerchant) {
        this.beanMerchant = beanMerchant;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Integer retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Integer getStockGrams() {
        return stockGrams;
    }

    public void setStockGrams(Integer stockGrams) {
        this.stockGrams = stockGrams;
    }

    public String getFlavorDesc() {
        return flavorDesc;
    }

    public void setFlavorDesc(String flavorDesc) {
        this.flavorDesc = flavorDesc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public static void main(String[] args) {
        String filePath = "resources/roast.xlsx"; // Excel 路徑
        String outputPath = "resources/beanMenu.xlsx"; // Excel output 路徑
        String sheetName = "yyyy-MM";
        CoffeeBeanMenuGenerator menuGenerator = new CoffeeBeanMenuGenerator();

        List<CoffeeBean> beanList = null;
        Integer ZERO = Integer.valueOf(0);
        try {
            beanList = ExcelDataImporter.loadCoffeeBeansFromExcel(filePath);

            //取出存量大於0的資料

            List<CoffeeBean> canBeSellBeans = beanList.stream().filter(bean -> bean.getStockGrams().compareTo(ZERO) > 0).toList();

            //排序

            //呼叫 CoffeeBeanMenuGenerator
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(sheetName);
            Row row = sheet.createRow(2);

            menuGenerator.generateTitle(row);  //產生 title

            menuGenerator.generateBeanColumnHeader(sheet.createRow(3));  //產生 column header

            for (int i = 1; i < canBeSellBeans.size(); i++) {
                menuGenerator.generateRow(sheet.createRow(i + 3), canBeSellBeans.get(i));
                System.out.println("編號:" + canBeSellBeans.get(i).getId() + ",存量:" +canBeSellBeans.get(i).getStockGrams());  //印出來看看
            }

            //關檔
            try (OutputStream fileOut = new FileOutputStream(outputPath)) {
                workbook.write(fileOut);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}





