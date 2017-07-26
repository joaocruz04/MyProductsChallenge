package pt.joaocruz.myproductschallenge.products;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import pt.joaocruz.myproductschallenge.domain.Product;
import pt.joaocruz.myproductschallenge.domain.ProductsResponse;
import pt.joaocruz.myproductschallenge.domain.TrendProducts;
import pt.joaocruz.myproductschallenge.usecase.GetProductsUseCase;

/**
 * Created by jcruz on 26.07.17.
 */

public class ProductsPresenterImpl extends ProductsPresenter {

    private GetProductsUseCase productsUseCase;
    private int currentPage;
    private ProductsView view;
    private boolean loading;

    @Inject
    public ProductsPresenterImpl(GetProductsUseCase productsUseCase) {
        this.productsUseCase = productsUseCase;
        currentPage = 1;
        loading = false;
    }

    @Override
    public void registerView(ProductsView view) {
        this.view = view;
    }

    @Override
    public void unregisterView() {
        this.view = null;
        unregisterObservers();
    }

    @Override
    public void loadMore() {
        if (!loading) {
            loading = true;
            Observer<ProductsResponse> observer = new Observer<ProductsResponse>() {

                private TrendProducts products;

                @Override
                public void onSubscribe(Disposable d) {
                    addObserver(d);
                }

                @Override
                public void onNext(ProductsResponse productsResponse) {
                    if (view != null
                            && productsResponse != null
                            && productsResponse.trendProducts != null) {
                        products = productsResponse.trendProducts;
                    }
                }

                @Override
                public void onError(Throwable e) {loading = false;}

                @Override
                public void onComplete() {
                    view.updateWithProducts(products);
                    currentPage = products.currentPage+1;
                    loading = false;
                }
            };
            productsUseCase.withPage(currentPage).build().subscribe(observer);
        }

    }

    @Override
    public boolean isLoading() {
        return loading;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public ProductsView getView() {
        return view;
    }
}
