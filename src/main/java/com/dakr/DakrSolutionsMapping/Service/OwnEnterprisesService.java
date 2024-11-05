package com.dakr.DakrSolutionsMapping.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dakr.DakrSolutionsMapping.Entity.OwnEnterprises;
import com.dakr.DakrSolutionsMapping.Repository.OwnEnterprisesRepository;

@Service
public class OwnEnterprisesService {

    @Autowired
    private OwnEnterprisesRepository ownEnterprisesRepository;

    public OwnEnterprises save(OwnEnterprises ownEnterprises) {
        return ownEnterprisesRepository.save(ownEnterprises);
    }
}

