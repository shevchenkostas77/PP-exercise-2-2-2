package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDAOImpl implements CarDAO {
    private final List<Car> dataBase = new ArrayList<>();

    {
        dataBase.add(new Car("Brand1", "Model1", 2023));
        dataBase.add(new Car("Brand2", "Model2", 2023));
        dataBase.add(new Car("Brand3", "Model3", 2023));
        dataBase.add(new Car("Brand4", "Model4", 2023));
        dataBase.add(new Car("Brand5", "Model5", 2023));
    }

    @Override
    public List<Car> getListCars(int count) {
        return (count == 0 || count >= 5) ?
                dataBase :
                dataBase.stream().limit(count).collect(Collectors.toList());

    }
}
