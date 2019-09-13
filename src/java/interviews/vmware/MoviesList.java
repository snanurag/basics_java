package interviews.vmware;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;

import com.google.gson.Gson;

public class MoviesList {
    static class Movie {
        int   total_pages;

        List<Data> data;
    }

    static class Data {
        String Title;
    }

    static String[] getMovieTitles(String substr)  throws IOException, MalformedURLException {
        InputStream is = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr+"&page=1").openStream();
        Gson gson = new Gson();

        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        Movie m = gson.fromJson(rd, Movie.class);

        int totalpages = m.total_pages;


        int page = 1;
        List<String> list = new ArrayList<>();
        while(page <=totalpages){
            list.addAll(getTitleList(substr, page));
            page++;
        }
        Collections.sort(list);
        String sa[] = new String[list.size()];
        return list.toArray(sa);
    }

    static List<String> getTitleList(String subString, int page) throws IOException, MalformedURLException{
        InputStream is = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title="+subString+"&page="+page).openStream();
        Gson gson = new Gson();

        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        Movie m = gson.fromJson(rd, Movie.class);
        List<String> list = new ArrayList<>();
        for(Data d:m.data){
            list.add(d.Title);
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        Arrays.stream(getMovieTitles("spiderman")).forEach(System.out::println);
    }
}