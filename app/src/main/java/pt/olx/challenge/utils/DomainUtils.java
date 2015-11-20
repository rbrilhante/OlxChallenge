package pt.olx.challenge.utils;

import java.util.List;

import pt.olx.challenge.domain.OlxAd;

/**
 * Created by Asus on 20-11-2015.
 */
public class DomainUtils {

    public static List<OlxAd> olxAdList;

    public static int getCurrentAd(String id){
        for(int i = 0; i < olxAdList.size(); i++) {
            if(olxAdList.get(i).getId().equals(id))
                return i;
        }
        return 0;
    }
}
