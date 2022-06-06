package com.thelion.thegeoptapp.utilities;

import android.widget.LinearLayout;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.thelion.thegeoptapp.R;

import java.util.ArrayList;
import java.util.List;

public class GeneralUtilities {
    private static final String[] GRETTINGS = {"Hello!", "Hi!", "Good to see you!", "Good To See You Too!", "Consider To Donate!", "Nice Click There!"};


    public static String[] getGrettings(){
        return GRETTINGS;
    }

    public static List<String> fromJsonArrayToListString(JsonArray jsonArray){
        List<String> result = new ArrayList<>();
        for(JsonElement j: jsonArray){
            result.add(j.getAsString());
        }
        return result;
    }

    //NEED TO BE PROPERLY REFACTORED WITH typedefenumes for the colors
    public static void setLinearLayoutColor(LinearLayout ll, String coloru){
        switch (coloru){
            default:
                ll.setBackgroundResource(R.drawable.neutral);

        }
    }
}
