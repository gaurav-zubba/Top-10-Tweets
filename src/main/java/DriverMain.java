import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DriverMain{

    private static Map<String, Integer> map = new HashMap<String,Integer>();

    class HashTag{
        String hashtag;
        int count;

        public HashTag(String input, int freq){
            hashtag = input;
            count = freq;
        }
    }

    class HashTagComparator implements Comparator<HashTag> {

        @Override
        public int compare(HashTag o1, HashTag o2) {
            return o1.count - o2.count;
        }
    }




    public static void main(String[] args) {

        //Initialise scanner for input.
        Scanner sc  = new Scanner(System.in);

        System.out.println("Welcome to the Top 10 Twitter Trending HashTag application");
        while(true){
            System.out.println("Choose from the following options : ");
            System.out.println("1. Add new tweet.");
            System.out.println("2. print top 10 hashtags");
            System.out.println("3. Exit");
            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            }
            catch (Exception e){
                System.err.println("ERRRR!!!! Wrong choice ");
            }

            switch (choice){
                case 1:
                    System.out.println("Whats the tweet. \n Awating response....");
                    List<String> list = fetchHashTags(sc.nextLine());
                    addToFreqMap(list);
                    break;
                case 2:
                    System.out.println("Fetching HashTags");
                    getAllHashTags();
                    break;
                case 3:
                    System.out.println("Exiting Bye Bye");
                    return;
                default:
                    System.err.println("ERRRR!! Wrong Choice. ");
            }
        }
    }

    public static List<String> fetchHashTags(String input){

        List<String> result = new ArrayList<String>();

        int index = input.indexOf("#");

        while (index >= 0) {

            int sIndex = input.indexOf(" ", index);

            result.add(input.substring(index+1, sIndex));

            index = input.indexOf("#", sIndex + 1);

        }

        return result;

    }

    public static void addToFreqMap(List<String> input){

        for(String str : input)
            map.put(str, map.getOrDefault(str, 0) + 1);

    }

    public static void getAllHashTags(){

        for(String key : map.keySet())
            System.out.println("HashTag: " + key  + "     \tFrequence: " + map.get(key));

    }
}