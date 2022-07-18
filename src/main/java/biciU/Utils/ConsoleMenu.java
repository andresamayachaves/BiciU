package biciU.Utils;


import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;

public class ConsoleMenu {
    public static String renderAndRead(String ...options) {
        Arrays.stream(options).forEachOrdered(System.out::println);
        return readLineFromConsole();
    }

    public static String renderAndRead(String question) {
        System.out.println(question);
        return readLineFromConsole();
    }

    public static String renderAndVerify(Predicate<String> validator, String ...options) {
        Optional<String> option = Optional.of("");
        while(!validator.test(option.get())) {
            option = Optional.of(renderAndRead(options));
        }
        return option.get();
    }

    public static String renderAndVerify(Predicate<String> validator, String question) {
        Optional<String> answer = Optional.of("");
        while(!validator.test(answer.get())) {
            answer = Optional.of(renderAndRead(question));
        }
        return answer.get();
    }

    /*
    public static LocalDate renderAndVerifyDate(String question) {
        String stringifiedDate = renderAndVerify(
                DateUtils::isValidDate, // method referencing
                question
        );
        return LocalDate.parse(stringifiedDate);
    }*/

    public static String readLineFromConsole() {
        return new Scanner(System.in).nextLine();
    }

    public static boolean existsInDB(String code) {    //todo 2nd argument --DB
        //  todo existsInDB()
        return false;
    }
    /*
    public static <T> void printPrettifiedObject(T object) {
        System.out.println("----------------------------------");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement prettyJSON = JsonParser.parseString(gson.toJson(object));
        System.out.println(gson.toJson(prettyJSON));
        System.out.println("----------------------------------");


    public static <T> void printPrettifiedList(List<T> objects) {
        for (T obj : objects) {
            printPrettifiedObject(obj);
        }
    }}*/
}