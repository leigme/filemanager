package me.leig.filemanager.dao.model;

public class FileWithBLOBs extends File {
    private String content;

    private String saveurl;

    private String tempurl;

    private String longitude;

    private String latitude;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getSaveurl() {
        return saveurl;
    }

    public void setSaveurl(String saveurl) {
        this.saveurl = saveurl == null ? null : saveurl.trim();
    }

    public String getTempurl() {
        return tempurl;
    }

    public void setTempurl(String tempurl) {
        this.tempurl = tempurl == null ? null : tempurl.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }
}