package vn.tma.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import vn.tma.entity.App;

@ApplicationScoped
public class AppRepository implements PanacheRepository<App> {

    @Inject
    EntityManager entityManager;

    @Transactional
    public App save(App app) {
        persistAndFlush(app);
        return app;
    }

    @Transactional
    public App update(App app) {
        return entityManager.merge(app);
    }

    @Transactional
    public void delete(App app) {
        delete(app);
    }
}
