package bhavcopy;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetDataFromExcel extends TestBase {

    public static final Logger log = Logger.getLogger(GetDataFromExcel.class.getName());


    @Test
    public Iterator<Object[]> bhavcopyReader() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("csvFile")));
        String line;
        List<Object []> cols = new ArrayList<>();
        String[] data= null;
        while ((line = br.readLine()) != null) {
            // use comma as separator
            data = line.split(",");
            cols.add(data);

        }
        cols.remove(0);
        return cols.iterator();


    }
}
