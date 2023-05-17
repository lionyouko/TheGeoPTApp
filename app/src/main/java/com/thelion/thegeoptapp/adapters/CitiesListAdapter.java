package com.thelion.thegeoptapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonObject;
import com.thelion.thegeoptapp.CityDetailsActivity;
import com.thelion.thegeoptapp.R;
import com.thelion.thegeoptapp.api.GeoPTService;
import com.thelion.thegeoptapp.api.ServiceProvider;
import com.thelion.thegeoptapp.interfaces.RestorePositionAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CitiesListAdapter extends RecyclerView.Adapter<CitiesListAdapter.CitiesViewHolder> implements RestorePositionAdapter {

    private final LayoutInflater layoutInflater;

    //May need to be refactored later on to be a pojo object
    //if it happens to implement call for each city so the card can show more
    private List<String> citiesList;
    private Context c;

    //Para context menu 0
    private int position;

    //It is very unfortunate to have ta Service class here, it needs to be put in the viewModel from the citiesFragment
    //I need to check how to do it and refactor, or make service provider class singleton
    ServiceProvider<GeoPTService> geoptservice = new ServiceProvider<>(GeoPTService.class);


    public CitiesListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        this.c = context;

    }

    @NonNull
    @Override
    public CitiesListAdapter.CitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.cities_recyclerview_item, parent, false);
        return new CitiesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CitiesListAdapter.CitiesViewHolder holder, int position) {
        if (this.citiesList != null) {
            String currentCity = citiesList.get(position);
            holder.citiesName.setText(currentCity);

            //Here we can put the remaining stuff later on filling the other parts
            //of the cards (see how there are parts commented about the card)
            //GeneralUtilities.setLinearLayoutColor(holder.CityCardItemLinearLayout, "PT");

            //Para context menu 11: agora salvar o id num textView invisivel
            holder.cityId.setText(String.valueOf(currentCity));
        }


        //Para context menu 6
        holder.itemView.setOnLongClickListener(v -> {
            setPosition(holder.getAdapterPosition());
            return false;
        });

    }
    //Para context menu 5
    public void setPosition(int position) {
        //Log.d("layout position>>",String.valueOf(position));
        this.position = position;
    }

    @Override
    public int getItemCount() {
        if (citiesList != null) {
            //Because can be not null, but size = 0
            return citiesList.size();
        } else
            return 0;
    }

    //Para context menu 7: tirar o click listener dos antigos items para nao gastar memoria, vazar memoria
    @Override
    public void onViewRecycled(@NonNull CitiesViewHolder holder) {
        holder.itemView.setOnLongClickListener(null);
        super.onViewRecycled(holder);
    }

    @Override
    public int getPosition() {
        return position;
    }


    // Implements onclick listener to make elements inside clickable
    class CitiesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener {

        private final TextView citiesName;
        private final TextView cityId;
        //        private final TextView citiesEmail;
        //        private final TextView citiesPhone;
        //        private final TextView citiesLocation;
        private final LinearLayout CityCardItemLinearLayout;


        private CitiesViewHolder(View itemView) {
            super(itemView);
            citiesName = itemView.findViewById(R.id.cityCardItemHeader);
            cityId = itemView.findViewById(R.id.placeHolderViewModelItemId);

//            citiesEmail = itemView.findViewById(R.id.cityEmailCardItemTextView);
//            citiesPhone = itemView.findViewById(R.id.cityPhoneCardItemTextView);
//            citiesLocation = itemView.findViewById(R.id.cityLocationCardItemTextView);
            CityCardItemLinearLayout = itemView.findViewById(R.id.cityCardLinearLayout);

            // Set the listener to the clickable card
            itemView.setOnClickListener(this);

            // Set the listener to the contextable card
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onClick(View view) {
            int positionClicked = getLayoutPosition();
            String cityClicked = citiesList.get(positionClicked);

            apiCallGetACity(geoptservice, cityClicked);


        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, @NonNull View view, @Nullable ContextMenu.ContextMenuInfo contextMenuInfo) {
            menu.add(Menu.NONE,R.id.favoriteCityContextMenuItem, Menu.NONE,"Salvar Cidade Nos Favoritos?");
        }
    }

    public void setCities(List<String> cities) {
        this.citiesList = cities;
        notifyDataSetChanged();
    }




    private void apiCallGetACity(ServiceProvider<GeoPTService> serviceProvider, String cityName) {


        Call<JsonObject> getACityCall = ((GeoPTService) serviceProvider.provide()).getACity(cityName);
        getACityCall.enqueue(new Callback<JsonObject>() {

            @Override
            public void onResponse(@NotNull Call<JsonObject> call, @NotNull Response<JsonObject> response) {

                if (response.body() != null) {

                    JsonObject resp = response.body().getAsJsonObject();
                    showCityDetails(resp);
                } else {
                    Toast.makeText(c, "A cidade não tem detalhes a mostrar.", Toast.LENGTH_SHORT).show();
                    Log.d("APICALL GETCITY", "The geoptapi call get a city returned nothing, a null object.");
                }
            }

            @Override
            public void onFailure(@NotNull Call<JsonObject> call, @NotNull Throwable t) {
                Log.e("API Call error: ", t.getMessage());
            }
        });

    }

    private void showCityDetails(JsonObject apiResponseCity) {
        Intent cityDetailsActivityIntent = new Intent(c, CityDetailsActivity.class);
        // I am putting the entire json object here as a String for the activity, and there we need
        // to make it json object again and extract each field.
        // That is for not use sharedprefs or such.

        // We should give the result back, and in onCLick them to call a a new intent.
        cityDetailsActivityIntent.putExtra("cityinfo", apiResponseCity.toString());

        c.startActivity(cityDetailsActivityIntent);
    }


}
