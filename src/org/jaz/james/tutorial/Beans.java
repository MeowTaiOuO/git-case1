package org.jaz.james.tutorial;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Beans {
    public Beans(){
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

        List<Beans> beanList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("beans");
            if (sheet == null) {
                System.out.println("找不到名為 beans 的工作表");
                return;
            }

            int firstRowNum = sheet.getFirstRowNum();
            int lastRowNum = sheet.getLastRowNum();


            for (int i = firstRowNum + 1; i <= lastRowNum; i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Beans b = new Beans();

                b.setId((int) getNumericCell(row, 0));
                b.setYear((int) getNumericCell(row, 1));
                b.setBatch(getStringCell(row, 2));
                b.setGrade(getStringCell(row, 3));
                b.setDensity((int) getNumericCell(row, 4));
                b.setWaterContent(getNumericCell(row, 5));
                b.setWaterActivity(getNumericCell(row, 6));
                b.setCountry(getStringCell(row, 7));
                b.setProcessMethod(getStringCell(row, 8));
                b.setRegion(getStringCell(row, 9));
                b.setProcessingPlant(getStringCell(row, 10));
                b.setBeanType(getStringCell(row, 11));
                b.setBeanMerchant(getStringCell(row, 12));
                b.setCost((int) getNumericCell(row, 13));
                b.setRetailPrice((int) getNumericCell(row, 14));
                b.setStockGrams((int) getNumericCell(row, 15));
                b.setFlavorDesc(getStringCell(row, 16));
                b.setCode(getStringCell(row, 17));

                beanList.add(b);
            }


            for (Beans b : beanList) {
                System.out.println(
                        "編號: " + b.getId() +
                                ", 年份: " + b.getYear() +
                                ", 批次: " + b.getBatch() +
                                ", 等級: " + b.getGrade() +
                                ", 密度: " + b.getDensity() +
                                ", 含水率: " + b.getWaterContent()+
                                ", 水活性: " + b.getWaterActivity() +
                                ", 國家: " + b.getCountry() +
                                ", 處理法: " + b.getProcessMethod() +
                                ", 產區: " + b.getRegion() +
                                ", 處理廠: " + b.getProcessingPlant() +
                                ", 豆種: " + b.getBeanType() +
                                ", 豆商: " + b.getBeanMerchant() +
                                ", 成本: " + b.getCost() +
                                ", 零售: " + b.getRetailPrice() +
                                ", 存量g: " + b.getStockGrams() +
                                ", 風味描述: " + b.getFlavorDesc() +
                                ", code: " + b.getCode()
                );
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 工具方法：取得文字欄位
    private static String getStringCell(Row row, int col) {
        Cell cell = row.getCell(col);
        return (cell == null) ? "" : cell.toString().trim();
    }

    // 工具方法：取得數字欄位（會轉 double）
    private static double getNumericCell(Row row, int col) {
        Cell cell = row.getCell(col);
        if (cell == null) return 0;
        if (cell.getCellType() == CellType.NUMERIC) {
            return cell.getNumericCellValue();
        } else {
            try {
                return Double.parseDouble(cell.toString().trim());
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }
}





