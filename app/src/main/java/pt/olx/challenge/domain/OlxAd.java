package pt.olx.challenge.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 20-11-2015.
 */
public class OlxAd {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("preview_url")
    @Expose
    private String previewUrl;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("highlighted")
    @Expose
    private Integer highlighted;
    @SerializedName("urgent")
    @Expose
    private Integer urgent;
    @SerializedName("topAd")
    @Expose
    private Integer topAd;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("params")
    @Expose
    private List<List<String>> params = new ArrayList<List<String>>();
    @SerializedName("subtitle")
    @Expose
    private List<Object> subtitle = new ArrayList<Object>();
    @SerializedName("business")
    @Expose
    private Integer business;
    @SerializedName("hide_user_ads_button")
    @Expose
    private Integer hideUserAdsButton;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("header")
    @Expose
    private String header;
    @SerializedName("header_type")
    @Expose
    private String headerType;
    @SerializedName("has_phone")
    @Expose
    private Integer hasPhone;
    @SerializedName("has_email")
    @Expose
    private Integer hasEmail;
    @SerializedName("is_price_negotiable")
    @Expose
    private Integer isPriceNegotiable;
    @SerializedName("map_zoom")
    @Expose
    private String mapZoom;
    @SerializedName("map_lat")
    @Expose
    private Double mapLat;
    @SerializedName("map_lon")
    @Expose
    private Double mapLon;
    @SerializedName("map_radius")
    @Expose
    private Integer mapRadius;
    @SerializedName("map_show_detailed")
    @Expose
    private Boolean mapShowDetailed;
    @SerializedName("map_location")
    @Expose
    private String mapLocation;
    @SerializedName("city_label")
    @Expose
    private String cityLabel;
    @SerializedName("person")
    @Expose
    private String person;
    @SerializedName("user_label")
    @Expose
    private String userLabel;
    @SerializedName("user_ads_id")
    @Expose
    private String userAdsId;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("numeric_user_id")
    @Expose
    private String numericUserId;
    @SerializedName("user_ads_url")
    @Expose
    private String userAdsUrl;
    @SerializedName("list_label")
    @Expose
    private String listLabel;
    @SerializedName("list_label_ad")
    @Expose
    private String listLabelAd;
    @SerializedName("chat_options")
    @Expose
    private Integer chatOptions;
    @SerializedName("list_label_small")
    @Expose
    private String listLabelSmall;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The previewUrl
     */
    public String getPreviewUrl() {
        return previewUrl;
    }

    /**
     *
     * @param previewUrl
     * The preview_url
     */
    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The created
     */
    public String getCreated() {
        return created;
    }

    /**
     *
     * @param created
     * The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     *
     * @return
     * The age
     */
    public Integer getAge() {
        return age;
    }

    /**
     *
     * @param age
     * The age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The highlighted
     */
    public Integer getHighlighted() {
        return highlighted;
    }

    /**
     *
     * @param highlighted
     * The highlighted
     */
    public void setHighlighted(Integer highlighted) {
        this.highlighted = highlighted;
    }

    /**
     *
     * @return
     * The urgent
     */
    public Integer getUrgent() {
        return urgent;
    }

    /**
     *
     * @param urgent
     * The urgent
     */
    public void setUrgent(Integer urgent) {
        this.urgent = urgent;
    }

    /**
     *
     * @return
     * The topAd
     */
    public Integer getTopAd() {
        return topAd;
    }

    /**
     *
     * @param topAd
     * The topAd
     */
    public void setTopAd(Integer topAd) {
        this.topAd = topAd;
    }

    /**
     *
     * @return
     * The categoryId
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     *
     * @param categoryId
     * The category_id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     *
     * @return
     * The params
     */
    public List<List<String>> getParams() {
        return params;
    }

    /**
     *
     * @param params
     * The params
     */
    public void setParams(List<List<String>> params) {
        this.params = params;
    }

    /**
     *
     * @return
     * The subtitle
     */
    public List<Object> getSubtitle() {
        return subtitle;
    }

    /**
     *
     * @param subtitle
     * The subtitle
     */
    public void setSubtitle(List<Object> subtitle) {
        this.subtitle = subtitle;
    }

    /**
     *
     * @return
     * The business
     */
    public Integer getBusiness() {
        return business;
    }

    /**
     *
     * @param business
     * The business
     */
    public void setBusiness(Integer business) {
        this.business = business;
    }

    /**
     *
     * @return
     * The hideUserAdsButton
     */
    public Integer getHideUserAdsButton() {
        return hideUserAdsButton;
    }

    /**
     *
     * @param hideUserAdsButton
     * The hide_user_ads_button
     */
    public void setHideUserAdsButton(Integer hideUserAdsButton) {
        this.hideUserAdsButton = hideUserAdsButton;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The header
     */
    public String getHeader() {
        return header;
    }

    /**
     *
     * @param header
     * The header
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     *
     * @return
     * The headerType
     */
    public String getHeaderType() {
        return headerType;
    }

    /**
     *
     * @param headerType
     * The header_type
     */
    public void setHeaderType(String headerType) {
        this.headerType = headerType;
    }

    /**
     *
     * @return
     * The hasPhone
     */
    public Integer getHasPhone() {
        return hasPhone;
    }

    /**
     *
     * @param hasPhone
     * The has_phone
     */
    public void setHasPhone(Integer hasPhone) {
        this.hasPhone = hasPhone;
    }

    /**
     *
     * @return
     * The hasEmail
     */
    public Integer getHasEmail() {
        return hasEmail;
    }

    /**
     *
     * @param hasEmail
     * The has_email
     */
    public void setHasEmail(Integer hasEmail) {
        this.hasEmail = hasEmail;
    }

    /**
     *
     * @return
     * The isPriceNegotiable
     */
    public Integer getIsPriceNegotiable() {
        return isPriceNegotiable;
    }

    /**
     *
     * @param isPriceNegotiable
     * The is_price_negotiable
     */
    public void setIsPriceNegotiable(Integer isPriceNegotiable) {
        this.isPriceNegotiable = isPriceNegotiable;
    }

    /**
     *
     * @return
     * The mapZoom
     */
    public String getMapZoom() {
        return mapZoom;
    }

    /**
     *
     * @param mapZoom
     * The map_zoom
     */
    public void setMapZoom(String mapZoom) {
        this.mapZoom = mapZoom;
    }

    /**
     *
     * @return
     * The mapLat
     */
    public Double getMapLat() {
        return mapLat;
    }

    /**
     *
     * @param mapLat
     * The map_lat
     */
    public void setMapLat(Double mapLat) {
        this.mapLat = mapLat;
    }

    /**
     *
     * @return
     * The mapLon
     */
    public Double getMapLon() {
        return mapLon;
    }

    /**
     *
     * @param mapLon
     * The map_lon
     */
    public void setMapLon(Double mapLon) {
        this.mapLon = mapLon;
    }

    /**
     *
     * @return
     * The mapRadius
     */
    public Integer getMapRadius() {
        return mapRadius;
    }

    /**
     *
     * @param mapRadius
     * The map_radius
     */
    public void setMapRadius(Integer mapRadius) {
        this.mapRadius = mapRadius;
    }

    /**
     *
     * @return
     * The mapShowDetailed
     */
    public Boolean getMapShowDetailed() {
        return mapShowDetailed;
    }

    /**
     *
     * @param mapShowDetailed
     * The map_show_detailed
     */
    public void setMapShowDetailed(Boolean mapShowDetailed) {
        this.mapShowDetailed = mapShowDetailed;
    }

    /**
     *
     * @return
     * The mapLocation
     */
    public String getMapLocation() {
        return mapLocation;
    }

    /**
     *
     * @param mapLocation
     * The map_location
     */
    public void setMapLocation(String mapLocation) {
        this.mapLocation = mapLocation;
    }

    /**
     *
     * @return
     * The cityLabel
     */
    public String getCityLabel() {
        return cityLabel;
    }

    /**
     *
     * @param cityLabel
     * The city_label
     */
    public void setCityLabel(String cityLabel) {
        this.cityLabel = cityLabel;
    }

    /**
     *
     * @return
     * The person
     */
    public String getPerson() {
        return person;
    }

    /**
     *
     * @param person
     * The person
     */
    public void setPerson(String person) {
        this.person = person;
    }

    /**
     *
     * @return
     * The userLabel
     */
    public String getUserLabel() {
        return userLabel;
    }

    /**
     *
     * @param userLabel
     * The user_label
     */
    public void setUserLabel(String userLabel) {
        this.userLabel = userLabel;
    }

    /**
     *
     * @return
     * The userAdsId
     */
    public String getUserAdsId() {
        return userAdsId;
    }

    /**
     *
     * @param userAdsId
     * The user_ads_id
     */
    public void setUserAdsId(String userAdsId) {
        this.userAdsId = userAdsId;
    }

    /**
     *
     * @return
     * The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     * The user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     * The numericUserId
     */
    public String getNumericUserId() {
        return numericUserId;
    }

    /**
     *
     * @param numericUserId
     * The numeric_user_id
     */
    public void setNumericUserId(String numericUserId) {
        this.numericUserId = numericUserId;
    }

    /**
     *
     * @return
     * The userAdsUrl
     */
    public String getUserAdsUrl() {
        return userAdsUrl;
    }

    /**
     *
     * @param userAdsUrl
     * The user_ads_url
     */
    public void setUserAdsUrl(String userAdsUrl) {
        this.userAdsUrl = userAdsUrl;
    }

    /**
     *
     * @return
     * The listLabel
     */
    public String getListLabel() {
        return listLabel;
    }

    /**
     *
     * @param listLabel
     * The list_label
     */
    public void setListLabel(String listLabel) {
        this.listLabel = listLabel;
    }

    /**
     *
     * @return
     * The listLabelAd
     */
    public String getListLabelAd() {
        return listLabelAd;
    }

    /**
     *
     * @param listLabelAd
     * The list_label_ad
     */
    public void setListLabelAd(String listLabelAd) {
        this.listLabelAd = listLabelAd;
    }

    /**
     *
     * @return
     * The chatOptions
     */
    public Integer getChatOptions() {
        return chatOptions;
    }

    /**
     *
     * @param chatOptions
     * The chat_options
     */
    public void setChatOptions(Integer chatOptions) {
        this.chatOptions = chatOptions;
    }

    /**
     *
     * @return
     * The listLabelSmall
     */
    public String getListLabelSmall() {
        return listLabelSmall;
    }

    /**
     *
     * @param listLabelSmall
     * The list_label_small
     */
    public void setListLabelSmall(String listLabelSmall) {
        this.listLabelSmall = listLabelSmall;
    }
}
