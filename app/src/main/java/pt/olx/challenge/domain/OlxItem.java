package pt.olx.challenge.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class OlxItem{

    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @Expose
    private Integer totalAds;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("ads_on_page")
    @Expose
    private Integer adsOnPage;
    @SerializedName("view")
    @Expose
    private String view;
    @SerializedName("next_page_url")
    @Expose
    private String nextPageUrl;
    @SerializedName("ads")
    @Expose
    private List<OlxAd> ads = new ArrayList<OlxAd>();

    /**
     *
     * @return
     * The categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     *
     * @param categoryId
     * The category_id
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     *
     * @return
     * The totalAds
     */
    public Integer getTotalAds() {
        return totalAds;
    }

    /**
     *
     * @param totalAds
     * The total_ads
     */
    public void setTotalAds(Integer totalAds) {
        this.totalAds = totalAds;
    }

    /**
     *
     * @return
     * The page
     */
    public Integer getPage() {
        return page;
    }

    /**
     *
     * @param page
     * The page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     *
     * @return
     * The totalPages
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     *
     * @param totalPages
     * The total_pages
     */
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    /**
     *
     * @return
     * The adsOnPage
     */
    public Integer getAdsOnPage() {
        return adsOnPage;
    }

    /**
     *
     * @param adsOnPage
     * The ads_on_page
     */
    public void setAdsOnPage(Integer adsOnPage) {
        this.adsOnPage = adsOnPage;
    }

    /**
     *
     * @return
     * The view
     */
    public String getView() {
        return view;
    }

    /**
     *
     * @param view
     * The view
     */
    public void setView(String view) {
        this.view = view;
    }

    /**
     *
     * @return
     * The nextPageUrl
     */
    public String getNextPageUrl() {
        return nextPageUrl;
    }

    /**
     *
     * @param nextPageUrl
     * The next_page_url
     */
    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    /**
     *
     * @return
     * The ads
     */
    public List<OlxAd> getAds() {
        return ads;
    }

    /**
     *
     * @param ads
     * The ads
     */
    public void setAds(List<OlxAd> ads) {
        this.ads = ads;
    }

}