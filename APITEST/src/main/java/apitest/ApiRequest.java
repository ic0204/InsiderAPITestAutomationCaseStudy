package apitest;

public enum ApiRequest {
    POST("{\n" +
            "  \"id\": 1,\n" +
            "  \"category\": {\n" +
            "    \"id\": 2,\n" +
            "    \"name\": \"small\"\n" +
            "  },\n" +
            "  \"name\": \"karabas\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 3,\n" +
            "      \"name\": \"karabas\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"available\"\n" +
            "}"),
    PUT("{\n" +
            "  \"id\": 1,\n" +
            "  \"category\": {\n" +
            "    \"id\": 2,\n" +
            "    \"name\": \"small\"\n" +
            "  },\n" +
            "  \"name\": \"karabas\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 3,\n" +
            "      \"name\": \"karabas\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"Not Available\"\n" +
            "}"),
    GET("1"),
    DELETE("1"),
    POST_NEGATIVE("Bla bla bla"),
    PUT_NEGATIVE("BLABLA"),
    GET_NEGATIVE("BLABLA"),
    DELETE_NEGATIVE("2");

    private String req = "";

    private ApiRequest(String req) {
        this.req = req;
    }

    public String getText() {
        return req;
    }

}
