package pt.joaocruz.myproductschallenge.online;



import io.reactivex.Observable;
import pt.joaocruz.myproductschallenge.domain.ProductsResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jcruz on 26.07.17.
 */

public interface ProductsAPI {

    @GET("trendproducts")
    Observable<ProductsResponse> getProductsAtPage(
            @Query("app_token") String appToken,
            @Query("user_token") String userToken,
            @Query("store_id") int storeID,
            @Query("page_override") int page);

}
