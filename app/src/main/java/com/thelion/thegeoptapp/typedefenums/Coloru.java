package com.thelion.thegeoptapp.typedefenums;
import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


public class Coloru {
    public static final String RED = "RED";
    public static final String BLUE = "BLUE";
    public static final String GREEN = "GREEN";
    public static final String PT = "PT";

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({RED,BLUE,GREEN,PT})
    public @interface ColoruGiven{}
    private final String coloru;

    public Coloru(@ColoruGiven String coloru){
        this.coloru = coloru;
    }
    public String getColoru() {
        return coloru;
    }
}
