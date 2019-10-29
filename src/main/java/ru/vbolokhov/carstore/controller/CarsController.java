package ru.vbolokhov.carstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vbolokhov.carstore.models.Car;
import ru.vbolokhov.carstore.models.Color;
import ru.vbolokhov.carstore.models.User;
import ru.vbolokhov.carstore.repository.CarsRepository;
import ru.vbolokhov.carstore.repository.GearboxRepository;
import ru.vbolokhov.carstore.repository.MakesRepository;
import ru.vbolokhov.carstore.repository.ModelRepository;
import ru.vbolokhov.carstore.dto.*;
import ru.vbolokhov.carstore.security.AuthenticationDetails;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CarsController class.
 * @author Vadim Bolokhov
 */
@Controller
public class CarsController {

    private CarsRepository carRep;

    private MakesRepository makesRepository;

    private GearboxRepository gearRepository;

    private ModelRepository modelRepository;

    @Autowired
    public CarsController(
            CarsRepository carRep,
            MakesRepository makeRep,
            GearboxRepository gearRep,
            ModelRepository modelRep) {
        this.carRep = carRep;
        this.makesRepository = makeRep;
        this.gearRepository = gearRep;
        this.modelRepository = modelRep;
    }

    @GetMapping({"/", "/index"})
    public String getMainPage(Model model) {
        return "index";
    }

    @GetMapping("/cars/add")
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    public String getAddCarPage(Model model) {
        var car = new PostCarDto();
        model.addAttribute("car", car);
        return "addcar";
    }

    @GetMapping("/cars")
    public String getUnsoldCars(Model model) {
        var cars = this.carRep.findAllBySold(false);
        model.addAttribute("cars", cars);
        return "cars::table";
    }

    @PostMapping("/cars")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> addCar(@ModelAttribute PostCarDto dto) {
        var car = new CarAssembler().buildCar(dto);
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User owner = ((AuthenticationDetails) userDetails).getUser();
        car.setOwner(owner);
        this.carRep.save(car);
        return new ResponseEntity<>("index", HttpStatus.CREATED);
    }

    @GetMapping("/cars/{carId}/")
    public String getDetailsPage(@PathVariable("carId") int id, Model model) {
        Car car = this.carRep.findById(id).get();
        model.addAttribute("car", car);
        return "cardetails";
    }

    @ResponseBody
    @GetMapping("/cars/parts/makes")
    public List<MakeDto> getMakes() {
        var assembler = new CarAssembler();
        return this.makesRepository.findAll().stream()
                .map(assembler::writeMake)
                .collect(Collectors.toList());
    }

    @ResponseBody
    @GetMapping("/cars/parts/gearboxes")
    public List<GearboxDto> getGearboxes() {
        var assembler = new CarAssembler();
        return this.gearRepository.findAll().stream()
                .map(assembler::writeGearbox)
                .collect(Collectors.toList());
    }

    @ResponseBody
    @GetMapping("/cars/parts/colors")
    public List<Color> getColors() {
        return Arrays.asList(Color.values());
    }

    @ResponseBody
    @GetMapping("/cars/parts/makes/{makeId}/models")
    public List<ModelDto> getModels(@PathVariable("makeId") int id) {
        var assembler = new CarAssembler();
        return this.modelRepository.findAllByMakeId(id).stream()
                .map(assembler::writeModel)
                .collect(Collectors.toList());
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        return "login";
    }
}
