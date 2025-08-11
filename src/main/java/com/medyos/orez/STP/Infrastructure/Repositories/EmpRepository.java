package com.medyos.orez.STP.Infrastructure.Repositories;

import com.medyos.orez.STP.Infrastructure.Entities.Employee;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Medhat
 */
public interface EmpRepository extends JpaRepository<Employee, Long> {

    @EntityGraph(attributePaths = {"empProjectLst"})
    @Query(value = "SELECT e FROM Employee e WHERE e.empNo = :empNo")
    Employee findEmpById(@Param("empNo") Long empNo);
}
