package com.ynov.tp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ynov.tp.bo.Cities;

import java.util.ArrayList;

public class ListCitiesViewModel extends ViewModel {
    MutableLiveData<ArrayList<Cities>> arrayListCities;

    public MutableLiveData<ArrayList<Cities>> getArrayListUsers() {
        if (arrayListCities == null) {
            this.arrayListCities = new MutableLiveData<>(new ArrayList<>());
        }
        return this.arrayListCities;
    }
}
