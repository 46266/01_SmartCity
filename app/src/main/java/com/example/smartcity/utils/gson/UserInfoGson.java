package com.example.smartcity.utils.gson;

import com.google.gson.annotations.SerializedName;

public class UserInfoGson {

    @SerializedName("data")
    private DataDTO data;
    @SerializedName("code")
    private Integer code;
    @SerializedName("msg")
    private String msg;

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataDTO {
        @SerializedName("account_status")
        private Integer accountStatus;
        @SerializedName("app_version")
        private Object appVersion;
        @SerializedName("avatar")
        private String avatar;
        @SerializedName("createtime")
        private String createtime;
        @SerializedName("email")
        private String email;
        @SerializedName("gender")
        private String gender;
        @SerializedName("id")
        private Integer id;
        @SerializedName("nick_name")
        private String nickName;
        @SerializedName("pass_word")
        private String passWord;
        @SerializedName("phone")
        private String phone;
        @SerializedName("plain_pass_word")
        private Object plainPassWord;
        @SerializedName("signature")
        private String signature;
        @SerializedName("user_name")
        private String userName;

        public Integer getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(Integer accountStatus) {
            this.accountStatus = accountStatus;
        }

        public Object getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(Object appVersion) {
            this.appVersion = appVersion;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPassWord() {
            return passWord;
        }

        public void setPassWord(String passWord) {
            this.passWord = passWord;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Object getPlainPassWord() {
            return plainPassWord;
        }

        public void setPlainPassWord(Object plainPassWord) {
            this.plainPassWord = plainPassWord;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
