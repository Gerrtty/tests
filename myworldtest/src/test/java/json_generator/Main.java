package json_generator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.PostData;
import tests.TestBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// groups 10 /home/yuliya/Desktop/testdata/testdata.json json

public class Main {
    public static void main(String[] args) {

        // чтобы можно было запустить и из консоли и просто так
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            args = s.split(" ");
        }

        String type = args[0];
        int count = Integer.parseInt(args[1]);
        String filename = args[2];
        String format = args[3];

        // у меня пост и пост в группе охожие сущности, поэтому можно не дублироваать уж
        if (type.equals("groups")) {
            generateForGroups(count, filename, format);
        }
        else if (type.equals("post")) {
            generateForGroups(count, filename, format);
        }
        else {
            System.out.println("Unrecognized type of data " + type);
        }

        System.out.println("\u001B[32m" + "Data generated into " + filename + "\u001B[0m");

    }

    public static void generateForGroups(int count, String filename, String format) {
        List<PostData> groups = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            PostData postData = new PostData(generateRandomString(10));
            groups.add(postData);
        }
        File file = new File(filename);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (format.equals("json")) {
            writeGroupsToJsonFile(groups, writer);
        }
        else {
            System.out.println("Unrecognized format" + format);
        }
        writer.close();
    }

    public static void writeGroupsToJsonFile(List<PostData> groups, PrintWriter writer) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String out = objectMapper.writeValueAsString(groups);
            writer.println(out);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static String generateRandomString(int length) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789.,/';[]{}-_+=!@#$%^&*()№;:?".toCharArray();
        String out = "";
        Random r = new Random();

        for (int i = 0; i < length; i++) {
            char c = chars[r.nextInt(chars.length)];
            out += c;
        }

        return out;
    }
}
