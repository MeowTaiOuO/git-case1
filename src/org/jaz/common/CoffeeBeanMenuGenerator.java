package org.jaz.common;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.jaz.james.tutorial.CoffeeBean;

public class CoffeeBeanMenuGenerator {

    public void generateTitle(Row row) {
        //產生豆單 title
    }

    public void generateBeanColumnHeader(Row row) {
        //產生豆單標題
    }

    public Row generateRow(Row row, CoffeeBean bean) {
        if (row != null) {
            Cell c1 = row.createCell(1);
            fillCell1(c1, bean);

            Cell c2 = row.createCell(2);
            fillCell2(c2, bean);

            Cell c3 = row.createCell(3);
            fillCell3(c3, bean);

            Cell c4 = row.createCell(4);
            fillCell4(c4, bean);
        }

        return row;
    }

    private void fillCell1(Cell cell, CoffeeBean coffeeBean) {
        Sheet sheet = cell.getSheet();
        CellStyle cs = cell.getSheet().getWorkbook().createCellStyle();
        cs.setWrapText(true);
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setVerticalAlignment(VerticalAlignment.CENTER);



        cell.getRow().setHeightInPoints( 3 * sheet.getDefaultRowHeightInPoints());
        cell.setCellStyle(cs);

        cell.setCellValue( coffeeBean.getId() + "\n" + coffeeBean.getCountry() + "\n" + coffeeBean.getProcessMethod());
    }

    private void fillCell2(Cell cell,CoffeeBean coffeeBean) {

    }

    private void fillCell3(Cell cell,CoffeeBean coffeeBean) {

    }

    private void fillCell4(Cell cell,CoffeeBean coffeeBean) {

    }

}
