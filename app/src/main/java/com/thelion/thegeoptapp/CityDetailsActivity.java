package com.thelion.thegeoptapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CityDetailsActivity extends AppCompatActivity {

    private TextView cityNameDetailsActivityHeader;
    private TextView telephonePlaceTextView;
    private TextView emailPlaceTextView;
    private TextView sitioPlaceTextView;
    private TextView faxPlaceTextView;
    private TextView codigopostalPlaceTextView;
    private TextView descrpostalPlaceTextView;
    private TextView localidadePlaceTextView;
    private TextView codigoPlaceTextView;
    private TextView nifPlaceTextView;
    private TextView areaPlaceTextView;
    private TextView populacaoPlaceTextView;
    private TextView eleitoresPlaceTextView;
    private TextView codigoinePlaceTextView;
    private TextView ruaPlaceTextView;
    private TextView distritoPlaceTextView;

    private String cityinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_details);
        setCityDetailsInterfaceElements();
        getCityInfo();
        setCityDetails(new Gson().fromJson(cityinfo,JsonObject.class));
    }

    private void setCityDetails(JsonObject cityDetails){
        // Yes, I need to find an smart way of doing these type of setups

        cityNameDetailsActivityHeader.setText(cityDetails.get("nome").toString());
        telephonePlaceTextView.setText(cityDetails.get("telefone").toString());
        emailPlaceTextView.setText(cityDetails.get("email").toString());
        sitioPlaceTextView.setText(cityDetails.get("sitio").toString());
        faxPlaceTextView.setText(cityDetails.get("fax").toString());
        codigopostalPlaceTextView.setText(cityDetails.get("codigopostal").toString());
        descrpostalPlaceTextView.setText(cityDetails.get("descrpostal").toString());
        localidadePlaceTextView.setText(cityDetails.get("localidade").toString());
        codigoPlaceTextView.setText(cityDetails.get("codigo").toString());
        nifPlaceTextView.setText(cityDetails.get("nif").toString());
        areaPlaceTextView.setText(cityDetails.get("areaha").toString());
        populacaoPlaceTextView.setText(cityDetails.get("populacao").toString());
        eleitoresPlaceTextView.setText(cityDetails.get("eleitores").toString());
        codigoinePlaceTextView.setText(cityDetails.get("codigoine").toString());
        ruaPlaceTextView.setText(cityDetails.get("rua").toString());
        distritoPlaceTextView.setText(cityDetails.get("distrito").toString());
    }

    private void setCityDetailsInterfaceElements(){
        cityNameDetailsActivityHeader = (TextView) findViewById(R.id.cityNameDetailsActivityHeader);
        telephonePlaceTextView = (TextView) findViewById(R.id.telephonePlaceTextView);
        emailPlaceTextView = (TextView) findViewById(R.id.emailPlaceTextView);
        sitioPlaceTextView = (TextView) findViewById(R.id.sitioPlaceTextView);
        faxPlaceTextView = (TextView) findViewById(R.id.faxPlaceTextView);
        codigopostalPlaceTextView = (TextView) findViewById(R.id.codigopostalPlaceTextView);
        descrpostalPlaceTextView = (TextView) findViewById(R.id.descrpostalPlaceTextView);
        localidadePlaceTextView = (TextView) findViewById(R.id.localidadePlaceTextView);
        codigoPlaceTextView = (TextView) findViewById(R.id.codigoPlaceTextView);
        nifPlaceTextView = (TextView) findViewById(R.id.nifPlaceTextView);
        areaPlaceTextView = (TextView) findViewById(R.id.areaPlaceTextView);
        populacaoPlaceTextView = (TextView) findViewById(R.id.populacaoPlaceTextView);
        eleitoresPlaceTextView = (TextView) findViewById(R.id.eleitoresPlaceTextView);
        codigoinePlaceTextView = (TextView) findViewById(R.id.codigoinePlaceTextView);
        ruaPlaceTextView = (TextView) findViewById(R.id.ruaPlaceTextView);
        distritoPlaceTextView = (TextView) findViewById(R.id.distritoPlaceTextView);
    }

    private void getCityInfo(){
        Intent intent = getIntent();
        cityinfo = intent.getStringExtra("cityinfo");
        Log.d("CITYINFO", cityinfo);
    }
}