package org.jaz.anita.shop;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jaz.common.CoffeeBeanMenuGenerator;
import org.jaz.common.ExcelDataImporter;
import org.jaz.james.tutorial.CoffeeBean;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class CoffeePOSApplication {
    public static void main(String[] args) {
        System.out.println("Begin to import excel data...");
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

            //關檔 前 autofit columns, 參考 https://blog.csdn.net/l18848956739/article/details/86646944
            for (int i = 1; i < 5; i++) {
                sheet.autoSizeColumn((short)i);
                sheet.setColumnWidth((short)i, (short)sheet.getColumnWidth(i)*17/10);
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
