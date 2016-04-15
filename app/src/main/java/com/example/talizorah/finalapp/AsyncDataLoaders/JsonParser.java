package com.example.talizorah.finalapp.AsyncDataLoaders;

import com.example.talizorah.finalapp.CourseItems.CourseDataHolder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by talizorah on 16.11.4.
 */
public class JsonParser {
    public static CourseDataHolder[] parseJson(String jsonStr, int num) throws JSONException{
        String toConst = "ccy";
        String fromConst = "base_ccy";
        String buyConst = "buy";
        String sellConst = "sale";
        JSONArray courseArray = new JSONArray(jsonStr);
        CourseDataHolder[] resultStr = new CourseDataHolder[num];
        for(int i = 0; i < num; i++){
            JSONObject courseObject = courseArray.getJSONObject(i);
            resultStr[i] = new CourseDataHolder();
            resultStr[i].cFrom = courseObject.getString(fromConst);
            resultStr[i].cTo = courseObject.getString(toConst);
            resultStr[i].cBuy =courseObject.getString(buyConst);
            resultStr[i].cSale = courseObject.getString(sellConst);
        }
        return resultStr;
    }
}
