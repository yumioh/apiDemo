package com.example.apidemo.controller;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class CodeExcelReader {
    public static void main(String[] args) throws Exception {
        //엑셀파일 데이터 읽기
        getExcelReader();
    }

    private static void getExcelReader() {
        try {
            FileInputStream file = new FileInputStream(new File("/Users/yumioh/Documents/excelfile/codefile.xlsx"));
            //해당 파일 엑셀 시트 들고 오기
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            //엑셀 시트 개수 들고 오기
            int sheetPage = workbook.getNumberOfSheets();

            for (int i=0; i < sheetPage; i++) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                //sheet의 row 개수
                int rows = sheet.getPhysicalNumberOfRows();
                for (int j=0; j < rows; j++) {
                    //한 행씩 받아옴
                    XSSFRow row = sheet.getRow(j);
                    //row 안의 셀의 갯수
                    int cells = row.getPhysicalNumberOfCells();
                    for (int k=0; k < cells; k++) {
                        XSSFCell cell = row.getCell(k);
                        String value = "";
                        if (cell == null) {
                            continue;
                        } else {
                            switch (cell.getCellType()){
                                case FORMULA : value = cell.getCellFormula();
                                break;
                                case NUMERIC : value = cell.getNumericCellValue()+"";
                                break;
                                case STRING : value = cell.getStringCellValue()+"";
                                break;
                                case BLANK : value = cell.getBooleanCellValue()+"";
                                break;
                                case ERROR : value = cell.getErrorCellValue()+"";
                                break;
                            }
                        }
                        System.out.println(j+"번 행 "+k+"번 열 :"+value);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}