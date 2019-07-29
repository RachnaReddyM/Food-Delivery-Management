
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
    "Monday",
    "Saturday",
    "Sunday",
    "Wednesday",
    "Tuesday",
    "Friday",
    "Thursday"
})
public class Hours {

    @JsonProperty("Monday")
    private List<String> monday = null;
    @JsonProperty("Saturday")
    private List<String> saturday = null;
    @JsonProperty("Sunday")
    private List<String> sunday = null;
    @JsonProperty("Wednesday")
    private List<String> wednesday = null;
    @JsonProperty("Tuesday")
    private List<String> tuesday = null;
    @JsonProperty("Friday")
    private List<String> friday = null;
    @JsonProperty("Thursday")
    private List<String> thursday = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Monday")
    public List<String> getMonday() {
        return monday;
    }

    @JsonProperty("Monday")
    public void setMonday(List<String> monday) {
        this.monday = monday;
    }

    @JsonProperty("Saturday")
    public List<String> getSaturday() {
        return saturday;
    }

    @JsonProperty("Saturday")
    public void setSaturday(List<String> saturday) {
        this.saturday = saturday;
    }

    @JsonProperty("Sunday")
    public List<String> getSunday() {
        return sunday;
    }

    @JsonProperty("Sunday")
    public void setSunday(List<String> sunday) {
        this.sunday = sunday;
    }

    @JsonProperty("Wednesday")
    public List<String> getWednesday() {
        return wednesday;
    }

    @JsonProperty("Wednesday")
    public void setWednesday(List<String> wednesday) {
        this.wednesday = wednesday;
    }

    @JsonProperty("Tuesday")
    public List<String> getTuesday() {
        return tuesday;
    }

    @JsonProperty("Tuesday")
    public void setTuesday(List<String> tuesday) {
        this.tuesday = tuesday;
    }

    @JsonProperty("Friday")
    public List<String> getFriday() {
        return friday;
    }

    @JsonProperty("Friday")
    public void setFriday(List<String> friday) {
        this.friday = friday;
    }

    @JsonProperty("Thursday")
    public List<String> getThursday() {
        return thursday;
    }

    @JsonProperty("Thursday")
    public void setThursday(List<String> thursday) {
        this.thursday = thursday;
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
