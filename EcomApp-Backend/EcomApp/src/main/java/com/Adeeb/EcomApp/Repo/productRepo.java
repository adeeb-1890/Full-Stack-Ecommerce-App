package com.Adeeb.EcomApp.Repo;

import com.Adeeb.EcomApp.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepo extends JpaRepository<Product, Integer> {


}
