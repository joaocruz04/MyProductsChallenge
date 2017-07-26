package pt.joaocruz.myproductschallenge.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jcruz on 26.07.17.
 */

public class Product {

    public long id;
    public String name;
    public String price;
    public String msrp;
    public String sku;
    @SerializedName("enabled_from")
    public String enabledFrom;
    @SerializedName("show_msrp")
    public String showMsrp;
    @SerializedName("show_msrp_index")
    public int showMsrpIndex;
    public int discount;
    @SerializedName("thumbnail_path")
    public String thumbnailPath;

    public Product() {}


}
