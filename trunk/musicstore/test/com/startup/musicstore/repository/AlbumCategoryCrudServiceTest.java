/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.repository;

import com.startup.musicstore.app.factory.AlbumCategoryFactory;
import com.startup.musicstore.app.factory.AlbumFactory;
import com.startup.musicstore.app.factory.TrackFactory;
import com.startup.musicstore.domain.Album;
import com.startup.musicstore.domain.AlbumCategory;
import com.startup.musicstore.domain.Track;
import com.startup.musicstore.services.crud.AlbumCategoryCrudService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class AlbumCategoryCrudServiceTest {
    private static ApplicationContext ctx;
    private AlbumCategoryCrudService albumCategoryCrudService;
    private Long id;
    public AlbumCategoryCrudServiceTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/startup/musicstore/app/config/applicationContext-*.xml");
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
    public void createAlbumCategory() {
        albumCategoryCrudService = (AlbumCategoryCrudService) ctx.getBean("albumCategoryCrudService");
        
        Track track1 = TrackFactory.getTrack(1, "Thunderstruck", "http://www.youtube.com/watch?v=v2AC41dglnM");
        Track track2 = TrackFactory.getTrack(2, "Back in black", "http://www.youtube.com/watch?v=tBQ0_9IFzU0");
        List<Track> tracks = new ArrayList<Track>();
        tracks.add(track1);
        tracks.add(track2);

        Map<String, String> albumDetails = new HashMap<String, String>();
        albumDetails.put("description", "ACDC Greatest Hits");
        albumDetails.put("firstName", "AC");
        albumDetails.put("lastName", "DC");
        albumDetails.put("statusOfInformation", "PENDING");
        albumDetails.put("albumTitle", "Greatest Hits");
        
        Album album = AlbumFactory.getAlbum(albumDetails, tracks, new BigDecimal("100.00"));
        
        List<Album> albums = new ArrayList<Album>();
        albums.add(album);
        AlbumCategory albumCategory = AlbumCategoryFactory.getAlbumCategory(albums,"ROCK N ROLL");
        albumCategoryCrudService.persist(albumCategory);
        id = albumCategory.getId();
        Assert.assertNotNull(albumCategory);
        
    }
    
    
    @Test(dependsOnMethods ="createAlbumCategory" )
    public void readAlbumCategory() {
        albumCategoryCrudService = (AlbumCategoryCrudService) ctx.getBean("albumCategoryCrudService");
        AlbumCategory albumCategory = albumCategoryCrudService.findById(id);
        Assert.assertEquals(albumCategory.getCategoryName(), "ROCK N ROLL");
        
    }
    
    @Test(dependsOnMethods ="readAlbumCategory" )
    public void updateAlbumCategory() {
        albumCategoryCrudService = (AlbumCategoryCrudService) ctx.getBean("albumCategoryCrudService");
        AlbumCategory albumCategory = albumCategoryCrudService.findById(id);
        albumCategory.setCategoryName("BLUES ROCK");
        albumCategoryCrudService.merge(albumCategory);
        AlbumCategory updateAlbumCategory = albumCategoryCrudService.findById(id);
        Assert.assertEquals(updateAlbumCategory.getCategoryName(), "BLUES ROCK");
    }
    
    @Test(dependsOnMethods ="updateAlbumCategory" )
    public void readAlbumCategorys() {
        albumCategoryCrudService = (AlbumCategoryCrudService) ctx.getBean("albumCategoryCrudService");
        List<AlbumCategory> albumCategorys = albumCategoryCrudService.findAll();
        for(AlbumCategory albumCategory : albumCategorys){
            System.out.println(albumCategory.getCategoryName());
        }
       Assert.assertTrue(albumCategorys.size() > 0);
    }
    
    @Test(dependsOnMethods ="readAlbumCategorys" )
    public void deleteAlbumCategory() {
        albumCategoryCrudService = (AlbumCategoryCrudService) ctx.getBean("albumCategoryCrudService");
        AlbumCategory albumCategory = albumCategoryCrudService.findById(id);
        albumCategoryCrudService.remove(albumCategory);
        AlbumCategory deletedAlbumCategory = albumCategoryCrudService.findById(id);
        Assert.assertNull(deletedAlbumCategory);
        
        
    }
}
