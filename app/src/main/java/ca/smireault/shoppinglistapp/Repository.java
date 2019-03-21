package ca.smireault.shoppinglistapp;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class Repository {
    private static Application application;
    private ProductDao productDao;
    private TypeDao typeDao;
    private LiveData<List<Product>> allProducts;
    private LiveData<List<Product>> productsByType;
    private AppRoomDatabase db;


    public Repository(Application application) {
        db = AppRoomDatabase.getInstance(application);
        productDao = db.productDao();
        typeDao = db.typeDao();
    }

    public LiveData<List<Product>> getAllProducts() {
        allProducts = productDao.getAllProducts();
        return this.allProducts;
    }

    public LiveData<List<Product>> getProductsByType(int type_id) {
        productsByType = productDao.getProductByType(type_id);
        return this.productsByType;
    }

    public void insert (Product product) {
        new insertAsyncTask(productDao).execute(product);
    }

    private static class insertAsyncTask extends AsyncTask<Product, Void, Void> {
        private ProductDao asyncTaskDao;

        insertAsyncTask(ProductDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            asyncTaskDao.insert(products[0]);
            return null;
        }
    }

}
