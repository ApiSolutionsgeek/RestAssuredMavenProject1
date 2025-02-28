package airlines;

import Utils.RandomDataGenerator;
import Utils.RandomDataTypeNames;
import airlines.pojos.Airline;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

    public static String createAirlinePayload(String firstName, String lastName, String totalPrice, String depositPaid, String additionalNeeds) {
        String payload = "{\n" +
                "    \"firstname\" : " + firstName + ",\n" +
                "    \"lastname\" :" + lastName + ",\n" +
                "    \"totalprice\" :" + totalPrice + ",\n" +
                "    \"depositpaid\" : " + depositPaid + ",\n" +
                "     \"additionalneeds\" : " + additionalNeeds + "\n" +
                "}";
        return payload;

    }

    public static Map<String, Object> createAirlinePayloadFromMap(String firstName, String lastName, String totalPrice, String depositPaid, String additionalNeeds) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("firstname", firstName);
        payload.put("lastname", lastName);
        payload.put("totalprice", totalPrice);
        payload.put("depositpaid", depositPaid);
        payload.put("additionalneeds", additionalNeeds);

        return payload;

    }

    public static Map<String, Object> createAirlinePayloadFromMap(String totalPrice, String depositPaid, String additionalNeeds) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("firstname", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME));
        payload.put("lastname", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.LASTNAME));
        payload.put("totalprice", totalPrice);
        payload.put("depositpaid", depositPaid);
        payload.put("additionalneeds", additionalNeeds);

        return payload;

    }
    public static Airline createAirlinePayloadFromPOJO(String totalPrice, String depositPaid, String additionalNeeds)
    {
        return Airline
                 .builder()
                 .firstname(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME))
                 .lastname(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.LASTNAME))
                 .totalPrice(totalPrice)
                 .depositPaid(depositPaid)
                 .additionalNeeds(additionalNeeds)
                 .build();

    }

}







