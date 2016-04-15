package com.example.talizorah.finalapp.ConnectionChecker;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by talizorah on 16.11.4.
 */
public class ConnectionChecker {
    public static boolean isNetworkAvailable(Activity context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
}

