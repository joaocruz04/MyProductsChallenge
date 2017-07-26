package pt.joaocruz.myproductschallenge.domain;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jcruz on 26.07.17.
 */

public class TrendProducts {

    ArrayList<Product> products;
    @SerializedName("number_products")
    long numberOfProducts;
    @SerializedName("number_pages")
    int numberOfPages;
    @SerializedName("current_page")
    int currentPage;

    public TrendProducts() {}
}
