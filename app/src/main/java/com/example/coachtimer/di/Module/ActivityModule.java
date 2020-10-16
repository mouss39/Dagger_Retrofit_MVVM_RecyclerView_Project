package com.example.coachtimer.di.Module;

import com.example.coachtimer.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    //here I till that the MainActivity is a potential client

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
    //main activity is a potential client that I can inject dependencies
    //if you have other activities we should add them here




}
