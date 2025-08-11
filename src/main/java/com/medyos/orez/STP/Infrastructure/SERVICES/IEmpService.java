package com.medyos.orez.STP.Infrastructure.SERVICES;

import org.springframework.http.ResponseEntity;

/**
 *
 * @author Medhat
 */
public interface IEmpService {

    public ResponseEntity<Object> getEmpById(Long id) throws Exception;
}
