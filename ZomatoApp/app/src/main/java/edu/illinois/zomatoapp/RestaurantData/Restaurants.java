package edu.illinois.zomatoapp.RestaurantData;

/**
 * This class simply contains the Restaurant class.
 *"restaurants": [
 {
 "restaurant": {
 "r": {
 "res_id": 17317293
 },
 "apikey": "e365840918d9530e75ec3bfe580e8000",
 "id": "17317293",
 "name": "Evo Cafe",
 "url": "https://www.zomato.com/champaign-il/evo-cafe-champaign?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1",
 "location": {
 "address": "711 S 6th St, Champaign 61820",
 "locality": "UIUC Campus",
 "city": "Champaign",
 "city_id": 685,
 "latitude": "40.1101000000",
 "longitude": "-88.2307000000",
 "zipcode": "61820",
 "country_id": 216,
 "locality_verbose": "UIUC Campus, Champaign"
 },
 "switch_to_order_menu": 0,
 "cuisines": "Chinese",
 "average_cost_for_two": 10,
 "price_range": 1,
 "currency": "$",
 "offers": [],
 "thumb": "",
 "user_rating": {
 "aggregate_rating": "3.5",
 "rating_text": "Good",
 "rating_color": "9ACD32",
 "votes": "51"
 },
 "photos_url": "https://www.zomato.com/champaign-il/evo-cafe-champaign/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop",
 "menu_url": "https://www.zomato.com/champaign-il/evo-cafe-champaign/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop",
 "featured_image": "",
 "has_online_delivery": 0,
 "is_delivering_now": 0,
 "deeplink": "zomato://restaurant/17317293",
 "has_table_booking": 0,
 "events_url": "https://www.zomato.com/champaign-il/evo-cafe-champaign/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1",
 "establishment_types": []
 }
 },{
 "restaurant": {
 "r": {
 "res_id": 18252578
 },
 "apikey": "e365840918d9530e75ec3bfe580e8000",
 "id": "18252578",
 "name": "Szechuan China",
 "url": "https://www.zomato.com/champaign-il/szechuan-china-champaign?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1",
 "location": {
 "address": "401 South 1st Street 61820",
 "locality": "Champaign",
 "city": "Champaign",
 "city_id": 685,
 "latitude": "40.1128270000",
 "longitude": "-88.2391810000",
 "zipcode": "61820",
 "country_id": 216,
 "locality_verbose": "Champaign, Champaign"
 },
 "switch_to_order_menu": 0,
 "cuisines": "Chinese",
 "average_cost_for_two": 0,
 "price_range": 1,
 "currency": "$",
 "offers": [],
 "thumb": "",
 "user_rating": {
 "aggregate_rating": "0",
 "rating_text": "Not rated",
 "rating_color": "CBCBC8",
 "votes": "0"
 },
 "photos_url": "https://www.zomato.com/champaign-il/szechuan-china-champaign/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop",
 "menu_url": "https://www.zomato.com/champaign-il/szechuan-china-champaign/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop",
 "featured_image": "",
 "has_online_delivery": 0,
 "is_delivering_now": 0,
 "deeplink": "zomato://restaurant/18252578",
 "has_table_booking": 0,
 "events_url": "https://www.zomato.com/champaign-il/szechuan-china-champaign/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1",
 "establishment_types": []
 }
 }
 ]
 */
public class Restaurants {
    private Restaurant restaurant;

    public Restaurants(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
