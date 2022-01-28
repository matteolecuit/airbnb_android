package com.ynov.tp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ynov.tp.bo.City;

import java.util.ArrayList;

public class ListCitiesViewModel extends ViewModel {
    MutableLiveData<ArrayList<City>> arrayListCities;

    public MutableLiveData<ArrayList<City>> getArrayListUsers() {
        if (arrayListCities == null) {
            this.arrayListCities = new MutableLiveData<>(new ArrayList<>());
        }
        return this.arrayListCities;
    }
}
