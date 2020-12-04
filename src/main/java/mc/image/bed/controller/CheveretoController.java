package mc.image.bed.controller;


import com.alibaba.fastjson.JSON;
import mc.image.bed.util.CheveretoUtil;
import mc.image.bed.util.PostImgUtil;
import mc.image.bed.util.Util;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/che")
public class CheveretoController {

    @RequestMapping(value = "/jsonCategorys" , method = RequestMethod.POST)
    public Object jsonCategorys(){
        List<Map<String, String>> categorys = CheveretoUtil.getCategorys();
        return Util.respSuccessMsg("操作成功!" , categorys);
    }




    @RequestMapping(value = "/imagePage" , method = RequestMethod.POST)
    public Object jsons(String category){

        List<Map<String, String>> imagesPage = CheveretoUtil.getImagesPage(category);
        return Util.respSuccessMsg("操作成功!" , imagesPage);
    }


    @RequestMapping(value = "/imagePageNumber" , method = RequestMethod.POST)
    public Object jsons(String category , Integer page){
        List<Map<String, String>> imagesPage = CheveretoUtil.getImagesPageNumber(category , page);
        return Util.respSuccessMsg("操作成功!" , imagesPage );
    }

}
