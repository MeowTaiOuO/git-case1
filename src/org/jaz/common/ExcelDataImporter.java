package org.jaz.common;


import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelDataImporter {
    public static void main(String[] args)  throws IOException {
        System.out.println("Begin to import excel data...");
        //open file
        try (FileInputStream fileIn = new FileInputStream("resources/roast.xlsx")) {
//            POIFSFileSystem fs = new POIFSFileSystem(fileIn);
            XSSFWorkbook wb = new XSSFWorkbook(fileIn);
            XSSFSheet sheet = wb.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);
                System.out.println(String.format("Row #%d: %s %s %s %s %s %s %s %s %s %s %s %s", i
                        , row.getCell(0)
                        , row.getCell(4) != null?row.getCell(4).getStringCellValue():""
                        , row.getCell(5) != null?row.getCell(5).getStringCellValue():""
                        , row.getCell(6) != null?row.getCell(6).getStringCellValue():""
                        , row.getCell(7) != null?row.getCell(7).getStringCellValue():""
                        , row.getCell(8) != null?row.getCell(8).getStringCellValue():""                ));
            }

            // Write the output to a file
            try (FileOutputStream fileOut = new FileOutputStream("workbookout.xls")) {
                wb.write(fileOut);
            }
        }
    }
}
