package RecursiveAndDivision;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 杨帆 on 2017/3/21.
 */
public class CountNumber {
    public static void main(String[] args) throws IOException {
        CountNumber("C:\\Users\\杨帆\\Desktop\\1.txt","C:\\Users\\杨帆\\Desktop\\2.txt");
    }
    private static void CountNumber(String inputPath, String outputPath) throws IOException {
        try {
            FileInputStream fis = new FileInputStream(inputPath);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            Map<Integer , Integer> numberCountMap = new HashMap<>();
            String tmp;
            br.readLine();
            while (br.ready()){
                tmp = br.readLine();
                if (tmp.length() > 0){
                    Integer tn = Integer.parseInt(tmp);
                    numberCountMap.put( tn, numberCountMap.containsKey(tn) ? numberCountMap.get(tn) + 1 : 1);
                }
            }
            br.close();
            isr.close();
            fis.close();
            int maxCount = 0;
            int maxValue = 0;
            for (Map.Entry<Integer , Integer> m : numberCountMap.entrySet()){
                if (m.getValue() > maxCount){
                    maxCount = m.getValue();
                    maxValue = m.getKey();
                }
            }
            FileOutputStream fos = new FileOutputStream(outputPath);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bfw = new BufferedWriter(osw);
            bfw.write(maxValue + "\r\n");
            bfw.write(maxCount + "");
            bfw.close();
            osw.close();
            fos.close();
            System.out.println("成功!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
