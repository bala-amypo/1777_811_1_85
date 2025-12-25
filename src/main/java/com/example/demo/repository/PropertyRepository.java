package com.example.demo.repository;

import com.example.demo.entity.Property;
import java.util.List;

public interface PropertyRepository {

    List<Property> findByCityHQ(String city);
}
