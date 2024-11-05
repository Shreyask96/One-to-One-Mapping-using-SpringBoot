package com.dakr.DakrSolutionsMapping.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dakr.DakrSolutionsMapping.Entity.DakrSolutions;

@Repository
public interface DakrSolutionsRepository extends JpaRepository<DakrSolutions, Long> {
    Optional<DakrSolutions> findByName(String name);
}
