package pt.joaocruz.myproductschallenge.online;

import io.reactivex.Observable;
import pt.joaocruz.myproductschallenge.domain.TrendProducts;

/**
 * Created by jcruz on 26.07.17.
 */

public interface OnlineDataManager {

    Observable<TrendProducts> getProductsAtPage(int page);
}
