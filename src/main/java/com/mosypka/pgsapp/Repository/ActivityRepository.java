package com.mosypka.pgsapp.Repository;

import com.mosypka.pgsapp.Model.Activity;
import com.mosypka.pgsapp.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by marcin on 21.04.2017.
 */

public interface ActivityRepository extends CrudRepository<Activity, Long> {
@Override
    List<Activity> findAll();
}
