package com.example.coachtimer.di.Module;

import com.example.coachtimer.data.rest.PlayerService;
import com.example.coachtimer.data.rest.PlayerRepository;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {
    //this Module will include all the dependencies that will remain all the lifetime on the app
    //for example retrofit that is why it is not a abstract

    private static final String BASE_URL = "https://randomuser.me/";

    //api/?\n" + "seed=empatica&inc=name,picture&gender=male&results=10&noinfo"



    @Provides
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }



    @Provides
    static PlayerService provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(PlayerService.class);
    }


@Provides
static PlayerRepository providePlayerService(PlayerService playerService) {
    return new PlayerRepository(playerService);
}


}
