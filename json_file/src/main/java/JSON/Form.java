package JSON;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Form {
    private List<Performer> performers = new ArrayList<>();
    private List<Director> directors = new ArrayList<>();
    public Form() {
    }
    public void readFromExcel(String FilePath) {
        try {
            FileInputStream excelFile = new FileInputStream(new File(FilePath));
            Workbook workbook = new XSSFWorkbook(excelFile);

            Sheet DirectorsSheet = workbook.getSheetAt(0);
            for (int i = 0; i <= DirectorsSheet.getLastRowNum(); i++) {
                Row DirectorNameRow = DirectorsSheet.getRow(i);
                Row FilmRow = DirectorsSheet.getRow(i);

                String DirectorName = DirectorNameRow.getCell(0).getStringCellValue();
                String FilmName = FilmRow.getCell(1).getStringCellValue();
                Film film = new Film(FilmName);
                Director director = new Director(DirectorName, film);
                directors.add(director);
            }
            Sheet performersSheet = workbook.getSheetAt(1);
            for (int i = 0; i <= performersSheet.getLastRowNum(); i++) {
                Row performerNameRow = performersSheet.getRow(i);
                Row numberOfRolesRow = performersSheet.getRow(i);


                String performerName = performerNameRow.getCell(0).getStringCellValue();
                Integer numberOfRoles = (int) numberOfRolesRow.getCell(1).getNumericCellValue();


                Performer performer = new Performer(performerName, numberOfRoles);
                performers.add(performer);
            }

            workbook.close();
            excelFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JSONObject makeToJSONFile() {
        JSONObject jsonObject = new JSONObject();
        JSONArray performersArr = new JSONArray();
        JSONArray directorsArr = new JSONArray();

        for (Performer p : performers) {
            JSONObject performerObj = new JSONObject();
            performerObj.put("Имя", p.getName());
            performerObj.put("Количество ролей", p.getNumberOfRoles());
            performersArr.put(performerObj);
        }
        for (Director d : directors) {
            JSONObject directorObj = new JSONObject();
            directorObj.put("Имя", d.getName());
            directorObj.put("Популярный фильм", d.getFilm());
            directorsArr.put(directorObj);
        }
        jsonObject.put("Актеры", performersArr);
        jsonObject.put("Режиссеры", directorsArr);

        return jsonObject;
    }
}

