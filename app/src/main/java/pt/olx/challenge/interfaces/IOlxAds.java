package pt.olx.challenge.interfaces;

import java.util.List;

import pt.olx.challenge.domain.OlxAd;

/**
 * Created by Asus on 20-11-2015.
 */
public interface IOlxAds {

    void getOlxAdsCalback(List<OlxAd> olxAdList);
}
