package com.nissan.constants;

public enum OrchestratorConstants {

    SESSION_API_URL("https://cncdevelastic/api/account/authenticate"),
    AVAILABLE_BOTS_URL("https://cncdevelastic/odata/Sessions"),
    TENANCY_NAME("tenancyName"),
    USER_NAME("usernameOrEmailAddress"),
    PASSWORD("password"),

    CONTENT_TYPE_KEY("Content-Type"),
    CONTENT_TYPE_VALUE("application/json"),
    AUTHORIZATION_KEY("Authorization"),
    RESULT_NODE("result");

    private String value;

    OrchestratorConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
