package com.sparta.fmdelivery.domain.shop.repository;

import com.sparta.fmdelivery.domain.shop.entitiy.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findAllByUserId(Long id);

    // 광고가 활성화된 가게 조회
    @Query("SELECT s FROM Shop s JOIN Ads a ON s.id = a.shopId WHERE a.status = true")
    List<Shop> findAdShops();
    // 광고가 없는 가게 조회
    @Query("SELECT s FROM Shop s WHERE s.id NOT IN (SELECT a.shopId FROM Ads a WHERE a.status = true)")
    List<Shop> findRegularShops();


}
