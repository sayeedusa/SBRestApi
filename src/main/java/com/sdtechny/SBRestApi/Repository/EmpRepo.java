
package com.sdtechny.SBRestApi.Repository;

import com.sdtechny.SBRestApi.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Employee, Integer>{
    
}
