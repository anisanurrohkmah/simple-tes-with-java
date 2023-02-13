package com.enigma.example.repository;
import com.enigma.example.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {
    Page<Customer> findAll(Pageable pageable);
}

//@Repository
//public interface ProductRepository extends JpaRepository<Product, String> {
//    Page<Product> findAll(Pageable pageable);
//    @Query(value = "SELECT * from mst_product p where p.stock < 5", nativeQuery = true)
//    List<Product> findProductMinStock();
//}
