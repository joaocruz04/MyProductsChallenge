package pt.joaocruz.myproductschallenge.products;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pt.joaocruz.myproductschallenge.R;
import pt.joaocruz.myproductschallenge.domain.Product;

/**
 * Created by joaocruz04 on 26/07/2017.
 */

public class GridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Product> products;
    private boolean endOfListReached;
    public static final int GRID_ITEM_TYPE = 1;
    public static final int FOOTER_TYPE = 2;

    public GridAdapter(ArrayList<Product> products) {
        this.products = products;
        this.endOfListReached = false;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int resID = viewType==GRID_ITEM_TYPE ? R.layout.grid_item : R.layout.grid_footer;
        View view = LayoutInflater.from(parent.getContext()).inflate(resID, null);
        RecyclerView.ViewHolder holder;
        if (viewType == GRID_ITEM_TYPE)
            holder = new ProductViewHolder(parent.getContext(), view);
        else
            holder = new FooterViewHolder(view);
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
        if (products==null)
            return 0;
        else
            return endOfListReached ? products.size() : products.size()+1;
    }

    public void update() {
        notifyDataSetChanged();
    }

    public void addProducts(List<Product> products) {
        if (this.products==null)
            this.products = new ArrayList<>(products);
        else
            this.products.addAll(products);

    }

    @Override
    public int getItemViewType(int position) {
        if (endOfListReached)
            return 1;
        else
            return (position == products.size() && position>0) ? 2 : 1;
    }

    public void setReachedEndOfList() {
        this.endOfListReached = true;
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
