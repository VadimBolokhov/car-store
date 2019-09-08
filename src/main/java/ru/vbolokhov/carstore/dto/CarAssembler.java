package ru.vbolokhov.carstore.dto;


import org.springframework.stereotype.Service;
import ru.vbolokhov.carstore.models.*;

import java.time.LocalDateTime;

/**
 * Assembling service for Car DTO.
 * @author Vadim Bolokhov
 */
@Service
public class CarAssembler {

    public GetCarDto writeDTO(Car car) {
        var result = new GetCarDto();
        result.setId(car.getId());
        result.setColor(car.getColor());
        result.setDesc(car.getDesc());
        result.setOdometer(car.getOdometer());
        result.setPostDate(car.getPostDate());
        result.setPrice(car.getPrice());
        result.setSold(car.isSold());
        var model = car.getModel();
        result.setModel(this.writeModel(model));
        result.setMake(this.writeMake(model.getMake()));
        result.setBody(this.writeBody(model.getBody()));
        result.setEngine(this.writeEngine(model.getEngine()));
        result.setTransmission(this.writeTransmission(model.getTransmission()));
        result.setOwner(this.writeUser(car.getOwner()));
        result.setGearbox(this.writeGearbox(car.getGearbox()));
        return result;
    }

    public MakeDto writeMake(Make make) {
        return new MakeDto(make.getId(), make.getName());
    }

    public ModelDto writeModel(CarModel model) {
        return new ModelDto(model.getId(), model.getName());
    }

    public BodyDto writeBody(Body body) {
        return new BodyDto(body.getId(), body.getStyle());
    }

    public EngineDto writeEngine(Engine engine) {
        return new EngineDto(engine.getId(), engine.getType());
    }

    public TransDto writeTransmission(Transmission transmission) {
        return new TransDto(transmission.getId(), transmission.getType());
    }

    public GearboxDto writeGearbox(Gearbox box) {
        return new GearboxDto(box.getId(), box.getType());
    }

    public UserDto writeUser(User user) {
        var result = new UserDto();
        result.setId(user.getId());
        result.setEmail(user.getEmail());
        result.setFirstname(user.getFirstname());
        result.setLastname(user.getLastname());
        return result;
    }

    public Car buildCar(GetCarDto dto) {
        var car = new Car();
        car.setOdometer(dto.getOdometer());
        car.setPrice(dto.getPrice());
        car.setColor(dto.getColor());
        car.setDesc(dto.getDesc());
        car.setModel(this.buildModel(dto));
        car.setPostDate(LocalDateTime.now());
        return car;
    }

    private CarModel buildModel(GetCarDto dto) {
        var model = new CarModel();
        model.setBody(new Body(dto.getBody().getId()));
        model.setEngine(new Engine(dto.getEngine().getId()));
        model.setTransmission(new Transmission(dto.getTransmission().getId()));
        model.setMake(new Make(dto.getMake().getId()));
        return model;
    }

    public Car buildCar(PostCarDto dto) {
        var car = new Car();
        car.setPrice(dto.getPrice());
        car.setColor(dto.getColor());
        car.setOdometer(dto.getOdometer());
        car.setDesc(dto.getDesc());
        car.setGearbox(new Gearbox(dto.getGearboxId()));
        car.setModel(this.buildModel(dto));
        car.setPostDate(LocalDateTime.now());
        var user = new User();
        user.setId(dto.getOwnerId());
        car.setOwner(user);
        return car;
    }

    private CarModel buildModel(PostCarDto dto) {
        var model = new CarModel();
        model.setId(dto.getModelId());
        return model;
    }
}
