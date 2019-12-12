package com.bw.movie.bean;

/*
 *@auther:王可欣
 *@Date: 2019/12/5
 *@Time:17:51
 *@Description:微信登陆
 **/
public class WXBean {
    /**
     * result : {"sessionId":"157553937276013864","userId":13864,"userInfo":{"headPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/cy7THOLNqgYZLH4GY9QjLj1JUZ6aSe7GRJiaGzqGsV6s2VzrGLEt6fic7pmt0zetgh2MU8iaVliaynVTP5zePic9AqA/132","id":13864,"lastLoginTime":1575539372000,"nickName":"呀呀_8DN","sex":1}}
     * message : 登陆成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    @Override
    public String toString() {
        return "WXBean{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * sessionId : 157553937276013864
         * userId : 13864
         * userInfo : {"headPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/cy7THOLNqgYZLH4GY9QjLj1JUZ6aSe7GRJiaGzqGsV6s2VzrGLEt6fic7pmt0zetgh2MU8iaVliaynVTP5zePic9AqA/132","id":13864,"lastLoginTime":1575539372000,"nickName":"呀呀_8DN","sex":1}
         */

        private String sessionId;
        private int userId;
        private UserInfoBean userInfo;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "sessionId='" + sessionId + '\'' +
                    ", userId=" + userId +
                    ", userInfo=" + userInfo +
                    '}';
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public static class UserInfoBean {
            /**
             * headPic : http://thirdwx.qlogo.cn/mmopen/vi_32/cy7THOLNqgYZLH4GY9QjLj1JUZ6aSe7GRJiaGzqGsV6s2VzrGLEt6fic7pmt0zetgh2MU8iaVliaynVTP5zePic9AqA/132
             * id : 13864
             * lastLoginTime : 1575539372000
             * nickName : 呀呀_8DN
             * sex : 1
             */

            private String headPic;
            private int id;
            private long lastLoginTime;
            private String nickName;
            private int sex;

            @Override
            public String toString() {
                return "UserInfoBean{" +
                        "headPic='" + headPic + '\'' +
                        ", id=" + id +
                        ", lastLoginTime=" + lastLoginTime +
                        ", nickName='" + nickName + '\'' +
                        ", sex=" + sex +
                        '}';
            }

            public String getHeadPic() {
                return headPic;
            }

            public void setHeadPic(String headPic) {
                this.headPic = headPic;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getLastLoginTime() {
                return lastLoginTime;
            }

            public void setLastLoginTime(long lastLoginTime) {
                this.lastLoginTime = lastLoginTime;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }
        }
    }
}
