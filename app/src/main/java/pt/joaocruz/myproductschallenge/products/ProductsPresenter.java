package pt.joaocruz.myproductschallenge.products;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by jcruz on 26.07.17.
 */

public abstract class ProductsPresenter {

    private CompositeDisposable compositeDisposable;

    protected void addObserver(Disposable observer) {
        if (compositeDisposable == null)
            compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(observer);
    }

    protected void unregisterObservers() {
        if (compositeDisposable!=null)
            compositeDisposable.clear();
    }

    public abstract void registerView(ProductsView view);
    public abstract void loadMore();
    public abstract void unregisterView();
    public abstract boolean isLoading();

}
