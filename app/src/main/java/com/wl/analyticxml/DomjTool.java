package com.wl.analyticxml;

import android.content.Context;
import android.util.Log;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * Created by travel12 on 2016/9/3.
 */
public class DomjTool implements Dom4jReadExmple {
    @Override
    public void getSelectedNodeValue(Context context) {
        SAXReader saxReader = new SAXReader();
        InputStream inputStream = null;
        try {
            inputStream=context.getClass().getClassLoader().getResourceAsStream("assets/china_city.xml");
          //  inputStream = context.getResources().getAssets().open("china_city.xml");
            Document document = saxReader.read(inputStream);
            List list=document.selectNodes("/root/node");////返回XMLNodes集合,参数为有效的 XPath 字符串
            //获取某一个省下面的市
            List list1 =  document.selectNodes("/root/node[@ID='410000']/node");
            Iterator iter=list1.iterator();
            while (iter.hasNext()){
               Element element= (Element) iter.next();
                String henan_city=element.attributeValue("Name");
                String henan_city_id=element.attributeValue("ID");
                Log.i("henan_city:",henan_city);
                Log.i("henan_city_id:",henan_city_id);
                Iterator iterator2=element.elementIterator();
                while (iterator2.hasNext()){
                    Element element2= (Element) iterator2.next();
                    String areaName=element2.attributeValue("Name");
                    String areaId=element2.attributeValue("ID");
                    Log.i("区:",areaName);
                    Log.i("区域ID:",areaId);
                }
            }
            Iterator iterator=list.iterator();
            while (iterator.hasNext()){
                Element element= (Element) iterator.next();
                String provinceName=element.attributeValue("Name");
                String provinceId=element.attributeValue("ID");
                Log.i("省：",provinceName);
                Log.i("省区域ID：",provinceId);

//                Iterator iterator1=element.elementIterator();
//                while (iterator1.hasNext()){
//                    Element element1= (Element) iterator1.next();
//                    String cityName=element1.attributeValue("Name");
//                    String cityId=element1.attributeValue("ID");
//                    Log.i("市:",cityName);
//                    Log.i("市区域ID:",cityId);


  //              }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
