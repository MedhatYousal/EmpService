package com.medyos.orez.STP.Controllers;

import com.medyos.orez.STP.Infrastructure.SERVICES.GrntorClient;
import com.medyos.orez.STP.Infrastructure.SERVICES.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Medhat
 */
@RestController
@RequestMapping("/STP/Emps")
public class EmpController {

//    @Autowired
//    private GrntorClient grntorClient;
    
    @Autowired 
    private IEmpService EmpService;

//    @GetMapping("onload")
//    public ResponseEntity<Object> onload() {
//        ResponseEntity<Object> grntor = grntorClient.onload();
//        return ResponseEntity.ok(grntor.getBody());
//    }

    @GetMapping("getByCode/{id}")
    public ResponseEntity<Object> getByCode(@PathVariable Long id) throws Exception {
        ResponseEntity<Object> response = EmpService.getEmpById(id);
        return ResponseEntity.ok(response.getBody());
    }
}
