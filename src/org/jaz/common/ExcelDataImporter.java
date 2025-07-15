package org.jaz.common;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelDataImporter {
    public static void main(String[] args)  throws IOException {
        System.out.println("Begin to import excel data...");
        //open file
        try (FileInputStream fileIn = new FileInputStream("resources/roast.xlsx")) {
            POIFSFileSystem fs = new POIFSFileSystem(fileIn);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row = sheet.getRow(2);
            if (row == null)
                row = sheet.createRow(2);
            HSSFCell cell = row.getCell(3);
            if (cell == null)
                cell = row.createCell(3);
            cell.setCellValue("a test");

            // Write the output to a file
            try (FileOutputStream fileOut = new FileOutputStream("workbookout.xls")) {
                wb.write(fileOut);
            }
        }
    }
}
