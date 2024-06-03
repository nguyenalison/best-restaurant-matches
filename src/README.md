# best-restaurant-match - take home assessment
This application will find the best matched restaurants based on the following criteria: Restaurant Name, Customer
Rating(1 star ~ 5 stars), Distance(1 mile ~ 10 miles), Price(how much one person will spend on average, $10 ~ $50),
Cuisine(Chinese, American, Thai, etc.)

## Questions
- What makes the parameters invalid?
- What will happen with cases when its like 'Pie Bar' and 'Bar Pie'
- What effect of special characters or spaces
- " tasty" vs "tasty"
- Ask the user for company location? 
- What can I do to make my submission to stand out from the rest of the candidates 

## Task Flow
- Ask the user to input their parameters but empty for none
- Display all the matches


## Models
Restaurant class
- int customerRatings
- double distance
- double price
- int cuisineID

## Repository
Responsible for loading in data into the data structure.

### Approaches
1. Single Map with composite key
   RestaurantName: {customerRating, distance, price, cuisine}

   Pros:
    - simple structure
    - low memory overhead
    - automatic updates
      Cons:
    - Inefficient search
    - limited flexibility for updating and adding criteria
2. Multiple Hashmaps + Trie Tree for different criteria
   Pros:
    - Efficient look up
    - parallel searching
    - flexibility for adding and removing criteria
      Cons:
    - Memory overhead
    - Need to implement synchronization of data to reduce data redundancy and ensure all data

Questions I would ask client/team before proceeding with either approach
1. What do we want to prioritize? User's experience and quick searching/filtering/matching? Scalability?
2. What resources do we have more of? Space? Time?


For this implementation, I have favored using multiple hashmaps. Here are my reasons.
1. Favoring the user's experience. Should this code be used in an application user's experience would be more satisfied
   with a quick search

## Best Matches
Matching Criteria 

ByName:
- position of the match 
- length of name 
- frequency of substring 
- lexicographical order final

