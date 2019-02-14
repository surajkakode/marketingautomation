package screener;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

    @DataProvider(name = "symbol")
    public Iterator<Object[]> credentials() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("csvFile")));
        String line;
        List<Object []> cols = new ArrayList<>();
        String[] data= null;
        while ((line = br.readLine()) != null) {
            // use comma as separator
            data = line.split(",");
            cols.add(data);

        }
        return cols.iterator();
    }

    @org.testng.annotations.Test(dataProvider = "symbol")
    public void screenerData(String SYMBOL,String SERIES,String OPEN,String HIGH,String LOW,String CLOSE,String LAST,String PREVCLOSE,String TOTTRDQTY,String TOTTRDVAL,String TIMESTAMP,String TOTALTRADES,String ISIN) {

        System.out.println("============================ main block========================");
        System.out.println(SYMBOL);


    }

    /*public void connect() {
        wholelist = [gegesg, grgrg, fgergrg];
        while (eho.none) {
            wholelist.removeFirst(100);
            lrt htt = req(fesfesfe);
            let g = [h1, ht2] //forkjoin
            g.listen(x = > x.length == 100){

            }
        }
    }*/



    @org.testng.annotations.Test
    public void testdelete()
    {
        File file = new File("D:\\fincash-marketing-automation\\download\\cm05FEB2019bhav.csv");

        file.delete();
    }
}

