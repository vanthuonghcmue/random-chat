package vn.tma.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import vn.tma.entity.Behavior;

@ApplicationScoped
public class BehaviorRepository implements PanacheRepository<Behavior> {

}
