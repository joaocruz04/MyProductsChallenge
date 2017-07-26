package pt.joaocruz.myproductschallenge.dagger;

import javax.inject.Singleton;

import dagger.Component;
import pt.joaocruz.myproductschallenge.feed.FeedActivity;

/**
 * Created by jcruz on 26.07.17.
 */

@Singleton
@Component (modules = {AppModule.class, UseCaseModule.class, OnlineServicesModule.class} )
public interface AppComponent {

    void inject(FeedActivity activity);

}
