package lib.biblioteca.jwt;
import lib.biblioteca.entities.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class JwtUserDetails extends org.springframework.security.core.userdetails.User {

    User user;

    public JwtUserDetails(User user) {
        super(user.getNome(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRoles().toString()));
    }
    public Long getId() {
        return this.user.getId();
    }

    public String getRole() {
        return this.user.getRoles().toString();
    }
}
