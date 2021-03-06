package com.minyou.manba.network.resultModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.minyou.manba.BR;

import java.util.List;

/**
 * Created by luchunhao on 2017/12/26.
 */
public class UserDetailResultModel extends BaseResultModel {


    /**
     * detail : string
     * result : {"mvpPin":"string","nickName":"string","password":"string","phone":"string","photoUrl":"string","qq":"string","refreshToken":"string","roles":[{"role":"1,管理员,ADMIN","userId":0}],"sex":0,"token":"string","userId":0,"weibo":"string","weixin":"string"}
     */

    private UserDetailBean result;

    public UserDetailBean getResult() {
        return result;
    }

    public void setResult(UserDetailBean result) {
        this.result = result;
    }

    public static class UserDetailBean extends BaseObservable{
        /**
         * mvpPin : string
         * nickName : string
         * password : string
         * phone : string
         * photoUrl : string
         * qq : string
         * refreshToken : string
         * roles : [{"role":"1,管理员,ADMIN","userId":0}]
         * sex : 0
         * token : string
         * userId : 0
         * weibo : string
         * weixin : string
         */

        private String mvpPin;
        private String nickName;
        private String password;
        private String phone;
        private String photoUrl;
        private String qq;
        private String refreshToken;
        private int sex;
        private String token;
        private int userId;
        private String weibo;
        private String weixin;
        private List<RolesBean> roles;
        private String birthday;
        private String signName;
        private int fenNum;
        private int followNum;

        public int getFenNum() {
            return fenNum;
        }

        public void setFenNum(int fenNum) {
            this.fenNum = fenNum;
        }

        public int getFollowNum() {
            return followNum;
        }

        public void setFollowNum(int followNum) {
            this.followNum = followNum;
        }

        @Bindable
        public String getSignName() {
            return signName;

        }

        public void setSignName(String signName) {
            this.signName = signName;
            notifyPropertyChanged(BR.signName);
        }

        public String getMvpPin() {
            return mvpPin;
        }

        public void setMvpPin(String mvpPin) {
            this.mvpPin = mvpPin;
        }

        @Bindable
        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
            notifyPropertyChanged(BR.nickName);
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPhotoUrl() {
            return photoUrl;
        }

        public void setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        @Bindable
        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
            notifyPropertyChanged(BR.sex);
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getWeibo() {
            return weibo;
        }

        public void setWeibo(String weibo) {
            this.weibo = weibo;
        }

        public String getWeixin() {
            return weixin;
        }

        public void setWeixin(String weixin) {
            this.weixin = weixin;
        }

        public List<RolesBean> getRoles() {
            return roles;
        }

        public void setRoles(List<RolesBean> roles) {
            this.roles = roles;
        }

        @Bindable
        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
            notifyPropertyChanged(BR.birthday);
        }

        public static class RolesBean {
            /**
             * role : 1,管理员,ADMIN
             * userId : 0
             */

            private String role;
            private int userId;

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }
        }
    }
}
