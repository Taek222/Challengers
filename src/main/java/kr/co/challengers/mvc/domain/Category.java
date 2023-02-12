package kr.co.challengers.mvc.domain;

public enum Category implements BaseCodeLabelEnum{
    HEALTH("건강"),
    STUDY("공부"),
    SELF("자기계발")
    ;

    private String code;
    private String label;


    Category(String label){
        this.code = name();
        this.label = label;
    }
    @Override
    public String code() {
        return code;
    }

    @Override
    public String label() {
        return label;
    }
}
