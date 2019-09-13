package interviews.vmware;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WikipediaWordCount {
    static int getTopicCount(String topic) throws IOException, MalformedURLException  {
        String s = getText(topic);
        String sa[] = s.split(topic);
        int finalLen = sa.length -1;
        if(s.startsWith(topic) )
            finalLen++;
        if(s.endsWith(topic))
            finalLen++;
        return finalLen;

    }

    static String getText(String s) throws IOException, MalformedURLException {
        InputStream is = new URL("https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page="+s).openStream();
        Gson gson = new Gson();

        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        Top m = gson.fromJson(rd, Top.class);
        return m.parse.text.toString();

    }

    static class Parse{
        Object text;
    }

    static class Top{
        Parse parse;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getTopicCount("france"));
    }
}
