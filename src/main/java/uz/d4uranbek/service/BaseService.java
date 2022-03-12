package uz.d4uranbek.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import uz.d4uranbek.entity.Book;

@Component
@RequiredArgsConstructor
public abstract class BaseService {

    protected SessionFactory sessionFactory = SessionFactory();

    protected SessionFactory SessionFactory() {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Book.class);
        return configuration.buildSessionFactory();
    }

}
