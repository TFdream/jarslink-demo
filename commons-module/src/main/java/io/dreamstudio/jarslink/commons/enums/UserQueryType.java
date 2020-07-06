package io.dreamstudio.jarslink.commons.enums;

/**
 * @author Ricky Fung
 */
public enum UserQueryType {
    UID(1, "根据ID查询"),
    NAME(2, "根据姓名查找"),
    MOBILE(3, "根据手机号查找"),
    ID_CARD(4, "根据身份证号查找"),
    ;
    private int value;
    private String desc;
    UserQueryType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

}
