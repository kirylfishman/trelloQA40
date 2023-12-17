package data;
import dto.UserDTOLombok;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class DataProviderLogin {
    @DataProvider
    public Iterator<Object[]> usersPositiveData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                UserDTOLombok.builder()
                        .email("fishmank89@gmail.com")
                        .password("Mad5610isr")
                        .build()
        });
        list.add(new Object[]{
                UserDTOLombok.builder()
                        .email("fishmank89@gmail.com")
                        .password("Mad5610isr")
                        .build()
        });
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> usersNegativeData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                UserDTOLombok.builder()
                        .email("fismank89@gmail.com")
                        .password("Mad5610isr")
                        .build()
        });
        list.add(new Object[]{
                UserDTOLombok.builder()
                        .email("fismank89@gmail.com")
                        .password("Mad5610isr")
                        .build()
        });
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginCSV() { // Data Transfer Object = DTO
        List<Object[]> list = new ArrayList<>();
        String path = "src/test/resources/logindata.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line = reader.readLine();
        while (line != null&& line!=""){
                String[] split = line.split(",");
                list.add(new Object[] { UserDTOLombok.builder().email(split[0]).password(split[1]).build()});
                line = reader.readLine();
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        //  reader.close();
        return list.iterator();
    }
}
