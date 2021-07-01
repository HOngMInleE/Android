package org.techtown.misson13;

public class Customer {

    String name;
    String birth;
    String mobile;
    int resId; // 이미지 바꾸기 위해 Id 필드 생성

    public Customer(String name, String birth, String mobile) {     // 생성자 매개변수 3개 짜리
        this.name = name;
        this.birth = birth;
        this.mobile = mobile;
    }

    public Customer(String name, String birth, String mobile, int resId) {  // 생성자 4개 매개값 모두
        this.name = name;
        this.birth = birth;
        this.mobile = mobile;
        this.resId = resId;
    }


    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getBirth() { return birth; }

    public void setBirth(String birth) { this.birth = birth; }

    public String getMobile() { return mobile; }

    public void setMobile(String mobile) { this.mobile = mobile; }

    public int getResId() { return resId; }

    public void setResId(int resId) { this.resId = resId; }
}
