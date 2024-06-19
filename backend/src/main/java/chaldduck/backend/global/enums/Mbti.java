package chaldduck.backend.global.enums;

import lombok.Getter;

@Getter
public enum Mbti {

    // E&I
    EI("EI", "E&I 성격 유형"),
    E("E", "외향형"),
    I("I", "내향형"),

    // S&N
    SN("SN", "S&N 성격 유형"),
    S("S", "감각형"),
    N("N", "직관형"),

    // T&F
    TF("TF", "T&F 성격 유형"),
    T("T", "사고형"),
    F("F", "감정형"),

    // J&P
    JP("JP", "J&P 성격 유형"),
    J("J", "판단형"),
    P("P", "인식형");

    private final String value;
    private final String description;

    Mbti(String value, String description) {
        this.value = value;
        this.description = description;
    }
}
