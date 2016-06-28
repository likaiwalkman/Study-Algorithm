package encript;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class Base64Utils {

    public static String decode(String str) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] decodedBytes = decoder.decodeBuffer(str);
        return new String(decodedBytes);
    }

    public static String encode(String str) throws IOException {
        BASE64Encoder encoder = new BASE64Encoder();
        String encodedBytes = encoder.encode(str.getBytes());
        return new String(encodedBytes);
    }

    @Deprecated
    public static void main(String[] args) throws IOException {
        String str = "eyJkQ2l0eUNvZGUiOiJTRUwiLCJhQ2l0eUNvZGUiOiJDTlgiLCJmbGlnaHRXYXlUeXBlIjoiUlQiLCJnb0RheSI6IjIwMTYtMDctMDcgMDA6MDA6MDAiLCJiYWNrRGF5IjoiMjAxNi0wNy0xMSAwMDowMDowMCIsInNpdGVOYW1lIjoiS1IiLCJjb21wZXRpdG9yIjoiSEFOQVRPVVIiLCJkb21haW4iOiJodHRwOi8vaHR0cDovL2FpcnRrdDIuaGFuYXRvdXIuY29tIiwiZmxpZ2h0Tm9zIjp7IlhKNzAxL0ZEMzQ0M3xGRDM0NDQvWEo3MDAiOjEzNDU4MiwiRDc1MDcvQUs4NTR8RkQzNDQ0L1hKNzAwIjoxMzQ1ODMsIktFNjY3fE1VMjU5NC9LRTg2NCI6MTM0NTgxfX0=";
        String s = "{\"dCityCode\":\"SEL\",\"aCityCode\":\"CNX\",\"flightWayType\":\"RT\",\"goDay\":\"2016-07-07 00:00:00\",\"backDay\":\"2016-07-11 00:00:00\",\"siteName\":\"KR\",\"competitor\":\"HANATOUR\",\"domain\":\"http://http://airtkt2.hanatour.com\",\"flightNos\":{\"XJ701/FD3443|FD3444/XJ700\":134582,\"D7507/AK854|FD3444/XJ700\":134583,\"KE667|MU2594/KE864\":134581}}";

        String decode = Base64Utils.decode(str);

        String encode = Base64Utils.encode(s);
        String decode1 = Base64Utils.decode(encode);

        System.out.println(decode);
        System.out.println(decode1);

        System.out.println(str.equals(encode));
        System.out.println(decode.equals(decode1));

        System.out.println(str);
        System.out.println(encode);
    }
}
