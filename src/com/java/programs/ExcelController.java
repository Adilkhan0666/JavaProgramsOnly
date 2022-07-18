package com.java.programs;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
class ExcelController {

    @RequestMapping("/readExcel")
    public String readExcel() {
        System.out.println("starting");

        String path = "C:\\Users\\adg\\Desktop\\TrackMyMoney.xlsx";
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(path);

            XSSFSheet sheet = workbook.getSheet("Sheet1");
            int rowCount = sheet.getPhysicalNumberOfRows();
            String name = sheet.getRow(0).getCell(0).getStringCellValue();
            System.out.println(name + "--");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Success";

    }

    @RequestMapping("/writeExcel")
    public String writeExcel() {
        System.out.println("starting");
        String path = "C:\\Users\\adilk\\Desktop\\TrackMyMoney.xlsx";
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(path));
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet("Sheet1");
            int noOfRows = sheet.getLastRowNum();
            System.out.println(noOfRows);

            Row row = sheet.createRow(1);
            Cell cell = row.createCell(0);
            String data = sheet.getRow(1).getCell(0).getStringCellValue();
            if (!data.equals("")) {
                cell.setCellValue("Hi Adil Khan");
            } else {
                sheet.createRow(2);
                row.createCell(2);
                cell.setCellValue("else");
            }
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            System.out.println("done......");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Success";

    }

    @RequestMapping("/appendExcel")
    public String appendExcel() {
        System.out.println("starting- append");
        String path = "C:\\Users\\adg\\Desktop\\TrackMyMoney.xlsx";
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(path));
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            int noOfRows = sheet.getLastRowNum();
            System.out.println(noOfRows + "name" + sheet.getSheetName());

            Object[][] data = {
                    {"adilbhai", "delhi delhi", 25}
            };
            for (Object[] objectData : data) {
                Row row = sheet.createRow(++noOfRows);
                int colCount = 0;
                Cell cell = row.createCell(colCount);
                cell.setCellValue(noOfRows);
                for (Object field : objectData) {
                    cell = row.createCell(++colCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }
            }
            fileInputStream.close();

            FileOutputStream fileOutputStream = new FileOutputStream(path);
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            System.out.println("done......");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Success";

    }
}