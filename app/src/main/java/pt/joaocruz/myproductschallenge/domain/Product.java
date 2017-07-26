package pt.joaocruz.myproductschallenge.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jcruz on 26.07.17.
 */

public class Product {

    long id;
    String name;
    String price;
    String msrp;
    String sku;
    @SerializedName("enabled_from")
    String enabledFrom;
    @SerializedName("show_msrp")
    String showMsrp;
    @SerializedName("show_msrp_index")
    int showMsrpIndex;
    int discount;
    @SerializedName("thumbnail_path")
    String thumbnailPath;

    public Product() {}


}
