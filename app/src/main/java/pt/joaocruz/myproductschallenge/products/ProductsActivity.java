package pt.joaocruz.myproductschallenge.products;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import javax.inject.Inject;

import pt.joaocruz.myproductschallenge.App;
import pt.joaocruz.myproductschallenge.R;
import pt.joaocruz.myproductschallenge.domain.TrendProducts;


public class ProductsActivity extends AppCompatActivity implements ProductsView {

    @Inject
    ProductsPresenter presenter;

    private RecyclerView recyclerView;
    private GridAdapter adapter;
    private FooterGridLayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        App.getInstance(this).getAppComponent().inject(this);
        presenter.registerView(this);
    }

    @Override
    public void updateWithProducts(TrendProducts trendProducts) {
        if (adapter==null) {
            adapter = new GridAdapter(trendProducts.products);
            layoutManager = new FooterGridLayoutManager(this, 2, adapter);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.addItemDecoration(new GridAdapter.GridItemDecorator(10)); // Improvement: calculate from dip.
            if (trendProducts.currentPage == trendProducts.numberOfPages-1)
                adapter.setReachedEndOfList();
            recyclerView.setAdapter(adapter);
            recyclerView.addOnScrollListener(scrollListener);
        } else {
            if (trendProducts.currentPage == trendProducts.numberOfPages-1)
                adapter.setReachedEndOfList();
            adapter.addProducts(trendProducts.products);
            adapter.update();
        }
    }

    RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            int visibleItemCount = layoutManager.getChildCount();
            int totalItemCount = layoutManager.getItemCount();
            int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();
            if (((pastVisibleItems + visibleItemCount) >= totalItemCount-4) && !presenter.isLoading()) {
                presenter.loadMore();
            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        presenter.loadMore();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unregisterView();
    }


}
