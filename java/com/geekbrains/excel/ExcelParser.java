package com.geekbrains.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelParser {

    private HSSFWorkbook workbook = null;

    private void setBook(String filename){
        try {
            workbook = new HSSFWorkbook(new FileInputStream(filename));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String parse(String filename){
        setBook(filename);
        if (workbook == null) return null;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Sheet> sheetIterator = workbook.iterator();
        int list_count = 0;
        while (sheetIterator.hasNext()){
            Sheet sheet = sheetIterator.next();
            Iterator<Row> iterator = sheet.iterator();
            list_count++;
            stringBuilder.append("\n").append("List ").append(list_count).append("\n");
            while (iterator.hasNext()){
                Row row = iterator.next();
                Iterator<Cell> cellIterator = row.iterator();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    CellType cellType = cell.getCellType();
                    switch (cellType){
                        case NUMERIC:
                        case FORMULA:
                            stringBuilder.append(cell.getNumericCellValue());
                            break;
                        default: stringBuilder.append(cell.getStringCellValue());
                    }
                }
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

}
