
package edu.northeastern.cs5200.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiKey",
    "deliveryMin",
    "deliveryPrice",
    "logoUrl",
    "name",
    "streetAddress",
    "city",
    "state",
    "zip",
    "foodTypes",
    "phone",
    "latitude",
    "longitude",
    "minFreeDelivery",
    "taxRate",
    "acceptsCash",
    "acceptsCard",
    "offersPickup",
    "offersDelivery",
    "isTestRestaurant",
    "minWaitTime",
    "maxWaitTime",
    "open",
    "url",
    "hours",
    "timezone"
})
public class Restaurant {

    @JsonProperty("apiKey")
    private String apiKey;
    @JsonProperty("deliveryMin")
    private Integer deliveryMin;
    @JsonProperty("deliveryPrice")
    private Double deliveryPrice;
    @JsonProperty("logoUrl")
    private String logoUrl;
    @JsonProperty("name")
    private String name;
    @JsonProperty("streetAddress")
    private String streetAddress;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;
    @JsonProperty("zip")
    private String zip;
    @JsonProperty("foodTypes")
    private List<String> foodTypes = null;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("minFreeDelivery")
    private Integer minFreeDelivery;
    @JsonProperty("taxRate")
    private Double taxRate;
    @JsonProperty("acceptsCash")
    private Boolean acceptsCash;
    @JsonProperty("acceptsCard")
    private Boolean acceptsCard;
    @JsonProperty("offersPickup")
    private Boolean offersPickup;
    @JsonProperty("offersDelivery")
    private Boolean offersDelivery;
    @JsonProperty("isTestRestaurant")
    private Boolean isTestRestaurant;
    @JsonProperty("minWaitTime")
    private Integer minWaitTime;
    @JsonProperty("maxWaitTime")
    private Integer maxWaitTime;
    @JsonProperty("open")
    private Boolean open;
    @JsonProperty("url")
    private String url;
    @JsonProperty("hours")
    private Hours hours;
    @JsonProperty("timezone")
    private String timezone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("apiKey")
    public String getApiKey() {
        return apiKey;
    }

    @JsonProperty("apiKey")
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @JsonProperty("deliveryMin")
    public Integer getDeliveryMin() {
        return deliveryMin;
    }

    @JsonProperty("deliveryMin")
    public void setDeliveryMin(Integer deliveryMin) {
        this.deliveryMin = deliveryMin;
    }

    @JsonProperty("deliveryPrice")
    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    @JsonProperty("deliveryPrice")
    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    @JsonProperty("logoUrl")
    public String getLogoUrl() {
        return logoUrl;
    }

    @JsonProperty("logoUrl")
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("streetAddress")
    public String getStreetAddress() {
        return streetAddress;
    }

    @JsonProperty("streetAddress")
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("zip")
    public String getZip() {
        return zip;
    }

    @JsonProperty("zip")
    public void setZip(String zip) {
        this.zip = zip;
    }

    @JsonProperty("foodTypes")
    public List<String> getFoodTypes() {
        return foodTypes;
    }

    @JsonProperty("foodTypes")
    public void setFoodTypes(List<String> foodTypes) {
        this.foodTypes = foodTypes;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("minFreeDelivery")
    public Integer getMinFreeDelivery() {
        return minFreeDelivery;
    }

    @JsonProperty("minFreeDelivery")
    public void setMinFreeDelivery(Integer minFreeDelivery) {
        this.minFreeDelivery = minFreeDelivery;
    }

    @JsonProperty("taxRate")
    public Double getTaxRate() {
        return taxRate;
    }

    @JsonProperty("taxRate")
    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    @JsonProperty("acceptsCash")
    public Boolean getAcceptsCash() {
        return acceptsCash;
    }

    @JsonProperty("acceptsCash")
    public void setAcceptsCash(Boolean acceptsCash) {
        this.acceptsCash = acceptsCash;
    }

    @JsonProperty("acceptsCard")
    public Boolean getAcceptsCard() {
        return acceptsCard;
    }

    @JsonProperty("acceptsCard")
    public void setAcceptsCard(Boolean acceptsCard) {
        this.acceptsCard = acceptsCard;
    }

    @JsonProperty("offersPickup")
    public Boolean getOffersPickup() {
        return offersPickup;
    }

    @JsonProperty("offersPickup")
    public void setOffersPickup(Boolean offersPickup) {
        this.offersPickup = offersPickup;
    }

    @JsonProperty("offersDelivery")
    public Boolean getOffersDelivery() {
        return offersDelivery;
    }

    @JsonProperty("offersDelivery")
    public void setOffersDelivery(Boolean offersDelivery) {
        this.offersDelivery = offersDelivery;
    }

    @JsonProperty("isTestRestaurant")
    public Boolean getIsTestRestaurant() {
        return isTestRestaurant;
    }

    @JsonProperty("isTestRestaurant")
    public void setIsTestRestaurant(Boolean isTestRestaurant) {
        this.isTestRestaurant = isTestRestaurant;
    }

    @JsonProperty("minWaitTime")
    public Integer getMinWaitTime() {
        return minWaitTime;
    }

    @JsonProperty("minWaitTime")
    public void setMinWaitTime(Integer minWaitTime) {
        this.minWaitTime = minWaitTime;
    }

    @JsonProperty("maxWaitTime")
    public Integer getMaxWaitTime() {
        return maxWaitTime;
    }

    @JsonProperty("maxWaitTime")
    public void setMaxWaitTime(Integer maxWaitTime) {
        this.maxWaitTime = maxWaitTime;
    }

    @JsonProperty("open")
    public Boolean getOpen() {
        return open;
    }

    @JsonProperty("open")
    public void setOpen(Boolean open) {
        this.open = open;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("hours")
    public Hours getHours() {
        return hours;
    }

    @JsonProperty("hours")
    public void setHours(Hours hours) {
        this.hours = hours;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
