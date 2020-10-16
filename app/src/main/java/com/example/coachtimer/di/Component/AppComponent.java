package com.example.coachtimer.di.Component;

import android.app.Application;

import com.example.coachtimer.BaseApplication;
import com.example.coachtimer.MainActivity;
import com.example.coachtimer.data.rest.PlayerRepository;
import com.example.coachtimer.di.Module.ActivityModule;
import com.example.coachtimer.di.Module.ApplicationModule;
import com.example.coachtimer.ui.detail.PlayerViewModel;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


//here we include all the modules that we tell the component to use
@Component(modules = {ActivityModule.class,AndroidSupportInjectionModule.class, ApplicationModule.class})
public interface AppComponent extends AndroidInjector<BaseApplication> {


    @Component.Builder
    interface Builder{

        @BindsInstance //binds an instance of a something will creating
        Builder application(Application application);

        AppComponent build();
    }

    void inject(PlayerViewModel playerViewModel);
    void inject(MainActivity mainActivity);
    void inject (PlayerRepository playerRepository);

}
