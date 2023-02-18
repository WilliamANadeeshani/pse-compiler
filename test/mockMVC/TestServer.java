package mockMVC;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import restServer.Car;
import restServer.CarController;
import restServer.ModelStorage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes = CarController.class)
class CarControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeEach
    void setUp() {
        ModelStorage.createSampleModel();
    }

    // 1. TODO: Write a test that checks if all cars are returned correctly.
    @Test
    void testGetAllCars() throws Exception {
        List<Car> cars = ModelStorage.getAllCars();
        ResultActions request = mockMvc.perform(get("/cars")).andDo(print()).andExpect(status().isOk());

        String jsonString = request.andReturn().getResponse().getContentAsString();
        List<Car> actualResultList = Arrays.stream(objectMapper.readValue(jsonString, Car[].class)).collect(Collectors.toList());
        assertThat(actualResultList).isEqualTo(cars);
    }

    @Test
    void testGetCarByIdExisting() throws Exception {
        List<Car> cars = ModelStorage.getAllCars();
        Car expectedCar = cars.get(0);
        String carId = expectedCar.getId();

        ResultActions request = mockMvc.perform(get("/cars/"+carId)).andDo(print()).andExpect(status().isOk());
        String jsonString = request.andReturn().getResponse().getContentAsString();
        Car actualCar = objectMapper.readValue(jsonString, Car.class);
        assertThat(actualCar).isEqualTo(expectedCar);
    }

    @Test
    void testGetCarByIdNotExisting() throws Exception {
        mockMvc.perform(get("/cars/1234")).andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    void testCreateCar() throws Exception {
        Car expectedCar = new Car("12345", "white", "Toyota", 100);
        ResultActions request = mockMvc.perform(post("/cars")
                        .content(asJsonString(expectedCar))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        String jsonString = request.andReturn().getResponse().getContentAsString();
        request.andExpect(MockMvcResultMatchers.jsonPath("id").exists());

        String actualCarId = objectMapper.readValue(jsonString, Car.class).getId();
        assertThat(ModelStorage.getCarById(actualCarId)).isEqualToIgnoringGivenFields(expectedCar, "id");

    }

    @Test
    void testUpdateCar() throws Exception {
        List<Car> cars = ModelStorage.getAllCars();
        String carToUpdateId = cars.get(0).getId();
        Car updatedCar = new Car(carToUpdateId, "green", "Nissan", 234);

        mockMvc.perform(put("/cars")
                        .content(asJsonString(updatedCar))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("color").value("green"))
                .andExpect(MockMvcResultMatchers.jsonPath("brand").value("Nissan"))
                .andExpect(MockMvcResultMatchers.jsonPath("rentalCostPerDay").value(234));
        assertThat(ModelStorage.getCarById(carToUpdateId)).isEqualTo(updatedCar);
    }


    @Test
    void testDeleteCar() throws Exception {
        List<Car> cars = ModelStorage.getAllCars();
        String deletedCarId = cars.get(0).getId();

        mockMvc.perform(delete("/cars/" + deletedCarId)).andDo(print()).andExpect(status().isOk());
        assertThat(ModelStorage.getCarById(deletedCarId)).isEqualTo(null);
    }


}
