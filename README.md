# Top-10-Tweets

1) Application main class is in the src/main/java package and named as DriverMain.java

## Running the application:
  You can directly run the main class on jdk by giving following commands:
    ``` javac DriverMain.java```
    ```java DriverMain```
## Application Interface.
  Application starts up with 3 basic endpoints. 
  1) Add a new tweet.
  2) Find top 10 HashTags
  3) Exit

## Adding new tweets: 
  It will take the tweet as an input. 
  fetchHashTags Function will get the list of all hashtags present in the tweet. 
  addToFreqMap method will iterate through the list and put all the hashtags in the map along wiht the frequency. 

## Find Top 10 HashTags

  sortMapByValue -  This method will sort the map by values and return a list. 
  
  getTopNTags -  This methods prints the top N hashtags from the list. It our case the value 10 is hardcoded.
  
  
