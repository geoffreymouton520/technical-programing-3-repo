/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.app.factory;

import com.startup.musicstore.domain.Album;
import com.startup.musicstore.domain.ArtistInformation;
import com.startup.musicstore.domain.MarketingInformation;
import com.startup.musicstore.domain.Review;
import com.startup.musicstore.domain.Track;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author geoffrey
 */
public class AlbumFactory {
    public static Album getAlbum(Map<String, String> values, List<Track> tracks, BigDecimal unitPrice){
         
         Review review = new Review();
         review.setDescription(values.get("description"));
         
         ArtistInformation artistInformation = new ArtistInformation();
         artistInformation.setFirstName(values.get("firstName"));
         artistInformation.setLastName(values.get("lastName"));

         MarketingInformation marketingInformattion = new MarketingInformation();
         marketingInformattion.setStatusOfInformation(values.get("statusOfInformation"));
         
         marketingInformattion.setArtistInformation(artistInformation);
         marketingInformattion.setReview(review);
  
         Album album = new Album();
         album.setAlbumTitle(values.get("albumTitle"));
         album.setTracks(tracks);
         album.setUnitPrice(unitPrice);
         album.setMarketingInformation(marketingInformattion);
         
         return album;
     }
}
