package com.medyos.orez.STP.Infrastructure.Entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Medhat
 */
@Entity
@Table(name = "employee")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByEmpNo", query = "SELECT e FROM Employee e WHERE e.empNo = :empNo"),
    @NamedQuery(name = "Employee.findByEmpName", query = "SELECT e FROM Employee e WHERE e.empName = :empName"),
    @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")})
//@NamedEntityGraph(
//    name = "EmployeeWithProject",
//    attributeNodes = @NamedAttributeNode("empProjectLst")
//)
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "emp_no")
    private Long empNo;
    @Basic(optional = false)
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no", referencedColumnName = "emp_no")
    private List<Project> empProjectLst = new ArrayList<>();

    public Employee() {
    }

    public Employee(Long empNo) {
        this.empNo = empNo;
    }

    public Employee(Long empNo, String empName) {
        this.empNo = empNo;
        this.empName = empName;
    }

    public Long getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Long empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Project> getEmpProjectLst() {
        return empProjectLst;
    }

    public void setEmpProjectLst(List<Project> empProjectLst) {
        this.empProjectLst = empProjectLst;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.empNo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.empName, other.empName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.empNo, other.empNo);
    }

    @Override
    public String toString() {
        return "Employee{" + "empNo=" + empNo + ", empName=" + empName + ", email=" + email + '}';
    }
}
