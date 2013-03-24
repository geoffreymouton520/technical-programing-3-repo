/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.app.factory;

import com.startup.musicstore.domain.Album;
import com.startup.musicstore.domain.AlbumCategory;
import java.util.List;

/**
 *
 * @author geoffrey
 */
public class AlbumCategoryFactory {
    public static AlbumCategory getAlbumCategory(List<Album> albums, String categoryName){
        AlbumCategory albumCategory = new AlbumCategory();
        albumCategory.setAlbums(albums);
        albumCategory.setCategoryName(categoryName);
        return albumCategory;
    }
}
