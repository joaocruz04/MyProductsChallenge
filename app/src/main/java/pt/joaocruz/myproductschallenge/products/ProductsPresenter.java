package pt.joaocruz.myproductschallenge.products;

import java.util.ArrayList;

import io.reactivex.Observer;

/**
 * Created by jcruz on 26.07.17.
 */

public abstract class ProductsPresenter {

    private ArrayList<Observer<?>> observers;

    protected void addObserver(Observer<?> observer) {
        if (observers == null)
            observers = new ArrayList<>();
        if (!observers.contains(observer))
            observers.add(observer);
    }

    protected ArrayList<Observer<?>> getObservers() {
        if (observers==null)
            observers = new ArrayList<>();
        return observers;
    }

    public abstract void registerView(ProductsView view);
    public abstract void loadMore();
    public abstract void unregisterView();

}
