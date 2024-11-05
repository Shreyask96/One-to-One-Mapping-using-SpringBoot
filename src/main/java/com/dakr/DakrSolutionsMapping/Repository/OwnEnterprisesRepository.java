package com.dakr.DakrSolutionsMapping.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dakr.DakrSolutionsMapping.Entity.OwnEnterprises;

@Repository
public interface OwnEnterprisesRepository extends JpaRepository<OwnEnterprises, Long> {
    Optional<OwnEnterprises> findByName(String name);
}
