package ru.vbolokhov.carstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vbolokhov.carstore.models.Car;
import ru.vbolokhov.carstore.models.Color;
import ru.vbolokhov.carstore.repository.CarsRepository;
import ru.vbolokhov.carstore.repository.GearboxRepository;
import ru.vbolokhov.carstore.repository.MakesRepository;
import ru.vbolokhov.carstore.repository.ModelRepository;
import ru.vbolokhov.carstore.dto.*;

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

    @GetMapping("/header")
    public String getHeader() {
        return "header";
    }

    @GetMapping("/cars/add")
    public String getAddCarPage(Model model) {
        var car = new PostCarDto();
        //car.setOwnerId();
        model.addAttribute("car", car);
        return "addcar";
    }

    @GetMapping("/cars")
    @ResponseBody
    public List<GetCarDto> getUnsoldCars() {
        var cars = this.carRep.findAllBySold(false);
        var assembler = new CarAssembler();
        return cars.stream()
                .map(assembler::writeDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/cars")
    public ResponseEntity<String> addCar(@ModelAttribute PostCarDto dto) {
        System.out.println("===> received: " + dto);
        var car = new CarAssembler().buildCar(dto);
        this.carRep.save(car);
        System.out.println("===> saved.");
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
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
}
