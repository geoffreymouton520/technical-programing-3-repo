/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.app.factory;

import com.startup.musicstore.domain.SampleClip;
import com.startup.musicstore.domain.Track;

/**
 *
 * @author geoffrey
 */
public class TrackFactory {
    public static Track getTrack(int number, String title, String url){
         SampleClip sampleClip = new SampleClip();
         sampleClip.setSampleUrl(url);
         Track track = new Track();
         track.setSampleClip(sampleClip);
         track.setTrackNumber(number);
         track.setTrackTitle(title);
         return track;
     }
}
