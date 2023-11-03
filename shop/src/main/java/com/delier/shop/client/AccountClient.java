package com.delier.shop.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("service-account")
public interface AccountClient {
}
