/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoffrey.gymapp.test.crud;

import com.geoffrey.gymapp.app.factory.RolesFactory;
import com.geoffrey.gymapp.domain.UserRoles;
import com.geoffrey.gymapp.services.crud.RolesCrudService;
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
public class RoleTest {
    private static ApplicationContext ctx;
    private RolesCrudService rolesCrudService;
    private Long id;
    
    public RoleTest() {
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
    public void createRoles() {
        rolesCrudService = (RolesCrudService) ctx.getBean("rolesCrudService");
        RolesFactory rolesFactory = RolesFactory.getInstance();
        
        UserRoles roles = rolesFactory.getRole("ROLE_USER", "user");
        rolesCrudService.persist(roles);
        id = roles.getId();
        Assert.assertNotNull(roles);
        
    }
    
    
    @Test(dependsOnMethods ="createRoles" )
    public void readRoles() {
        rolesCrudService = (RolesCrudService) ctx.getBean("rolesCrudService");
        UserRoles roles = rolesCrudService.findById(id);
        Assert.assertEquals(roles.getDescription(), "Administrator");
        
    }
    
    @Test(dependsOnMethods ="readRoles" )
    public void updateRoles() {
        rolesCrudService = (RolesCrudService) ctx.getBean("rolesCrudService");
        UserRoles roles = rolesCrudService.findById(id);
        roles.setDescription("Administrate this");
        rolesCrudService.merge(roles);
        UserRoles updateRoles = rolesCrudService.findById(id);
        Assert.assertEquals(updateRoles.getDescription(), "Administrate this");
    }
    
    @Test(dependsOnMethods ="updateRoles" )
    public void readRoless() {
        rolesCrudService = (RolesCrudService) ctx.getBean("rolesCrudService");
        List<UserRoles> roless = rolesCrudService.findAll();
        for(UserRoles roles : roless){
            System.out.println(roles.getAuthority());
        }
       Assert.assertTrue(roless.size() > 0);
    }
    
    @Test(dependsOnMethods ="readRoless" )
    public void deleteRoles() {
        rolesCrudService = (RolesCrudService) ctx.getBean("rolesCrudService");
        UserRoles roles = rolesCrudService.findById(id);
        rolesCrudService.remove(roles);
        UserRoles deletedRoles = rolesCrudService.findById(id);
        Assert.assertNull(deletedRoles);
        
        
    }
}
