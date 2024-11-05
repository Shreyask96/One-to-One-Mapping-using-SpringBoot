package com.dakr.DakrSolutionsMapping.TestController;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.dakr.DakrSolutionsMapping.Controller.OwnEnterprisesController;
import com.dakr.DakrSolutionsMapping.Entity.DakrSolutions;
import com.dakr.DakrSolutionsMapping.Service.DakrSolutionsService;
import com.dakr.DakrSolutionsMapping.Service.OwnEnterprisesService;

@WebMvcTest(OwnEnterprisesController.class)
public class OwnEnterprisesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OwnEnterprisesService ownEnterprisesService;

    @MockBean
    private DakrSolutionsService dakrSolutionsService;

    @Test
    public void testSubmitFormSuccess() throws Exception {
        DakrSolutions dakrSolutions = new DakrSolutions();
        dakrSolutions.setName("DAKR");

        when(dakrSolutionsService.findByName("DAKR")).thenReturn(dakrSolutions);

        mockMvc.perform(post("/own-enterprises/submit")
                .param("name", "DAKR")
                .param("employeeCount", "50")
                .param("clientTargets", "5 Clients")
                .param("projectQuality", "High")
                .param("clientSatisfaction", "Excellent"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("message"))
                .andExpect(view().name("own-enterprises-success"));
    }

    @Test
    public void testSubmitFormFailure_NoMatchingDAKR() throws Exception {
        when(dakrSolutionsService.findByName("Unknown")).thenReturn(null);

        mockMvc.perform(post("/own-enterprises/submit")
                .param("name", "Unknown")
                .param("employeeCount", "50")
                .param("clientTargets", "5 Clients")
                .param("projectQuality", "High")
                .param("clientSatisfaction", "Excellent"))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("ownEnterprises", "name"))
                .andExpect(view().name("own-enterprises-form"));
    }
}
