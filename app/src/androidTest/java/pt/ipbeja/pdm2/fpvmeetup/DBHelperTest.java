package pt.ipbeja.pdm2.fpvmeetup;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import pt.ipbeja.pdm2.fpvmeetup.Model.Users;

import static org.junit.Assert.*;

/**
 * Created by HenriqueAD on 17/01/2017.
 */
public class DBHelperTest {
    private DBHelper db = null;

    @Before
    public void setUp() throws Exception {
        InstrumentationRegistry.getTargetContext().deleteDatabase(DBHelper.DB_FILENAME);
        db = new DBHelper(InstrumentationRegistry.getTargetContext());
    }

    @After
    public void tearDown() throws Exception {
        db.close();
    }



    @Test
    public void insertUser() throws Exception {
        Users user = new Users(1, "PrimeiroNome", "passw", "email@email.com");
        db.insertUsers(user);

        List<String> list = db.getAllUserNames();
        assertThat(list.size(), Matchers.is(1));
    }

    @Test
    public void getEmail() throws Exception {
        Users user = new Users(1, "NomeTeste", "qwerty", "email@email.com");
        db.insertUsers(user);

        String email = user.getEmail();
        String dbEmail = db.getEmail("NomeTeste", "qwerty");

        assertEquals(email, dbEmail);
    }

    @Test
    public void getAllUserNames() throws Exception {
        Users user = new Users(1, "Joao", "qwerty", "joao@email.com");
        db.insertUsers(user);
        Users user1 = new Users(2, "Gamito", "123456", "gamito@email.com");
        db.insertUsers(user1);
        Users user2 = new Users(3, "Henrique", "1a2b3c", "henrique@email.com");
        db.insertUsers(user2);
        Users user3 = new Users(4, "Bruno", "zxcvbnm", "bruno@email.com");
        db.insertUsers(user3);

        List<String> list = db.getAllUserNames();
        assertThat(list.size(), Matchers.is(4));


    }
}