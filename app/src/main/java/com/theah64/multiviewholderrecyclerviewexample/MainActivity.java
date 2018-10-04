package com.theah64.multiviewholderrecyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.theah64.multiviewholderrecyclerviewexample.adapters.VehiclesAdapter;
import com.theah64.multiviewholderrecyclerviewexample.models.Bike;
import com.theah64.multiviewholderrecyclerviewexample.models.Car;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView rvVehicles = findViewById(R.id.rvVehicles);

        // Cars
        final List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW"));
        cars.add(new Car("Benz"));
        cars.add(new Car("Ferrari "));

        // Bikes
        final List<Bike> bikes = new ArrayList<>();
        bikes.add(new Bike("Yamaha"));
        bikes.add(new Bike("Kawasaki"));
        bikes.add(new Bike("Bajaj"));

        rvVehicles.setLayoutManager(new LinearLayoutManager(this));
        VehiclesAdapter vehiclesAdapter = new VehiclesAdapter(this, "Super Cars", "Super Bikes", cars, bikes);
        rvVehicles.setAdapter(vehiclesAdapter);


    }
}
