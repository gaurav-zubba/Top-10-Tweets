import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DriverMain{

    private static Map<String, Integer> map = new HashMap<String,Integer>();

    public static void main(String[] args) {

        //Initialise scanner for input.
        Scanner sc  = new Scanner(System.in);

        /*
            Logging for intructions through command line
            Choose from the following options :
            1. Add new tweet.
            2. print top 10 hashtags
            3. Exit
         */
        System.out.println("Welcome to the Top 10 Twitter Trending HashTag application");
        while(true){
            System.out.println("Choose from the following options : ");
            System.out.println("1. Add new tweet.");
            System.out.println("2. print top 10 hashtags");
            System.out.println("3. Exit");
            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());


                switch (choice){
                    case 1:
                        System.out.println("What's the tweet. \n Awating response....");
                        String input = sc.nextLine();
                        if(input!= null && input.trim().length() != 0 && input.indexOf('#') != -1) {
                            List<String> list = fetchHashTags(input);
                            addToFreqMap(list);
                        }else
                        {
                            System.err.println("No Hashtags found");
                        }
                        break;
                    case 2:
                        if(map.size() == 0){
                            System.err.println("Let's do some tweeting first!!");
                            break;
                        }
                        System.out.println("Fetching HashTags");
                        getTopNTags(sortMapByValue(), 10);
                        break;
                    case 3:
                        System.out.println("Exiting Bye Bye");
                        return;
                    default:
                        System.err.println("ERRRR!! Wrong input. ");
                }
            }
            catch (Exception e){
                System.err.println("ERRRR!!!! Wrong input ");
            }
        }
    }


    /*
    This function will return the top K hashtags.
    In this problem state ment K = 10. We can modify it based on our needs.
     */
    public static void getTopNTags(List<Entry<String, Integer>> input, int K){

        int n = input.size() < K ? input.size() : K;

        System.out.println("Top " + n + " HashTags");

        for(int i=0 ; i < n ; i++)
            System.out.println(input.get(i).getKey() + "\t\t count: "  + input.get(i).getValue());

    }


    /*
        It will fetch the values from the map and arrange them in the descending order of value.
     */
    public static List<Entry<String, Integer>> sortMapByValue(){

        //convert HashMap into List
        List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(map.entrySet());
        //sorting the list elements
        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2)
            {
                //compare two object and return an integer
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        return list;
    }
    /*
        It will fetch the list of all the hastags in one tweet
     */
    public static List<String> fetchHashTags(String tweet){

        tweet = tweet.replaceAll("#", " #");

        List<String> result = new ArrayList<String>();

        StringTokenizer tokenizer = new StringTokenizer(tweet);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.startsWith("#") && token.trim().length() > 1 ) {
                result.add(token.trim());
            }
        }
        return result;
    }

    /*
        for each hashtag it will add it in the hash map. If already exists it will increment the frequency of it.
     */
    public static void addToFreqMap(List<String> input){

        for(String str : input)
            map.put(str, map.getOrDefault(str, 0) + 1);

    }
}