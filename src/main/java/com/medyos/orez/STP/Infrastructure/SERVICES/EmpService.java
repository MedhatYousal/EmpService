package com.medyos.orez.STP.Infrastructure.SERVICES;

import com.medyos.orez.STP.Infrastructure.Entities.Employee;
import com.medyos.orez.STP.Infrastructure.Repositories.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Medhat
 */
@Service
public class EmpService implements IEmpService {

    @Autowired
    private EmpRepository empRepository;

    @Override
    public ResponseEntity<Object> getEmpById(Long id) throws Exception {
        Employee emp = new Employee();
        emp = empRepository.findEmpById(id);
        return ResponseEntity.ok(emp);
    }
}
