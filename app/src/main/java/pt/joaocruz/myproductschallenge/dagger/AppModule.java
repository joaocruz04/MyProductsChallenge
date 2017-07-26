package pt.joaocruz.myproductschallenge.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jcruz on 26.07.17.
 */


@Module
public class AppModule {

    private Context appContext;

    public AppModule(Context appContext) {
        this.appContext = appContext;
    }


    @Provides
    public Context provideAppContext() {
        return appContext;
    }


}
