package com.dakr.DakrSolutionsMapping.TestRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.dakr.DakrSolutionsMapping.Entity.OwnEnterprises;
import com.dakr.DakrSolutionsMapping.Repository.OwnEnterprisesRepository;

@DataJpaTest
public class OwnEnterprisesRepositoryTest {

    @Autowired
    private OwnEnterprisesRepository ownEnterprisesRepository;

    @Test
    public void testSaveOwnEnterprises() {
        OwnEnterprises ownEnterprises = new OwnEnterprises();
        ownEnterprises.setName("DAKR");
        ownEnterprises.setEmployeeCount(50);
        ownEnterprises.setClientTargets("5 Clients");
        ownEnterprises.setProjectQuality("High");
        ownEnterprises.setClientSatisfaction("Excellent");

        OwnEnterprises saved = ownEnterprisesRepository.save(ownEnterprises);
        assertNotNull(saved);
        assertEquals("DAKR", saved.getName());
    }
}
