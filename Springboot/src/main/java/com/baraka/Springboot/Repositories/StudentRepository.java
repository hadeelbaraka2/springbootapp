
package com.baraka.Springboot.Repositories;

import com.baraka.Springboot.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student , Integer> {
    
}
