package com.github.budison.learn.dao.baeldung;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Kevin Nowak
 *
 * The UserDAO class implements all the functionality required for fetching, updating and removing User objects
 */
class UserDAO implements DAO<User> {

    private final List<User> users = new ArrayList<>();

    UserDAO() {
        users.add(new User("Kevin", "kevin.nowak@web.de"));
        users.add(new User("Magdalena", "magdalena@gmail.com"));
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.ofNullable(users.get((int) id));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public void update(User user, String[] params) {
        user.setName(Objects.requireNonNull(params[0], "Name cannot be null"));
        user.setEmail(Objects.requireNonNull(params[1], "Email cannot be null"));

        users.add(user);
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }
}
