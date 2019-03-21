package ca.smireault.shoppinglistapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.view.View;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<Product>> allProducts;
    private LiveData<List<Product>> productsByType;

    public ViewModel(Application application) {
        super(application);
        repository = new Repository(application);
    }

    public LiveData<List<Product>> getAllProducts() {
        allProducts = repository.getAllProducts();
        return allProducts;
    }

    public LiveData<List<Product>> getProductsByType(int type_id) {
        productsByType = repository.getProductsByType(type_id);
        return productsByType;
    }

    public void insert(Product product) {
        repository.insert(product);
    }
}
