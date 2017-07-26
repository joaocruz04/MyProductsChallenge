package pt.joaocruz.myproductschallenge.products;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import pt.joaocruz.myproductschallenge.domain.ProductsResponse;
import pt.joaocruz.myproductschallenge.usecase.GetProductsUseCase;

/**
 * Created by jcruz on 26.07.17.
 */

public class ProductsPresenterImpl extends ProductsPresenter {

    private GetProductsUseCase productsUseCase;
    private int currentPage;
    private ProductsView view;

    @Inject
    public ProductsPresenterImpl(GetProductsUseCase productsUseCase) {
        this.productsUseCase = productsUseCase;
        currentPage = 0;
    }

    @Override
    public void registerView(ProductsView view) {
        this.view = view;
    }

    @Override
    public void unregisterView() {
        this.view = null;
    }

    @Override
    public void loadMore() {
        Observer<ProductsResponse> observer = new Observer<ProductsResponse>(){

            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("SUBSCRIBE");
            }

            @Override
            public void onNext(ProductsResponse productsResponse) {
                if (view!=null) {
                    view.updateWithProducts(productsResponse.trendProducts);
                }
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("ERROR");
            }

            @Override
            public void onComplete() {
                System.out.println("COMPLETE");
            }
        };

        productsUseCase.withPage(currentPage).build().subscribe(observer);

    }




}
