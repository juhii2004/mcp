package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static List<String[]> getData(String filePath, String sheetName) {
        List<String[]> data = new ArrayList<>();

        try {
            Workbook workbook = WorkbookFactory.create(new File(filePath));
            Sheet sheet = workbook.getSheet(sheetName);

            for (Row row : sheet) {

                if (row.getRowNum() == 0) continue; // skip header

                String url = row.getCell(0).getStringCellValue();
                String title = row.getCell(1).getStringCellValue();

                data.add(new String[]{url, title});
            }

            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}