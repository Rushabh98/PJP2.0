package Main;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class WriteCSVfile {
    public static void write(List<FinalUserData> finalUserData, String outputFilePath)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath), "UTF-8"));
            
            StringBuffer line = new StringBuffer();
            line.append("Country/City Name" + "," + "Gender" + "," + "Average Income");
            bw.write(line.toString());
            bw.newLine();
            
            for (FinalUserData fud : finalUserData)
            {
            	line = new StringBuffer();
            	if(fud.getPlace() != null)
            		line.append(fud.getPlace());
                line.append(",");
                if(fud.getGender() != null)
            		line.append(fud.getGender());
                line.append(",");
                line.append(fud.getAvg_salary());
                line.append(",");

                bw.write(line.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }
}
