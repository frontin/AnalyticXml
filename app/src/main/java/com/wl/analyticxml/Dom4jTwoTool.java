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
public class Dom4jTwoTool implements Dom4jReadExmple {
    @Override
    public void getSelectedNodeValue(Context context) {
        SAXReader saxReader = new SAXReader();
        InputStream inputStream = null;
        try {
            inputStream=context.getClass().getClassLoader().getResourceAsStream("assets/province_data.xml");
            //  inputStream = context.getResources().getAssets().open("china_city.xml");
            Document document = saxReader.read(inputStream);
            List list=document.selectNodes("/root/province");////返回XMLNodes集合,参数为有效的 XPath 字符串
            //获取某一个省下面的市
            List list1 =  document.selectNodes("/root/province[@name='安徽省']/city");
            Iterator iter=list1.iterator();
            while (iter.hasNext()){
                Element element= (Element) iter.next();
                String anhui_city=element.attributeValue("name");
                Log.i("anhui_city:", anhui_city);
                Iterator iterator2=element.elementIterator();
                while (iterator2.hasNext()){
                    Element element2= (Element) iterator2.next();
                    String areaName=element2.attributeValue("name");
                  //  String areaId=element2.attributeValue("ID");
                    Log.i("区:",areaName);
                  //  Log.i("区域ID:",areaId);
                }
            }
            Iterator iterator=list.iterator();
            while (iterator.hasNext()){
                Element element= (Element) iterator.next();
                String provinceName=element.attributeValue("name");
                Log.i("省：",provinceName);

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
