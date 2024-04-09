package P28_202403151300;

import javax.swing.*;

public class User {
    private String email;
    private String password;
    private String role;
    private Boolean using;
    private AbstractUserPaneFactory factory;

    private User() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public Boolean getUsing() {
        return using;
    }

    public void setUsing(Boolean using) {
        this.using = using;
    }

    public JPanel getFactoryView() {
        if (factory != null) {
            return factory.drawView();
        }
        return null;
    }

    /**
     * Builder
     */
    public static class UserBuilder {
        private User user = new User();

        public UserBuilder email(String email) {
            user.email = email;
            return this;
        }

        public UserBuilder password(String password) {
            user.password = password;
            return this;
        }

        public UserBuilder role(String role) {
            user.role = role;
            // Factory
            if ("manager".equals(role)) {
                user.factory = new ManagerUserPaneFactory();
            }
            if ("student".equals(role)) {
                user.factory = new StudentUserPaneFactory();
            }
            if ("faculty".equals(role)) {
                user.factory = new FacultyUserPaneFactory();
            }
            return this;
        }

        public UserBuilder using(Boolean using) {
            user.using = using;
            return this;
        }

        public User build() {
            return user;
        }
    }
}
