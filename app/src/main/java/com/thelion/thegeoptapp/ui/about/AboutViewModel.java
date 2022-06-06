package com.thelion.thegeoptapp.ui.about;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.thelion.thegeoptapp.utilities.GeneralUtilities;

import java.util.Random;

public class AboutViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AboutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public String getAGreeting() {
        String [] greetings = GeneralUtilities.getGrettings();
        return greetings[new Random().nextInt(greetings.length)];
    }
}