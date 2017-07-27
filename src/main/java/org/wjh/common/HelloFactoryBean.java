package org.wjh.common;

import org.springframework.beans.factory.FactoryBean;
import org.wjh.domain.Car;

public class HelloFactoryBean implements FactoryBean<Car> {
    private String carName;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        System.out.println("HelloFactoryBean setCarName(), name=" + carName);
        this.carName = carName;
    }

    public Car getObject() throws Exception {
        // TODO Auto-generated method stub
        Car car = new Car();
        car.setName(carName);
        System.out.println("HelloFactoryBean getObject(), name=" + carName);
        return car;
    }

    public Class<?> getObjectType() {
        // TODO Auto-generated method stub
        return Car.class;
    }

    public boolean isSingleton() {
        // TODO Auto-generated method stub
        return true;
    }

}
