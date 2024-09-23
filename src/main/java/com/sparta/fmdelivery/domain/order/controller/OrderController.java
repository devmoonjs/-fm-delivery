package com.sparta.fmdelivery.domain.order.controller;

import com.sparta.fmdelivery.apipayload.ApiResponse;
import com.sparta.fmdelivery.domain.common.annotation.Auth;
import com.sparta.fmdelivery.domain.common.dto.AuthUser;
import com.sparta.fmdelivery.domain.order.dto.request.OrderRequest;
import com.sparta.fmdelivery.domain.order.dto.response.OrderDetailResponse;
import com.sparta.fmdelivery.domain.order.dto.response.OrderListResponse;
import com.sparta.fmdelivery.domain.order.dto.response.OrderResponse;
import com.sparta.fmdelivery.domain.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    // 사용자 - 주문 요청
    @PostMapping
    public ApiResponse<OrderResponse> createOrder(@Auth AuthUser authUser,
                                                  @RequestBody OrderRequest orderRequest) {
        return ApiResponse.onSuccess(orderService.saveOrder(authUser, orderRequest));
    }

    // 사장 - 주문 수락
    @PatchMapping("/{orderId}")
    public ApiResponse<OrderResponse> acceptOrder(@Auth AuthUser authUser,
                                                     @PathVariable Long orderId) {
        return ApiResponse.onSuccess(orderService.updateOrder(authUser, orderId));
    }

    // 주문 목록 조회
    @GetMapping
    public ApiResponse<List<OrderListResponse>> getAllOrders(@Auth AuthUser authUser) {
        return ApiResponse.onSuccess(orderService.getAllOrders(authUser));
    }

    // 주문 상세 조회
    @GetMapping("/{orderId}")
    public ApiResponse<OrderDetailResponse> getOrder(@Auth AuthUser authUser,
                                                        @PathVariable Long orderId) {
        return ApiResponse.onSuccess(orderService.getOrder(authUser, orderId));
    }
}