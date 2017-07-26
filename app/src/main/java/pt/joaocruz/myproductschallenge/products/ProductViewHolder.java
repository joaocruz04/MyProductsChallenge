package pt.joaocruz.myproductschallenge.products;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

import pt.joaocruz.myproductschallenge.R;
import pt.joaocruz.myproductschallenge.domain.Product;

/**
 * Created by joaocruz04 on 26/07/2017.
 */

public class ProductViewHolder extends ViewHolder {

    private ImageView image;
    private TextView title;
    private TextView price;
    private Context context;

    public ProductViewHolder(Context context, View itemView) {
        super(itemView);
        this.context = context;
        image = itemView.findViewById(R.id.image);
        title = itemView.findViewById(R.id.title);
        price = itemView.findViewById(R.id.price);
    }

    public void bindProduct(Product product) {
        setTitle(product.name);
        // Because image base URL should come from a service, I'm not putting
        // it in the resources strings.xml
        setImage("https://daol3a7s7tps6.cloudfront.net/" + product.thumbnailPath);
        setPrice(product.price);
    }

    public void setTitle(String title) {
        this.title.setText(title!=null?title:"");
    }

    public void setImage(String imagePath) {
        Picasso.with(context).load(imagePath).into(this.image);
    }

    public void setPrice(String price) {
        float value;
        try {
            value = Float.valueOf(price);
        } catch (NumberFormatException e) {value = -1;}
        this.price.setText(new DecimalFormat("#.##").format(value) + " €");
    }

}
