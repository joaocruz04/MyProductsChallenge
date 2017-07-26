package pt.joaocruz.myproductschallenge;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import pt.joaocruz.myproductschallenge.domain.Product;
import pt.joaocruz.myproductschallenge.domain.ProductsResponse;
import pt.joaocruz.myproductschallenge.domain.TrendProducts;
import pt.joaocruz.myproductschallenge.online.OnlineDataManager;
import pt.joaocruz.myproductschallenge.usecase.GetProductsUseCase;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by joaocruz04 on 26/07/2017.
 */

public class GetProductsUseCaseTest {

    GetProductsUseCase useCase;

    @Before
    public void setup() {
        OnlineDataManager dm = mock(OnlineDataManager.class);
        when(dm.getProductsAtPage(0)).thenReturn(getValidResponse());
        when(dm.getProductsAtPage(3333)).thenReturn(getInvalidPageResponse());
        useCase = new GetProductsUseCase(dm, Schedulers.trampoline(), Schedulers.trampoline());
    }

    @Test
    public void testValidResponse() {
        List<ProductsResponse> result = useCase.withPage(0).build().toList().blockingGet();
        assertNotNull(result);
        assertEquals(result.size(), 1);
        ProductsResponse response = result.get(0);
        assertNotNull(response.trendProducts);
        assertNotNull(response.trendProducts.products);
        assertEquals(response.trendProducts.products.size(), 1);
        assertEquals(response.trendProducts.products.get(0).name, "product1");
    }

    @Test
    public void testInvalidPageResponse() {
        List<ProductsResponse> result = useCase.withPage(3333).build().toList().blockingGet();
        assertNotNull(result);
        assertEquals(result.size(), 1);
        ProductsResponse response = result.get(0);
        assertNotNull(response.trendProducts);
        assertNotNull(response.trendProducts.products);
        assertEquals(response.trendProducts.products.size(), 0);
        assertEquals(response.trendProducts.currentPage, 3333);
    }


    // Helpers
    public Observable<ProductsResponse> getValidResponse() {
        ProductsResponse response = new ProductsResponse();
        response.trendProducts = new TrendProducts();
        response.trendProducts.products = new ArrayList<>();
        Product product = new Product();
        product.name = "product1";
        response.trendProducts.products.add(product);
        return Observable.just(response);
    }

    public Observable<ProductsResponse> getInvalidPageResponse() {
        ProductsResponse response = new ProductsResponse();
        response.trendProducts = new TrendProducts();
        response.trendProducts.products = new ArrayList<>();
        response.trendProducts.currentPage = 3333;
        response.trendProducts.numberOfPages = 300;
        return Observable.just(response);
    }

}
