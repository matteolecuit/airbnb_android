package com.ynov.tp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ynov.tp.bo.User;

import java.util.ArrayList;

public class ListUsersViewModel extends ViewModel {
    MutableLiveData<ArrayList<User>> arrayListUsers;

    public MutableLiveData<ArrayList<User>> getArrayListUsers() {
        if (arrayListUsers == null) {
            this.arrayListUsers = new MutableLiveData<>(new ArrayList<>());
        }
        return this.arrayListUsers;
    }
}
