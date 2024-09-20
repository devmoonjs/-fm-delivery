package com.sparta.fmdelivery.domain.shop.repository;

import com.sparta.fmdelivery.domain.shop.entitiy.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findAllByUserId(Long id);
}