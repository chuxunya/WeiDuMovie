package com.bw.movie.bean;

/*
 *@auther:王可欣
 *@Date: 2019/12/6
 *@Time:9:55
 *@Description:我的信息
 **/
public class MyBean {
    /**
     * result : {"email":"chu0117@foxmail.com","headPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","id":13793,"lastLoginTime":1575597233000,"nickName":"xin","sex":1}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    @Override
    public String toString() {
        return "MyBean{" +
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
         * email : chu0117@foxmail.com
         * headPic : http://172.17.8.100/images/movie/head_pic/bwjy.jpg
         * id : 13793
         * lastLoginTime : 1575597233000
         * nickName : xin
         * sex : 1
         */

        private String email;
        private String headPic;
        private int id;
        private long lastLoginTime;
        private String nickName;
        private int sex;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "email='" + email + '\'' +
                    ", headPic='" + headPic + '\'' +
                    ", id=" + id +
                    ", lastLoginTime=" + lastLoginTime +
                    ", nickName='" + nickName + '\'' +
                    ", sex=" + sex +
                    '}';
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
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
