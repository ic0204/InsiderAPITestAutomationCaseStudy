package apitest;

public enum ApiResponse {
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
    GET("{\n" +
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
    DELETE("{\n" +
            "  \"code\": 200,\n" +
            "  \"type\": \"unknown\",\n" +
            "  \"message\": \"1\"\n" +
            "}"),
    POST_NEGATIVE("{\n" +
            "    \"code\": 400,\n" +
            "    \"type\": \"unknown\",\n" +
            "    \"message\": \"bad input\"\n" +
            "}"),
    PUT_NEGATIVE("{\n" +
            "    \"code\": 400,\n" +
            "    \"type\": \"unknown\",\n" +
            "    \"message\": \"bad input\"\n" +
            "}"),
    GET_NEGATIVE("{\n" +
            "  \"code\": 1,\n" +
            "  \"type\": \"error\",\n" +
            "  \"message\": \"Pet not found\"\n" +
            "}"),
    DELETE_NEGATIVE("{\n" +
            "    \"code\": 400,\n" +
            "    \"type\": \"unknown\",\n" +
            "    \"message\": \"2\"\n" +
            "}");
    private String req = "";

    private ApiResponse(String req) {
        this.req = req;
    }

    public String getText() {
        return req;
    }
}
