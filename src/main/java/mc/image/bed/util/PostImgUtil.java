package mc.image.bed.util;

import mc.image.bed.entity.HttpResponseEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostImgUtil {



    static String RootPath = "https://postimg.cc";
    static String ImagePath = "https://i.postimg.cc";

    public static List<Map<String , String>> getImagesByCategory(String category){
        String categoryPath = RootPath+"/gallery/"+category;
        HttpResponseEntity httpResponseEntity = HttpClient.doGet(categoryPath, null);
        return  string2Document(httpResponseEntity.getContent());
    }




    public static List<Map<String , String>> string2Document(String htmlString){
        Document parse = Jsoup.parse(htmlString);
        Elements elementsByClass = parse.getElementsByClass("thumb-container");
        List<Map<String , String>> maps = new ArrayList<>();
        Map<String , String>  tmpMap = null;
        for (Element element : elementsByClass){
            tmpMap = new HashMap<>();
            String dataThumbDir = element.attr("data-image");
            String dataHotlinkDir = element.attr("data-hotlink");
            String dataExt = element.attr("data-ext");
            String dataName = element.attr("data-name")+"."+dataExt;
            String thumbUrl = ImagePath + "/" + dataThumbDir + "/" + dataName;
            String imagebUrl = ImagePath + "/" + dataHotlinkDir + "/" + dataName;
            tmpMap.put("key" , thumbUrl);
            tmpMap.put("value" , imagebUrl);
            maps.add(tmpMap);
        }
        return maps;
    }

    public static void main(String[] args) {



        getImagesByCategory("jTQZ4rj");
    }


}
