package pt.joaocruz.myproductschallenge.feed;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import pt.joaocruz.myproductschallenge.domain.TrendProducts;
import pt.joaocruz.myproductschallenge.usecase.GetProductsUseCase;

/**
 * Created by jcruz on 26.07.17.
 */

public class FeedPresenterImpl extends FeedPresenter {

    private GetProductsUseCase productsUseCase;
    private int currentPage;
    private FeedView view;

    public FeedPresenterImpl(GetProductsUseCase productsUseCase) {
        this.productsUseCase = productsUseCase;
        currentPage = 0;
    }

    public void registerView(FeedView view) {
        this.view = view;
    }

    public void unregisterView() {
        this.view = null;

    }


    private void loadMore() {

        Disposable disposable = productsUseCase.withPage(currentPage).build().subscribe(new Consumer<TrendProducts>() {
            @Override
            public void accept(@NonNull TrendProducts trendProducts) throws Exception {

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {

            }
        });
        

        /*
        productsUseCase.withPage(currentPage).build().subscribe(new Observer<TrendProducts>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TrendProducts trendProducts) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                currentPage++;
            }
        });
        */
    }




}
