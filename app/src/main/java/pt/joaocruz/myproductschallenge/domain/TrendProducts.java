package pt.joaocruz.myproductschallenge.domain;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jcruz on 26.07.17.
 */

public class TrendProducts {

    public ArrayList<Product> products;
    @SerializedName("number_products")
    public long numberOfProducts;
    @SerializedName("number_pages")
    public int numberOfPages;
    @SerializedName("current_page")
    public int currentPage;

    public TrendProducts() {}
}
