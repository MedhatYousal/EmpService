package com.medyos.orez.STP.Infrastructure.SERVICES;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Medhat
 */
@FeignClient(name = "GrntorService", url = "${grntor-service-url}")
//@FeignClient(name = "GrntorService")
public interface GrntorClient {

    @GetMapping("Stp/Grntors/onload")
    public ResponseEntity<Object> onload();
}
