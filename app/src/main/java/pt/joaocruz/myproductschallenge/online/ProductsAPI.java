package pt.joaocruz.myproductschallenge.online;



import io.reactivex.Observable;
import pt.joaocruz.myproductschallenge.domain.TrendProducts;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jcruz on 26.07.17.
 */

public interface ProductsAPI {

    @GET("/trendproducts")
    Observable<TrendProducts> getProductsAtPage(
            @Query("app_token") String appToken,
            @Query("user_token") String userToken,
            @Query("store_id") int storeID,
            @Query("page_override") int page);

}


/*

https://test4.lesara.de/restapi/v1/trendproducts/?app_token=this_is_an_app_token&user_token=63a12a8116814a9574842515378c93c64846fc3d0858def78388be37e127cd17&store_id=1&page_override=


 */