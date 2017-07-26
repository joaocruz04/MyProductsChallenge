package pt.joaocruz.myproductschallenge.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import pt.joaocruz.myproductschallenge.online.OnlineDataManager;
import pt.joaocruz.myproductschallenge.online.RetrofitManager;

/**
 * Created by jcruz on 26.07.17.
 */


@Module
public class OnlineServicesModule {

    @Provides
    public OnlineDataManager provideOnlineDataManager(Context context) {
        return new RetrofitManager(context);
    }

}
