package com.example.coachtimer;


import com.example.coachtimer.di.Component.AppComponent;
import com.example.coachtimer.di.Component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class BaseApplication extends DaggerApplication {
    private AppComponent appComponent;
    @Override

    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        //this where I will return my Appcomponent

        //application is the binding instance already mention in the AppComponent
        appComponent=DaggerAppComponent.builder().application(this).build();
        return  appComponent;
    }
    public AppComponent getAppComponent() {
        return appComponent;
    }
}
