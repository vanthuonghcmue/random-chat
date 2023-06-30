package vn.tma.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import vn.tma.entity.User;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

}
