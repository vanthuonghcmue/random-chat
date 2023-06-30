package vn.tma.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import vn.tma.entity.Organization;

@ApplicationScoped
public class OrganizationRepository implements PanacheRepository<Organization> {

}
