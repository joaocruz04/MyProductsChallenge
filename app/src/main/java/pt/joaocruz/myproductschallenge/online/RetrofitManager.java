package pt.joaocruz.myproductschallenge.online;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Inject;

import io.reactivex.Observable;
import pt.joaocruz.myproductschallenge.R;
import pt.joaocruz.myproductschallenge.domain.TrendProducts;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jcruz on 26.07.17.
 */

public class RetrofitManager implements OnlineDataManager {

    private Retrofit retrofit;
    private ProductsAPI api;

    @Inject
    public RetrofitManager(Context context) {
        Retrofit.Builder builder = new Retrofit.Builder();
        retrofit = builder
                .baseUrl(context.getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(ProductsAPI.class);
    }

    @Override
    public Observable<TrendProducts> getProductsAtPage(int page) {
        String apptoken = "this_is_an_app_token";
        String usertoken = "63a12a8116814a9574842515378c93c64846fc3d0858def78388be37e127cd17";
        int storeID = 1;
        return api.getProductsAtPage(apptoken, usertoken, storeID, page);
    }
}
