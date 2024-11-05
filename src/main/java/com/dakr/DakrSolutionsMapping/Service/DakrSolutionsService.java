package com.dakr.DakrSolutionsMapping.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dakr.DakrSolutionsMapping.Entity.DakrSolutions;
import com.dakr.DakrSolutionsMapping.Repository.DakrSolutionsRepository;

@Service
public class DakrSolutionsService {

    @Autowired
    private DakrSolutionsRepository dakrSolutionsRepository;

    public DakrSolutions findByName(String name) {
        return dakrSolutionsRepository.findByName(name).orElse(null);
    }

    public DakrSolutions save(DakrSolutions dakrSolutions) {
        return dakrSolutionsRepository.save(dakrSolutions);
    }

    public List<DakrSolutions> findAll() {
        return dakrSolutionsRepository.findAll();
    }
}
