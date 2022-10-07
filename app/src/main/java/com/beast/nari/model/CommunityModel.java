package com.beast.nari.model;

public class CommunityModel {

    String userID, originalUserID, ProfilePic,postIMG, likes, disLikes, replies, noOfReplies, reports, caption, rePosts;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getOriginalUserID() {
        return originalUserID;
    }

    public void setOriginalUserID(String originalUserID) {
        this.originalUserID = originalUserID;
    }

    public String getProfilePic() {
        return ProfilePic;
    }

    public void setProfilePic(String profilePic) {
        ProfilePic = profilePic;
    }

    public String getPostIMG() {
        return postIMG;
    }

    public void setPostIMG(String postIMG) {
        this.postIMG = postIMG;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getDisLikes() {
        return disLikes;
    }

    public void setDisLikes(String disLikes) {
        this.disLikes = disLikes;
    }

    public String getReplies() {
        return replies;
    }

    public void setReplies(String replies) {
        this.replies = replies;
    }

    public String getNoOfReplies() {
        return noOfReplies;
    }

    public void setNoOfReplies(String noOfReplies) {
        this.noOfReplies = noOfReplies;
    }

    public String getReports() {
        return reports;
    }

    public void setReports(String reports) {
        this.reports = reports;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getRePosts() {
        return rePosts;
    }

    public void setRePosts(String rePosts) {
        this.rePosts = rePosts;
    }

    public CommunityModel(String userID, String originalUserID, String profilePic, String postIMG, String likes, String disLikes, String replies, String noOfReplies, String reports, String caption, String rePosts) {
        this.userID = userID;
        this.originalUserID = originalUserID;
        ProfilePic = profilePic;
        this.postIMG = postIMG;
        this.likes = likes;
        this.disLikes = disLikes;
        this.replies = replies;
        this.noOfReplies = noOfReplies;
        this.reports = reports;
        this.caption = caption;
        this.rePosts = rePosts;
    }
}
