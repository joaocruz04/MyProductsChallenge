package pt.joaocruz.myproductschallenge.dagger;

import dagger.Module;
import dagger.Provides;
import pt.joaocruz.myproductschallenge.products.ProductsPresenter;
import pt.joaocruz.myproductschallenge.products.ProductsPresenterImpl;

/**
 * Created by joaocruz04 on 26/07/2017.
 */

@Module
public class PresentersModule {

    @Provides
    public ProductsPresenter providesFeedPresenter(ProductsPresenterImpl feedPresenter) {
        return feedPresenter;
    }

}
