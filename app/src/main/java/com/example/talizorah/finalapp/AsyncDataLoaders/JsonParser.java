package com.example.talizorah.finalapp.AsyncDataLoaders;

import com.example.talizorah.finalapp.CourseItems.CourseDataHolder;
import com.example.talizorah.finalapp.cashMachine.CashMachineItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static List<CashMachineItem> parseCashMachineJson(String json) throws JSONException {
        String address = "fullAddressUa";
        String place = "placeUa";
        String schedule = "tw";
        List<String> daysList = Arrays.asList("mon", "tue", "wed", "thu", "fri", "sat", "sun");
        JSONObject parentObject = new JSONObject(json);
        JSONArray cashMachineArray = parentObject.getJSONArray("devices");
        List<CashMachineItem> machineList = new ArrayList<CashMachineItem>();
        for(int i=0; i<cashMachineArray.length(); i++){
            JSONObject currentObject = cashMachineArray.getJSONObject(i);
            CashMachineItem item = new CashMachineItem();
            item.setAddress(currentObject.getString(address));
            item.setPlace(currentObject.getString(place));

            List<String> currentSchedule = new ArrayList<>();
            JSONObject scheduleJson = currentObject.getJSONObject(schedule);
            for(int j=0; j<daysList.size(); j++)
                currentSchedule.add(scheduleJson.getString(daysList.get(j)));
            item.setSchedule(currentSchedule);
            machineList.add(item);
        }
        return machineList;
    }
}
