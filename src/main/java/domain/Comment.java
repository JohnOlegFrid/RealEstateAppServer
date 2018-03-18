package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Comment {

    @Id
    private String address;
    private String userToken;
    private String text;
    private Timestamp timeStamp;
    private String userPictureUrl;
    private String userName;


    public Comment(){}

    public Comment(String address,String userID,String text,Timestamp timeStamp,String userPictureUrl,String userName) {
        this.setAddress(address);
        this.setUserID(userID);
        this.setText(text);
        this.setTimeStamp(timeStamp);
        this.setUserPictureUrl(userPictureUrl);
        this.setUserName(userName);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserID(String userToken) {
        this.userToken = userToken;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUserPictureUrl() {
        return userPictureUrl;
    }

    public void setUserPictureUrl(String userPictureUrl) {
        this.userPictureUrl = userPictureUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}


