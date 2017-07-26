package pt.joaocruz.myproductschallenge.dagger;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import pt.joaocruz.myproductschallenge.dagger.qualifiers.MainThreadScheduler;
import pt.joaocruz.myproductschallenge.dagger.qualifiers.NewThreadScheduler;

/**
 * Created by jcruz on 26.07.17.
 */


@Module
public class SchedulersModule {

    @Provides
    @NewThreadScheduler
    public Scheduler providesNewThreadScheduler() {
        return Schedulers.newThread();
    }

    @Provides
    @MainThreadScheduler
    public Scheduler providesMainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }


}
