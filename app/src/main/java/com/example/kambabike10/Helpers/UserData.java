package com.example.kambabike10.Helpers;

import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import java.util.Set;

public class UserData {

    public UserData(SharedPreferences.Editor editor) {
        this.editor = editor;
    }

    SharedPreferences.Editor editor;
}
