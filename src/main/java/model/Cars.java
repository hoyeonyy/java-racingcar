package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utils.CarNameConvertor;

public class Cars {
    private final List<Car> cars;
    private final String INVALID_NUMBER_OF_CARS_ERROR_MESSAGE = "레이스에 참여하는 자동차는 최소 2대 이상이어야 합니다.";
    private final String CAR_NAME_DUPLICATED_ERROR_MESSAGE = "중복된 이름의 자동차는 사용할 수 없습니다.";

    public Cars(String inputCarsName) {
        validate(inputCarsName);

        this.cars = makeCars(inputCarsName);
    }

    private List<Car> makeCars(String inputCarsName) {
        List<String> carNames = CarNameConvertor.splitCarNames(inputCarsName);
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(new Name(carName)));
        }
        return cars;
    }

    public void validate(String invalidNames) {
        List<String> names = CarNameConvertor.splitCarNames(invalidNames);
        validateDuplicatedCarName(names);
        validateMinimumNumberOfCars(names);
    }

    private void validateDuplicatedCarName(List<String> invalidNames) {
        Set<String> uniqueNames = new HashSet<>(invalidNames);

        if (uniqueNames.size() != invalidNames.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED_ERROR_MESSAGE);
        }
    }

    private void validateMinimumNumberOfCars(List<String> invalidNames) {
        if (invalidNames.size() < 2) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_CARS_ERROR_MESSAGE);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
