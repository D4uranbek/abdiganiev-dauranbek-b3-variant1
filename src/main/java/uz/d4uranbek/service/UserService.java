package uz.d4uranbek.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import uz.d4uranbek.SecurityContextHolder;
import uz.d4uranbek.entity.AuthUser;
import uz.d4uranbek.enums.Role;

import java.util.List;

@Service
public class UserService extends BaseService {

    private final SecurityContextHolder security;

    public UserService(SecurityContextHolder security) {
        this.security = security;
    }

    public Boolean login(AuthUser user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<AuthUser> query = session.createQuery("from AuthUser where username=:username and password=:password", AuthUser.class);
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());

        List<AuthUser> userList = query.list();
        transaction.commit();
        session.close();

        if (!userList.isEmpty()) {
            AuthUser authUser = userList.get(0);
            if (authUser.getRole().equals(Role.ADMIN)) {
                security.setSession(authUser);
                return true;
            }
        }
        return false;
    }

    public void add(AuthUser user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

}
