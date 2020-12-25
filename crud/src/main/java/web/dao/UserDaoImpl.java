package web.dao;

import org.springframework.stereotype.Repository;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {

        entityManager.remove(getUser(id));
    }

    @Override
    public List<User> searchUsers(String theSearchName) {
        TypedQuery<User> theQuery;

        if(theSearchName!=null && theSearchName.trim().length()>0) {
            theQuery=entityManager.createQuery("from User where lower(firstName) like: theName or "
                    + "lower(lastName) like: theName", User.class);
            theQuery.setParameter("theName","%"+theSearchName.toLowerCase()+"%");
        }
        else {
            theQuery=entityManager.createQuery("from User", User.class);
        }
        return theQuery.getResultList();
    }

    @Override
    public void updateUser(long id, User user) {
        User tempUser = getUser(id);
        tempUser.setFirstName(user.getFirstName());
        tempUser.setLastName(user.getLastName());
        tempUser.setEmail(user.getEmail());
            entityManager.merge(tempUser);
    }
}
