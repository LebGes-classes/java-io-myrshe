package JSON;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Form parsing = new Form();
        parsing.readFromExcel("C:\\programming\\json_file\\src\\main\\java\\JSON\\schedule.xlsx");
        JSONObject jsonObject = parsing.makeToJSONFile();
        System.out.println("JSON: " + jsonObject.toString());

        writeJsonToFile(jsonObject, "Form.json");

        JSONObject jsonFromFile = readJsonFromFile("Form.json");

        System.out.println(jsonFromFile);
    }

    private static void writeJsonToFile(JSONObject jsonObject, String filePath) {
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static JSONObject readJsonFromFile(String filePath) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            String jsonString = lines.collect(Collectors.joining());
            return new JSONObject(jsonString.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
