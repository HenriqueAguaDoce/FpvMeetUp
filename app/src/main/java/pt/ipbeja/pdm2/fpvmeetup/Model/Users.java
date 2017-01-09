package pt.ipbeja.pdm2.fpvmeetup.Model;

/**
 * Created by HenriqueAD on 09/01/2017.
 */

public class Users {
    private int id_user;
    private String name, password, email;

    /**
     * Constructor Users
     * @param id_user
     * @param email
     * @param password
     * @param name
     */
    public Users(int id_user, String name, String password, String email) {
        this.id_user = id_user;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    /**
     * Empty constructor
     */
    public Users() {
    }

    /**
     * Obtain id from the user
     * @return id
     */
    public int getId_user() {
        return id_user;
    }

    /**
     * Set id of the user
     * @param id_user
     */
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    /**
     * Get name from the user
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name for the user
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get password from the user
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password for the user
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get Email from the user
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email for the user
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return false;
        if (o == null || getClass() != o.getClass()) return true;

        return super.equals(o);
    }
}
