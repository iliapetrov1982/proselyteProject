package com.xometry.sonderlieferungen.service;


import com.monitorjbl.xlsx.StreamingReader;
import com.xometry.sonderlieferungen.model.Logistics;
import com.xometry.sonderlieferungen.repository.LogisticsRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LogisticsServiceImplementation implements LogisticsService {
    final LogisticsRepository logisticsRepository;

    public LogisticsServiceImplementation(LogisticsRepository logisticsRepository) {
        this.logisticsRepository = logisticsRepository;
    }

    @Override
    public Logistics getById(Long id) {
        return logisticsRepository.getOne(id);
    }

    @Override
    public void save(List<Logistics> dispatches) {
        logisticsRepository.saveAll(dispatches);
    }

    @Override
    public void delete(Long id) {
        logisticsRepository.deleteById(id);
    }

    @Override
    public List<Logistics> getAll() {
        return logisticsRepository.findAll();
    }

    @Override
    public List<Logistics> syncUp() {
        List<Logistics> logistics = getDataFromFile();
        return this.logisticsRepository.saveAll(logistics);
    }

    private List<Logistics> getDataFromFile() {
        List<Logistics> logistics = new ArrayList<>();
        Workbook wb;
        try {
            InputStream fis = new FileInputStream(new File("src/main/resources/data/Sonderlieferungen.xlsx"));
            wb = StreamingReader.builder().rowCacheSize(100).bufferSize(4096).open(fis);
            Sheet sheet = wb.getSheetAt(0);   //getting the XSSFSheet object at given index
            for (Row r : sheet) {
                int j = -1;
                Logistics dispatch = new Logistics();
                for (Cell cell : r) {
                    j++;
                    switch (j) {
                        case 0:
                            try {
                                dispatch.setOrder(cell.getStringCellValue());
                            } catch (IllegalStateException e) {
                                dispatch.setOrder(String.valueOf(cell.getNumericCellValue()));
                            }
                            break;
                        case 1:
                            dispatch.setLogisticAggregator(cell.getStringCellValue());
                            break;
                        case 2:
                            dispatch.setLogisticOperator(cell.getStringCellValue());
                            break;
                        case 3:
                            try {
                                dispatch.setDeliveryOrderNmb(cell.getStringCellValue());
                            } catch (IllegalStateException e) {
                                dispatch.setDeliveryOrderNmb(String.valueOf(cell.getNumericCellValue()));
                            }
                            break;
                        case 4:
                            try {
                                dispatch.setGrossPrice((double) cell.getNumericCellValue());
                            } catch (IllegalStateException e) {
                                dispatch.setGrossPrice(0.0);
                            }
                            break;
                        case 5:
                            try {
                                dispatch.setNetPrice(cell.getNumericCellValue());
                            } catch (IllegalStateException e) {
                                dispatch.setNetPrice(0.0);
                            }
                            break;
                        case 6:
                            dispatch.setReason(cell.getStringCellValue());
                            break;
                        case 7:
                            try {
                                String dateFormatted = convertDate(cell.getDateCellValue());
                                dispatch.setDateOfBooking(dateFormatted);
                            } catch (IllegalStateException e) {
                                dispatch.setDateOfBooking("1970-01-01");
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

    private String convertDate(Date date) {
        if (date != null) {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.format(date);
        } else {
            return "1970-01-01";
        }
    }
}
