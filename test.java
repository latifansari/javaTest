import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class test {
    public static void main(String[] args) throws FileNotFoundException {
        String line = "";
        String line2 = "";
        String line3 = "";
        String splitBy = ",";

        try {
            FileOutputStream fos = new FileOutputStream("OutPutFileOfWithoutArguments.csv", true);
            PrintWriter pw = new PrintWriter(fos);
            pw.println("Symbol,Range,Range2,Range3,DATR");

            BufferedReader br = new BufferedReader(new FileReader("cm29JAN2020bhav.csv"));
            line = br.readLine();
            BufferedReader br2 = new BufferedReader(new FileReader("cm30JAN2020bhav.csv"));
            line2 = br2.readLine();
            BufferedReader br3 = new BufferedReader(new FileReader("cm31JAN2020bhav.csv"));
            line3 = br3.readLine();

            while ((line = br.readLine()) != null && (line2 = br2.readLine()) != null && (line3 = br3.readLine()) != null) {
                String[] data = line.split(splitBy);
                String[] data2 = line2.split(splitBy);
                String[] data3 = line3.split(splitBy);

                float high = Float.parseFloat(data[3]);
                float low = Float.parseFloat(data[4]);
                float range = high - low;

                float high2 = Float.parseFloat(data2[3]);
                float low2 = Float.parseFloat(data2[4]);
                float range2 = high2 - low2;

                float high3 = Float.parseFloat(data3[3]);
                float low3 = Float.parseFloat(data3[4]);
                float range3 = high3 - low3;

                float DATR = (range + range2 + range3) / 3;
                String symbol = data[0];
                //System.out.println("Symbol"+data[0]+range+"\t"+range2+"\t"+range3);
                //System.out.println("DATR:\t"+(range+range2+range3)/3);
                pw.println(symbol + "," + range + "," + range2 + "," + range3 + "," + DATR);

            }
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}