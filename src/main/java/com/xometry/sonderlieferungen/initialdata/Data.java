package com.xometry.sonderlieferungen.initialdata;


import com.monitorjbl.xlsx.StreamingReader;
import com.xometry.sonderlieferungen.model.Logistics;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Data {

    public Data() {
    }

    public List<Logistics> getDataFromFile() {
        List<Logistics> logistics = new ArrayList<>();
        Workbook wb = null;           //initialize Workbook null
        try {
            InputStream fis = new FileInputStream(new File("src/main/resources/data/Sonderlieferungen.xlsx"));
            wb = StreamingReader.builder().rowCacheSize(100).bufferSize(4096).open(fis);
            Sheet sheet = wb.getSheetAt(0);   //getting the XSSFSheet object at given index
            for (Row r: sheet) {
                int j = -1;
                Logistics dispatch = new Logistics();
                for (Cell cell: r) {
                    j++;
                    switch (j) {
                        case 0:
                            try{
                                dispatch.setOrder(cell.getStringCellValue());
                            } catch (IllegalStateException e) {
                                dispatch.setOrder( String.valueOf(cell.getNumericCellValue()));
                            }
                            break;
                        case 1:
                            dispatch.setLogistic_aggregator(cell.getStringCellValue());
                            break;
                        case 2:
                            dispatch.setLogistic_operator(cell.getStringCellValue());
                            break;
                        case 3:
                            try{
                                dispatch.setDelivery_order_nmb(cell.getStringCellValue());
                            } catch (IllegalStateException e) {
                                dispatch.setDelivery_order_nmb(String.valueOf(cell.getNumericCellValue()));
                            }
                            break;
                        case 4:
                            try {
                                dispatch.setGross_price((double) cell.getNumericCellValue());
                            } catch (IllegalStateException e) {
                                dispatch.setGross_price(0.0);
                            }
                            break;
                        case 5:
                            try {
                                dispatch.setNet_price(cell.getNumericCellValue());
                            } catch (IllegalStateException e) {
                                dispatch.setNet_price(0.0);
                            }
                            break;
                        case 6:
                            dispatch.setReason(cell.getStringCellValue());
                            break;
                        case 7:
                            try {
                                String dateFormatted = convertDate(cell.getDateCellValue());
//                                System.out.println(dateFormatted);
                                dispatch.setDate_of_booking(dateFormatted);
                            } catch (IllegalStateException e) {
                                dispatch.setDate_of_booking("1970-01-01");
                            }
                            break;
                        case 8:
                            dispatch.setStatus(cell.getStringCellValue());
                            break;
                    }
                }
                System.out.println(dispatch.toString());
                logistics.add(dispatch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logistics;
    }

    public String convertDate(Date date) {
        if (date != null) {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.format(date);
        } else {
            return "1970-01-01";
        }
    }
}
