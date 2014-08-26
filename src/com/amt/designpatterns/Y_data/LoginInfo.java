
package com.amt.designpatterns.Y_data;

/**
 * Description.
 * @author 叶蕾
 *
 */
public class LoginInfo {
    /** the user name. */
    public String username;
    /** the password of user. */
    public String password;
    public String server;

    public boolean savePassword;
    public boolean autoLogin;

    /** constructor. */
    public LoginInfo() {
        this.username = "";
        this.password = "";
        this.server = "";
        savePassword = false;
        autoLogin = false;
    }

    /**
     * Description.
     * @param username1 the user name.
     * @param password1 the password.
     * @param server1 the server.
     * @param savePassword1 the key of save password.
     * @param autoLogin1 the key of auto login.
     */
    public LoginInfo(final String username1,
            final String password1,
            final String server1,
            final boolean savePassword1,
            final boolean autoLogin1) {
        this.username = username1;
        this.password = password1;
        this.server = server1;
        this.savePassword = savePassword1;
        this.autoLogin = autoLogin1;
    }

    /**
     * Description.
     * @param username
     * @param password
     * @param server
     * @param savePassword
     * @param autoLogin
     */
    public void setLoginInfo(String username, String password, String server,
            boolean savePassword, boolean autoLogin) {
        this.username = username;
        this.password = password;
        this.server = server;
        this.savePassword = savePassword;
        this.autoLogin = autoLogin;
    }
}
