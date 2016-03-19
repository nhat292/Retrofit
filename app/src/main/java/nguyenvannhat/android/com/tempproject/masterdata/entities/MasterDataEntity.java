package nguyenvannhat.android.com.tempproject.masterdata.entities;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nhat2 on 03/16/2016.
 */
public class MasterDataEntity {

    @SerializedName("app_versions")
    private List<AppVersion> app_versions = new ArrayList<AppVersion>();
    @SerializedName("app_content")
    private AppContent app_content;
    @SerializedName("car_types")
    private List<CarType>  car_types = new ArrayList<CarType>();

    public List<AppVersion> getApp_versions() {
        return app_versions;
    }

    public void setApp_versions(List<AppVersion> app_versions) {
        this.app_versions = app_versions;
    }

    public AppContent getApp_content() {
        return app_content;
    }

    public void setApp_content(AppContent app_content) {
        this.app_content = app_content;
    }

    public List<CarType> getCar_types() {
        return car_types;
    }

    public void setCar_types(List<CarType> car_types) {
        this.car_types = car_types;
    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(MasterDataEntity.this);
    }
    public MasterDataEntity fromJson(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString,MasterDataEntity.class);
    }

    public class AppVersion{
        @SerializedName("os_platform")
        private String os_platform;
        @SerializedName("version_code")
        private Integer version_code;
        @SerializedName("version_name")
        private String version_name;
        @SerializedName("message")
        private String message;
        @SerializedName("url")
        private String url;
        @SerializedName("mandatory")
        private Boolean mandatory;

        public String getOs_platform() {
            return os_platform;
        }

        public void setOs_platform(String os_platform) {
            this.os_platform = os_platform;
        }

        public Integer getVersion_code() {
            return version_code;
        }

        public void setVersion_code(Integer version_code) {
            this.version_code = version_code;
        }

        public String getVersion_name() {
            return version_name;
        }

        public void setVersion_name(String version_name) {
            this.version_name = version_name;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Boolean getMandatory() {
            return mandatory;
        }

        public void setMandatory(Boolean mandatory) {
            this.mandatory = mandatory;
        }

        public String toJson(){
            Gson gson = new Gson();
            return gson.toJson(AppVersion.this);
        }
        public AppVersion fromJson(String jsonString){
            Gson gson = new Gson();
            return gson.fromJson(jsonString,AppVersion.class);
        }
    }

    public class AppContent{
        @SerializedName("about")
        private String about;
        @SerializedName("privacy-policy")
        private String privacy_policy;
        @SerializedName("terms-of-use")
        private String terms_of_use;
        @SerializedName("contact")
        private String contact;

        public String getAbout() {
            return about;
        }

        public void setAbout(String about) {
            this.about = about;
        }

        public String getPrivacy_policy() {
            return privacy_policy;
        }

        public void setPrivacy_policy(String privacy_policy) {
            this.privacy_policy = privacy_policy;
        }

        public String getTerms_of_use() {
            return terms_of_use;
        }

        public void setTerms_of_use(String terms_of_use) {
            this.terms_of_use = terms_of_use;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }
        public String toJson(){
            Gson gson = new Gson();
            return gson.toJson(AppContent.this);
        }
        public AppContent fromJson(String jsonString){
            Gson gson = new Gson();
            return gson.fromJson(jsonString,AppContent.class);
        }
    }

    public class CarType{
        @SerializedName("type_id")
        private Integer type_id;
        @SerializedName("type_name")
        private String type_name;
        @SerializedName("type_booking_fee")
        private String type_booking_fee;

        public Integer getType_id() {
            return type_id;
        }

        public void setType_id(Integer type_id) {
            this.type_id = type_id;
        }

        public String getType_name() {
            return type_name;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }

        public String getType_booking_fee() {
            return type_booking_fee;
        }

        public void setType_booking_fee(String type_booking_fee) {
            this.type_booking_fee = type_booking_fee;
        }
        public String toJson(){
            Gson gson = new Gson();
            return gson.toJson(CarType.this);
        }
        public CarType fromJson(String jsonString){
            Gson gson = new Gson();
            return gson.fromJson(jsonString,CarType.class);
        }
    }

}
