package org.jaz.common;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jaz.james.tutorial.CoffeeBean;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelDataImporter {

    public static List<CoffeeBean> loadCoffeeBeansFromExcel(String filePath) throws IOException {

        List<CoffeeBean> beanList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("beans");
            if (sheet == null) {
                throw new IOException("找不到名為 beans 的工作表");
            }

            int firstRowNum = sheet.getFirstRowNum();
            int lastRowNum = sheet.getLastRowNum();


            for (int i = firstRowNum + 1; i <= lastRowNum; i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                CoffeeBean b = new CoffeeBean();

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


            for (CoffeeBean b : beanList) {
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
            throw e;
        }

        return beanList;
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
        } else if (cell.getCellType() == CellType.FORMULA && cell.getCachedFormulaResultType() == CellType.NUMERIC) {
            return cell.getNumericCellValue();
        } else {
            try {
                return Double.parseDouble(cell.toString().trim());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                return 0;
            }
        }
    }

}
