package pt.joaocruz.myproductschallenge.dagger;

import javax.inject.Singleton;

import dagger.Component;
import pt.joaocruz.myproductschallenge.products.ProductsActivity;

/**
 * Created by jcruz on 26.07.17.
 */

@Singleton
@Component (modules = {AppModule.class, OnlineServicesModule.class, PresentersModule.class, SchedulersModule.class} )
public interface AppComponent {

    void inject(ProductsActivity activity);

}
