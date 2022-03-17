import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ReaderFromCSV {

    public static void main(String[] args) throws IOException, CsvValidationException {
        Scanner sc = new Scanner(System.in);
        System.out.println("введите путь файла");
        String pathToCsv = sc.nextLine();
        System.out.println("Введите имя строки");
        String columnName = sc.nextLine();

        CSVParser csvParser = new CSVParserBuilder().withSeparator(',').build();
        CSVReader reader = new CSVReaderBuilder(new FileReader(pathToCsv))
                    .withCSVParser(csvParser)
                    .build();

        String[] nextLine;
        List<Integer> v = new ArrayList<>();
        List<String[]> qq = new ArrayList<>();
            while ((nextLine = reader.readNext()) != null) {
                qq.add(nextLine);
                int i =1;
                i++;
                int index = indexOfColumn(columnName, nextLine[0]);
                int value = Integer.parseInt(qq.get(i)[index]);
                v.add(value);
                    }
        System.out.println(Collections.max(v));
    }

    public static int indexOfColumn(String columnName, String nextLine) {
        int index = nextLine.indexOf(columnName);
        return index;
    }
}

