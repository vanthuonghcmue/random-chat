package vn.tma.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import vn.tma.entity.Environment;

@ApplicationScoped
public class EnvironmentRepository implements PanacheRepository<Environment> {

}
