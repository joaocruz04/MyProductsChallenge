package pt.joaocruz.myproductschallenge.products;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pt.joaocruz.myproductschallenge.R;
import pt.joaocruz.myproductschallenge.domain.Product;

/**
 * Created by joaocruz04 on 26/07/2017.
 */

public class GridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Product> products;

    public GridAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, null);
        ProductViewHolder holder = new ProductViewHolder(parent.getContext(), view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ProductViewHolder){
            ((ProductViewHolder) holder).bindProduct(products.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return products!=null ? products.size() : 0;
    }

    public void update() {
        notifyDataSetChanged();
    }

    public void addProducts(ArrayList<Product> products) {
        if (this.products!=null)
            this.products = products;
        else
            this.products.addAll(products);

    }

    static class GridItemDecorator extends RecyclerView.ItemDecoration {

        private int margin = 0;

        public GridItemDecorator(int margin) {
            this.margin = margin;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = margin;
            outRect.right = margin;
            outRect.bottom = margin;
            outRect.top = margin;

        }
    }
}
