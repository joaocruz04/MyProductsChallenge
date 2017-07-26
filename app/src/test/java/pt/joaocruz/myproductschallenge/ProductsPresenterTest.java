package pt.joaocruz.myproductschallenge;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Any;

import java.util.ArrayList;

import io.reactivex.Observable;
import pt.joaocruz.myproductschallenge.domain.Product;
import pt.joaocruz.myproductschallenge.domain.ProductsResponse;
import pt.joaocruz.myproductschallenge.domain.TrendProducts;
import pt.joaocruz.myproductschallenge.products.ProductsPresenterImpl;
import pt.joaocruz.myproductschallenge.products.ProductsView;
import pt.joaocruz.myproductschallenge.usecase.GetProductsUseCase;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by joaocruz04 on 26/07/2017.
 */

public class ProductsPresenterTest {

    ProductsPresenterImpl presenter;

    @Before
    public void setup() {
        GetProductsUseCase useCase = mock(GetProductsUseCase.class);
        ProductsView view = mock(ProductsView.class);
        when(useCase.withPage(anyInt())).thenReturn(useCase);
        when(useCase.build()).thenReturn(getValidResponse());
        presenter = new ProductsPresenterImpl(useCase);
        presenter.registerView(view);
    }

    @Test
    public void testCurrentPage() {
        assertEquals(presenter.getCurrentPage(), 1);
        presenter.loadMore();
        assertEquals(presenter.getCurrentPage(), 2);
    }

    @Test
    public void testViewGetsUpdate() {
        presenter.loadMore();
        verify(presenter.getView(), times(1)).updateWithProducts(any(TrendProducts.class));
    }


    // Helper

    public Observable<ProductsResponse> getValidResponse() {
        ProductsResponse response = new ProductsResponse();
        response.trendProducts = new TrendProducts();
        response.trendProducts.products = new ArrayList<>();
        Product product = new Product();
        product.name = "product1";
        response.trendProducts.products.add(product);
        response.trendProducts.currentPage = 1;
        return Observable.just(response);
    }
}
