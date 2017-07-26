package pt.joaocruz.myproductschallenge.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import pt.joaocruz.myproductschallenge.domain.TrendProducts;
import pt.joaocruz.myproductschallenge.online.OnlineDataManager;

/**
 * Created by jcruz on 26.07.17.
 */

public class GetProductsUseCase {

    private OnlineDataManager dataManager;
    private int page = 0;
    private Scheduler mainScheduler;
    private Scheduler newThreadScheduler;

    @Inject
    public GetProductsUseCase(OnlineDataManager dataManager, Scheduler mainScheduler, Scheduler newThreadScheduler) {
        this.dataManager = dataManager;
        this.mainScheduler = mainScheduler;
        this.newThreadScheduler = newThreadScheduler;
    }

    public GetProductsUseCase withPage(int page) {
        this.page = page;
        return this;
    }

    public Observable<TrendProducts> build() {
        return this.dataManager
                .getProductsAtPage(page)
                .subscribeOn(newThreadScheduler)
                .observeOn(mainScheduler);
    }


}
