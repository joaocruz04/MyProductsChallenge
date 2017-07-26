package pt.joaocruz.myproductschallenge;

import android.app.Application;
import android.content.Context;

import pt.joaocruz.myproductschallenge.dagger.AppComponent;
import pt.joaocruz.myproductschallenge.dagger.AppModule;
import pt.joaocruz.myproductschallenge.dagger.DaggerAppComponent;
import pt.joaocruz.myproductschallenge.dagger.OnlineServicesModule;
import pt.joaocruz.myproductschallenge.dagger.PresentersModule;
import pt.joaocruz.myproductschallenge.dagger.SchedulersModule;
import pt.joaocruz.myproductschallenge.dagger.UseCaseModule;

/**
 * Created by jcruz on 26.07.17.
 */

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .useCaseModule(new UseCaseModule())
                .onlineServicesModule(new OnlineServicesModule())
                .presentersModule(new PresentersModule())
                .schedulersModule(new SchedulersModule())
                .build();


    }


    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static App getInstance(Context context) {
        return (App) context.getApplicationContext();
    }


}
