package nio;

import sun.misc.BASE64Decoder;

import java.io.IOException;

public class Base64 {

    public static final String HTTP_REQUEST = "R0VUIGh0dHA6Ly9jbi5iaW5nLmNvbS8gSFRUUC8xLjENCkhvc3Q6IGNuLmJpbmcuY29tDQpDb25uZWN0aW9uOiBrZWVwLWFsaXZlDQpDYWNoZS1Db250cm9sOiBtYXgtYWdlPTANClVwZ3JhZGUtSW5zZWN1cmUtUmVxdWVzdHM6IDENClVzZXItQWdlbnQ6IE1vemlsbGEvNS4wIChXaW5kb3dzIE5UIDYuMTsgV09XNjQpIEFwcGxlV2ViS2l0LzUzNy4zNiAoS0hUTUwsIGxpa2UgR2Vja28pIENocm9tZS81Mi4wLjI3NDMuMTE2IFNhZmFyaS81MzcuMzYNCkFjY2VwdDogdGV4dC9odG1sLGFwcGxpY2F0aW9uL3hodG1sK3htbCxhcHBsaWNhdGlvbi94bWw7cT0wLjksaW1hZ2Uvd2VicCwqLyo7cT0wLjgNCkFjY2VwdC1FbmNvZGluZzogZ3ppcCwgZGVmbGF0ZSwgc2RjaA0KQWNjZXB0LUxhbmd1YWdlOiB6aC1DTix6aDtxPTAuOA0KQ29va2llOiBTUkNIRD1BRj1OT0ZPUk07IFNSQ0hVSUQ9Vj0yJkdVSUQ9RDMxNzU1NjZFMjZDNDM5NjgzRDlEM0ZBMkRBOEQ0RkI7IFNSQ0hVU1I9RE9CPTIwMTYwODEyOyBfRURHRV9WPTE7IE1VSURCPTMwRUYxNDRDRUE0QjY1QTYwNUE5MUQyM0VCRUE2NEYzOyBNVUlEPTMwRUYxNDRDRUE0QjY1QTYwNUE5MUQyM0VCRUE2NEYzOyBfRURHRV9TPVNJRD0xNDY1RTBDN0E3MEY2MDBBMzc4OUU5NTdBNkFFNjE4MTsgU1JDSEhQR1VTUj1DVz0xNjgwJkNIPTkyNSZEUFI9MSZVVEM9NDgwOyBXTFM9VFM9NjM2MDk0NDgwMzE7IF9TUz1TSUQ9MTQ2NUUwQzdBNzBGNjAwQTM3ODlFOTU3QTZBRTYxODEmYkltPTUzOTQ2MiZIVj0xNDczODUxMjM0DQoNCg==";
    public static int HTTP_REQUEST_LENGTH;

    static {
        try {
            HTTP_REQUEST_LENGTH = new BASE64Decoder().decodeBuffer(HTTP_REQUEST).length;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        String strInBase64 = HTTP_REQUEST;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer(strInBase64);
        System.out.println(new String(bytes));

    }
}
