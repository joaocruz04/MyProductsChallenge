package pt.joaocruz.myproductschallenge.products;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import pt.joaocruz.myproductschallenge.App;
import pt.joaocruz.myproductschallenge.R;
import pt.joaocruz.myproductschallenge.domain.TrendProducts;


public class ProductsActivity extends AppCompatActivity implements ProductsView {

    @Inject
    ProductsPresenter presenter;

    private RecyclerView recyclerView;
    private GridAdapter adapter;

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
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            recyclerView.addItemDecoration(new GridAdapter.GridItemDecorator(10)); // Improvement: calculate from dip.
            recyclerView.setAdapter(adapter);
        } else {
            adapter.addProducts(trendProducts.products);
            adapter.update();
        }
    }

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
