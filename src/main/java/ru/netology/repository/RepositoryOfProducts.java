package ru.netology.repository;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.AlreadyExistsException;
import ru.netology.exception.NotFoundException;

import java.rmi.AlreadyBoundException;

public class RepositoryOfProducts {
    protected Product[] products = new Product[0];
    public void save(Product product) {
        for (Product product1 : products) {
            if (product1.getId() == product.getId()) {
                throw new AlreadyExistsException("Element with id: " + product1.getId() + " already exist");
            }
        }
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }

    public Product[] getAll() {
        return products;
    }

    public void deleteById(int id) {
        findById(id);
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int length = products.length - 1;
        Product[] result = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                result[index] = product;
                index++;
            }
        }
        products = result;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

}
