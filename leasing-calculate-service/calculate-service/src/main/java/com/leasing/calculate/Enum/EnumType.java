package com.leasing.calculate.Enum;

public class EnumType {

    private Integer icode;

    private Short code;
    private String label;

    public EnumType(int code, String label) {
        this.label = label;
        this.code = new Short((short) code);
    }

    public EnumType(int icode,String label,int code) {
        this.label = label;
        this.code = new Short((short) code);
        this.icode = icode;
    }
    public Comparable getICode() {
        return this.icode == null?this.code:this.icode;
    }
    public short getIShortCode() {
        return ((Short) this.code).shortValue();
    }

    public Short getShort() {
        return ((Short) this.code);
    }
}