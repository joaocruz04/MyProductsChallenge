package pt.joaocruz.myproductschallenge.products;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

/**
 * Created by joaocruz04 on 26/07/2017.
 */

public class FooterGridLayoutManager extends GridLayoutManager {

    private GridAdapter adapter;

    public FooterGridLayoutManager(Context context, int spanCount, final GridAdapter adapter) {
        super(context, spanCount);
        this.adapter = adapter;
        setSpanSizeLookup(new SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (adapter.getItemViewType(position)) {
                    case GridAdapter.GRID_ITEM_TYPE:
                        return 1;
                    case GridAdapter.FOOTER_TYPE:
                        return 2;
                    default:
                        return -1;
                }
            }
        });
    }

}
