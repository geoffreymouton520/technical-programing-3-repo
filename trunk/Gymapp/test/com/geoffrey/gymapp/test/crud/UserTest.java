/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.test.crud;

import com.geoffrey.gymapp.app.factory.RolesFactory;
import com.geoffrey.gymapp.app.factory.UserFactory;
import com.geoffrey.gymapp.domain.UserRoles;
import com.geoffrey.gymapp.domain.Users;
import com.geoffrey.gymapp.services.crud.RolesCrudService;
import com.geoffrey.gymapp.services.crud.UserCrudService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author geoffrey
 */
public class UserTest {
    private static ApplicationContext ctx;
    private UserCrudService usersCrudService;
    private RolesCrudService rolesCrudService;
    private Long id;
    
    public UserTest() {
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/geoffrey/gymapp/app/config/applicationContext-*.xml");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    @Test
    public void createUsers() {
        usersCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        UserFactory usersFactory = UserFactory.getInstance();
        
        Users user = usersFactory.getUser("geoffrey", "56803537");
        rolesCrudService = (RolesCrudService) ctx.getBean("rolesCrudService");
        RolesFactory rolesFactory = RolesFactory.getInstance();
        
        UserRoles role = rolesFactory.getRole("ROLE_USER", "user");
        rolesCrudService.persist(role);
        
        List<UserRoles> userRoles = new ArrayList<UserRoles>();
        
        userRoles.add(role);
        user.setRoles(userRoles);
        
        usersCrudService.persist(user);
        id = user.getId();
        Assert.assertNotNull(user);
        
    }
    /*
    
    @Test(dependsOnMethods ="createUsers" )
    public void readUsers() {
        usersCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        Users users = usersCrudService.findById(id);
        Assert.assertEquals(users.getUserName(), "admin");
        
    }
    
    @Test(dependsOnMethods ="readUsers" )
    public void updateUsers() {
        usersCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        Users users = usersCrudService.findById(id);
        users.setPassword("123456");
        usersCrudService.merge(users);
        Users updateUsers = usersCrudService.findById(id);
        Assert.assertEquals(updateUsers.getPassword(), "123456");
    }
    
    @Test(dependsOnMethods ="updateUsers" )
    public void readUserss() {
        usersCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        List<Users> userss = usersCrudService.findAll();
        for(Users users : userss){
            System.out.println(users.getUserName());
        }
       Assert.assertTrue(userss.size() > 0);
    }
    
    @Test(dependsOnMethods ="readUserss" )
    public void deleteUsers() {
        usersCrudService = (UserCrudService) ctx.getBean("usersCrudService");
        Users users = usersCrudService.findById(id);
        usersCrudService.remove(users);
        Users deletedUsers = usersCrudService.findById(id);
        Assert.assertNull(deletedUsers);
        
        
    }*/
}
