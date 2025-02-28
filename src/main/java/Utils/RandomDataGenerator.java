package Utils;

import net.datafaker.Faker;

public class RandomDataGenerator {

   public static Faker faker =new Faker();

   public static String getRandomDataFor(RandomDataTypeNames dataTypeNames)
    {
        switch(dataTypeNames){
            case FIRSTNAME:
                return faker.name().firstName();
            case LASTNAME:
                return faker.name().lastName();
                default:
                    return "Data type name not available";

        }
    }



}
