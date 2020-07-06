package io.dreamstudio.jarslink.commons.entity;

/**
 * @author Ricky Fung
 */
public class UserQueryReq {
    private int type;
    private String fieldValue;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
