package com.geodwarf.dao;

import com.geodwarf.models.LineString;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineStringDao extends CrudRepository<LineString, Integer> {
}
