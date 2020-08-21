package com.geodwarf.dao;

import com.geodwarf.models.Point;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointDao <T extends Point> extends CrudRepository<T, Long> {
}
