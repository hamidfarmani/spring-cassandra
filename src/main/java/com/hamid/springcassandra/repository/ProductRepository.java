package com.hamid.springcassandra.repository;


import com.hamid.springcassandra.model.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CassandraRepository<Product, Integer> {
}
