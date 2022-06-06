package com.thelion.thegeoptapp.ui.cities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thelion.thegeoptapp.R;
import com.thelion.thegeoptapp.adapters.CitiesListAdapter;
import com.thelion.thegeoptapp.interfaces.RestorePositionAdapter;

import java.util.Objects;

public class CitiesFragment extends Fragment {
    private static final int MY_INTERNET_PERMISSION_CODE = 100;

    private CitiesViewModel citiesViewModel;
    private RecyclerView citiesFragmentRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        checkInternetPermission();

        citiesViewModel =
                new ViewModelProvider(this).get(CitiesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cities, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);

        //RecyclerView Creation
        citiesFragmentRecyclerView = root.findViewById(R.id.citiesRecyclerview);
        final CitiesListAdapter citiesListAdapter = new CitiesListAdapter(getContext());
        citiesFragmentRecyclerView.setAdapter(citiesListAdapter);
        citiesFragmentRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        citiesViewModel.getCities().observe(getViewLifecycleOwner(), citiesListAdapter::setCities);

        //Criacao de context menu para salvar cidades
        registerForContextMenu(citiesFragmentRecyclerView);

        return root;
    }

    //Para context menu 9: terminar de concluir o context menu, mas os itens ficam na fragment
    //Nao sei por que funciona te-lo aqui (ainda)
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int position = -1;
        try {
            position = ((RestorePositionAdapter) Objects.requireNonNull(citiesFragmentRecyclerView.getAdapter())).getPosition();

        } catch (Exception e){
            Toast.makeText(getContext(),"On Context Item Falhou", Toast.LENGTH_LONG).show();
        }
        switch (item.getItemId()){
            case R.id.favoriteCityContextMenuItem:
                if (citiesFragmentRecyclerView.findViewHolderForAdapterPosition(position) != null) {
                    Objects.requireNonNull(citiesFragmentRecyclerView.findViewHolderForAdapterPosition(position));
                    View mItem = Objects.requireNonNull(citiesFragmentRecyclerView.findViewHolderForAdapterPosition(position)).itemView;
                    if (citiesViewModel.favoriteCity(((TextView) mItem.findViewById(R.id.cityCardItemHeader)).getText().toString())) {
                        Toast.makeText(getContext(), "Cidade Salva: " + position, Toast.LENGTH_LONG).show();
                    }
                }
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


    private void checkInternetPermission(){
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.INTERNET}, MY_INTERNET_PERMISSION_CODE);
        }
    }
}