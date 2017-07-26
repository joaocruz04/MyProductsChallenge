package pt.joaocruz.myproductschallenge.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jcruz on 26.07.17.
 */

public class ProductsResponse {

    @SerializedName("trend_products")
    TrendProducts trendProducts;

    public ProductsResponse() {}
}
