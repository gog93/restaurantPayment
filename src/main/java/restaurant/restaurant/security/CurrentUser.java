package restaurant.restaurant.security;

import org.springframework.security.core.authority.AuthorityUtils;
import restaurant.restaurant.model.Admin;
import restaurant.restaurant.model.User;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private Admin admin;
    private User user;

    public CurrentUser(Admin admin) {
        super(admin.getEmail(), admin.getPassword(), AuthorityUtils.createAuthorityList(admin.getUserType().name()));
        this.admin = admin;
    }

    public CurrentUser(User user) {
        super(user.getLogin(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getUserType().name()));
        this.user = user;
    }

    public Admin getAdmin() {
        return admin;
    }

    public User getUser() {
        return user;
    }
}