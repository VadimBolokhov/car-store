package ru.vbolokhov.carstore.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.vbolokhov.carstore.models.*;
import ru.vbolokhov.carstore.repository.CarsRepository;
import ru.vbolokhov.carstore.repository.GearboxRepository;
import ru.vbolokhov.carstore.repository.MakesRepository;
import ru.vbolokhov.carstore.repository.ModelRepository;
import ru.vbolokhov.carstore.security.SecurityService;

import java.util.Collections;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

/**
 * Tests for CarsController class.
 * @author Vadim Bolokhov
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class CarsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarsRepository carsRep;

    @MockBean
    private MakesRepository makesRep;

    @MockBean
    private GearboxRepository boxRep;

    @MockBean
    private ModelRepository modelRep;

    @MockBean
    private SecurityService securityService;

    @Test
    public void whenRequestForCarMakesThenShouldReturnListOfMakeDTOs() throws Exception {
        var make = new Make(111);
        make.setName("Test");
        given(this.makesRep.findAll())
                .willReturn(Collections.singletonList(make));
        this.mvc.perform(get("/cars/parts/makes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(111)))
                .andExpect(jsonPath("$[0].name", is("Test")));
    }

    @Test
    public void whenRequestForGearboxesThenShouldReturnListOfGearboxes() throws Exception {
        var box = new Gearbox(111);
        box.setType("Test");
        given(this.boxRep.findAll())
                .willReturn(Collections.singletonList(box));
        this.mvc.perform(get("/cars/parts/gearboxes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(111)))
                .andExpect(jsonPath("$[0].type", is("Test")));
    }

    @Test
    public void whenRequestForModelsByMakeIdThenShouldReturnListOfModels() throws Exception {
        var model = new CarModel("Test");
        model.setId(222);
        given(this.modelRep.findAllByMakeId(111))
                .willReturn(Collections.singletonList(model));
        this.mvc.perform(get("/cars/parts/makes/111/models"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(222)))
                .andExpect(jsonPath("$[0].name", is("Test")));
    }

    @Test
    public void whenRequestForCarByIdThenShouldReturnViewWithTheSameCar() throws Exception {
        var car = new DummyFactory().getCar();
        car.setId(111);
        car.setDesc("Test");
        given(this.carsRep.findById(111))
                .willReturn(Optional.of(car));
        this.mvc.perform(get("/cars/111/"))
                .andExpect(status().isOk())
                .andExpect(view().name("cardetails"))
                .andExpect(model().attribute("car", hasProperty("id", is(111))))
                .andExpect(model().attribute("car", hasProperty("desc", is("Test"))))
                .andExpect(model().attribute("car", hasProperty("sold", is(false))));
    }
}