package com.thelion.thegeoptapp.ui.about;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.thelion.thegeoptapp.R;

public class AboutFragment extends Fragment {

    private ImageView logoImageView;

    private AboutViewModel aboutViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aboutViewModel =
                new ViewModelProvider(this).get(AboutViewModel.class);
        View root = inflater.inflate(R.layout.fragment_about, container, false);

        //List of interface components
        final TextView textView = root.findViewById(R.id.text_notifications);
        logoImageView = root.findViewById(R.id.logoImage);

        //MVVM Observer
        aboutViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // Button click listeners
        logoImageView.setOnClickListener(view -> Toast.makeText(getContext(),aboutViewModel.getAGreeting(), Toast.LENGTH_SHORT).show());

        // link clickable
        TextView geoptlinkTextView = (TextView) root.findViewById(R.id.aboutApiLinktextView);
        geoptlinkTextView.setMovementMethod(LinkMovementMethod.getInstance());


        return root;
    }
}