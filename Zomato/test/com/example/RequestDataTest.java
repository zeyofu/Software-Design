package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RequestDataTest {
    private RequestData restaurants;
    private String restaurantsCampaignChinese;
    private String restaurantsCampaignChineseFull;
    private String restaurantsCampaignChineseMexican;
    private String restaurantsCampaignChineseMexicanFull;
    private int champaignID;

    @Before
    public void setUp() throws Exception {
        restaurants = new RequestData();
        champaignID = restaurants.getCityID("Champaign");
        restaurantsCampaignChinese = restaurants.getRestaurantsByCityAndCuisine(685,25);
        restaurantsCampaignChineseFull = restaurants.getAllRestaurantsByCityAndCuisine(685, 25);
        restaurantsCampaignChineseMexican = restaurants.
                getRestaurantsWithMultipleCuisines(685, new int[]{25, 73});
        restaurantsCampaignChineseMexicanFull = restaurants.
                getAllRestaurantsWithMultipleCuisines(685, new int[]{25, 73});
    }

    @Test
    public void getCityID() throws Exception {
        assertEquals(685,champaignID);
    }

    @Test
    public void getRestaurantsByCityAndCuisine() throws Exception {
        assertEquals("Golden Harbor\n" +
                "  505 S Neil St, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "Cravings\n" +
                "  603 S Wright St, Champaign 61820\n" +
                "  Asian, Chinese\n" +
                "\n" +
                "First Wok\n" +
                "  1805 Philo Rd, Urbana 61802\n" +
                "  Chinese\n" +
                "\n" +
                "Rainbow Garden\n" +
                "  1402 S Neil St Ste 3, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "Wok\n" +
                "  703 Eastwood Dr, Mahomet 61853\n" +
                "  Chinese\n" +
                "\n" +
                "Green Jade\n" +
                "  1109 Windsor Rd, Champaign 61821\n" +
                "  Chinese\n" +
                "\n" +
                "Chopstix\n" +
                "  202 E Green st, Champaign 61820\n" +
                "  Asian, Chinese\n" +
                "\n" +
                "Empire\n" +
                "  410 E Green St, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "Peking House Restaurant\n" +
                "  806 E Franklin St, Mahomet 61853\n" +
                "  Chinese\n" +
                "\n" +
                "Ming Garden\n" +
                "  1804 Sangamon Dr, Champaign 61821\n" +
                "  Chinese\n" +
                "\n" +
                "Peking Garden Restaurant\n" +
                "  206 N Randolph St Ste 1, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "Golden Wok\n" +
                "  405 E University Ave, Champaign 61820\n" +
                "  Chinese, Thai\n" +
                "\n" +
                "China Garden\n" +
                "  114 N Vine St, Urbana 61802\n" +
                "  Chinese\n" +
                "\n" +
                "Lai Lai Wok\n" +
                "  402 E Green St, Champaign 61820\n" +
                "  Chinese, Thai\n" +
                "\n" +
                "China King\n" +
                "  2145 S Neil St, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "China King\n" +
                "  205 W Warren St, St Joseph 61873\n" +
                "  Chinese\n" +
                "\n" +
                "China Express\n" +
                "  1235 E Grove Ave, Rantoul 61866\n" +
                "  Chinese\n" +
                "\n" +
                "Super Wok\n" +
                "  202 N Market St, Paxton 60957\n" +
                "  Chinese\n" +
                "\n" +
                "Home of Gourmet Chinese & Thai Restaurant\n" +
                "  604 E Daniel St, Champaign 61820\n" +
                "  Chinese, Thai\n" +
                "\n" +
                "Sunny Chinese Buffet\n" +
                "  1703 Philo Rd, Urbana 61802\n" +
                "  Chinese\n" +
                "\n", restaurantsCampaignChinese);
    }

    @Test
    public void getRestaurantsWithMultipleCuisines() throws Exception {
        assertEquals("Golden Harbor\n" +
                "  505 S Neil St, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "Cravings\n" +
                "  603 S Wright St, Champaign 61820\n" +
                "  Asian, Chinese\n" +
                "\n" +
                "First Wok\n" +
                "  1805 Philo Rd, Urbana 61802\n" +
                "  Chinese\n" +
                "\n" +
                "Rainbow Garden\n" +
                "  1402 S Neil St Ste 3, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "Wok\n" +
                "  703 Eastwood Dr, Mahomet 61853\n" +
                "  Chinese\n" +
                "\n" +
                "Green Jade\n" +
                "  1109 Windsor Rd, Champaign 61821\n" +
                "  Chinese\n" +
                "\n" +
                "Chopstix\n" +
                "  202 E Green st, Champaign 61820\n" +
                "  Asian, Chinese\n" +
                "\n" +
                "Empire\n" +
                "  410 E Green St, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "Peking House Restaurant\n" +
                "  806 E Franklin St, Mahomet 61853\n" +
                "  Chinese\n" +
                "\n" +
                "Ming Garden\n" +
                "  1804 Sangamon Dr, Champaign 61821\n" +
                "  Chinese\n" +
                "\n" +
                "Peking Garden Restaurant\n" +
                "  206 N Randolph St Ste 1, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "Golden Wok\n" +
                "  405 E University Ave, Champaign 61820\n" +
                "  Chinese, Thai\n" +
                "\n" +
                "China Garden\n" +
                "  114 N Vine St, Urbana 61802\n" +
                "  Chinese\n" +
                "\n" +
                "Lai Lai Wok\n" +
                "  402 E Green St, Champaign 61820\n" +
                "  Chinese, Thai\n" +
                "\n" +
                "China King\n" +
                "  2145 S Neil St, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "China King\n" +
                "  205 W Warren St, St Joseph 61873\n" +
                "  Chinese\n" +
                "\n" +
                "China Express\n" +
                "  1235 E Grove Ave, Rantoul 61866\n" +
                "  Chinese\n" +
                "\n" +
                "Super Wok\n" +
                "  202 N Market St, Paxton 60957\n" +
                "  Chinese\n" +
                "\n" +
                "Home of Gourmet Chinese & Thai Restaurant\n" +
                "  604 E Daniel St, Champaign 61820\n" +
                "  Chinese, Thai\n" +
                "\n" +
                "Sunny Chinese Buffet\n" +
                "  1703 Philo Rd, Urbana 61802\n" +
                "  Chinese\n" +
                "\n" +
                "Dos Reales\n" +
                "  1407 N Prospect Ave, Champaign 61820\n" +
                "  Mexican\n" +
                "\n" +
                "Huaraches Moroleon\n" +
                "  805 S Philo Rd, Urbana 61801\n" +
                "  Mexican\n" +
                "\n" +
                "Maize Mexican Grill\n" +
                "  60 E Green St, Champaign 61820\n" +
                "  Mexican\n" +
                "\n" +
                "El Toro II\n" +
                "  723 S Neil St, Champaign 61820\n" +
                "  Mexican\n" +
                "\n" +
                "Cactus Grill\n" +
                "  1405 S Neil St, Champaign 61820\n" +
                "  Mexican, Southwestern, Tex-Mex\n" +
                "\n" +
                "La Bamba Burritos\n" +
                "  1905 Glen Park Dr, Champaign 61821\n" +
                "  Mexican\n" +
                "\n" +
                "Sol Azteca\n" +
                "  405 S Century Blvd, Rantoul 61866\n" +
                "  Mexican\n" +
                "\n" +
                "Fiesta Cafe\n" +
                "  216 S 1st St, Champaign 61820\n" +
                "  Mexican\n" +
                "\n" +
                "Toro Loco\n" +
                "  1601 N Cunningham Ave, Urbana 61802\n" +
                "  Mexican\n" +
                "\n" +
                "El Charro Mexican Grocery & Taqueria\n" +
                "  55 E Green St, Champaign 61820\n" +
                "  Mexican\n" +
                "\n" +
                "Wedge Bar\n" +
                "  415 N Neil St, Champaign 61820\n" +
                "  Mexican, Tapas\n" +
                "\n" +
                "Los Zarapes\n" +
                "  840 Eastwood Drive, Mahomet 61853\n" +
                "  Mexican\n" +
                "\n" +
                "Los Potros\n" +
                "  208 N Parke St, Tuscola 61953\n" +
                "  Mexican\n" +
                "\n" +
                "Panchero's Mexican Grill\n" +
                "  102 E. Unversity Ave., Urbana 61801\n" +
                "  Mexican\n" +
                "\n" +
                "Burrito King\n" +
                "  408 E Green Street 61820\n" +
                "  Mexican\n" +
                "\n" +
                "Super Taco\n" +
                "  523 W Town Center Blvd, Champaign 61822\n" +
                "  Breakfast, Mexican\n" +
                "\n" +
                "El Toro\n" +
                "  112 Charter Street, Monticello 61856\n" +
                "  Mexican\n" +
                "\n" +
                "Los Toros\n" +
                "  1204 Bear Ln, Monticello 61856\n" +
                "  Mexican\n" +
                "\n" +
                "El Toro Mexican Restaurant\n" +
                "  221 Lincoln Street, St Joseph 61873\n" +
                "  Mexican\n" +
                "\n" +
                "Pueblo Lindo: Authentic Mexican Restaurant\n" +
                "  124 W State St, Paxton 60957\n" +
                "  Mexican, Southwestern\n" +
                "\n", restaurantsCampaignChineseMexican);
    }

    @Test
    public void getAllRestaurantsByCityAndCuisine() throws Exception {
        assertEquals("Golden Harbor\n" +
                "  505 S Neil St, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "Cravings\n" +
                "  603 S Wright St, Champaign 61820\n" +
                "  Asian, Chinese\n" +
                "\n" +
                "First Wok\n" +
                "  1805 Philo Rd, Urbana 61802\n" +
                "  Chinese\n" +
                "\n" +
                "Rainbow Garden\n" +
                "  1402 S Neil St Ste 3, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "Wok\n" +
                "  703 Eastwood Dr, Mahomet 61853\n" +
                "  Chinese\n" +
                "\n" +
                "Green Jade\n" +
                "  1109 Windsor Rd, Champaign 61821\n" +
                "  Chinese\n" +
                "\n" +
                "Chopstix\n" +
                "  202 E Green st, Champaign 61820\n" +
                "  Asian, Chinese\n" +
                "\n" +
                "Empire\n" +
                "  410 E Green St, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "Peking House Restaurant\n" +
                "  806 E Franklin St, Mahomet 61853\n" +
                "  Chinese\n" +
                "\n" +
                "Ming Garden\n" +
                "  1804 Sangamon Dr, Champaign 61821\n" +
                "  Chinese\n" +
                "\n" +
                "Peking Garden Restaurant\n" +
                "  206 N Randolph St Ste 1, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "Golden Wok\n" +
                "  405 E University Ave, Champaign 61820\n" +
                "  Chinese, Thai\n" +
                "\n" +
                "China Garden\n" +
                "  114 N Vine St, Urbana 61802\n" +
                "  Chinese\n" +
                "\n" +
                "Lai Lai Wok\n" +
                "  402 E Green St, Champaign 61820\n" +
                "  Chinese, Thai\n" +
                "\n" +
                "China King\n" +
                "  2145 S Neil St, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "China King\n" +
                "  205 W Warren St, St Joseph 61873\n" +
                "  Chinese\n" +
                "\n" +
                "China Express\n" +
                "  1235 E Grove Ave, Rantoul 61866\n" +
                "  Chinese\n" +
                "\n" +
                "Super Wok\n" +
                "  202 N Market St, Paxton 60957\n" +
                "  Chinese\n" +
                "\n" +
                "Home of Gourmet Chinese & Thai Restaurant\n" +
                "  604 E Daniel St, Champaign 61820\n" +
                "  Chinese, Thai\n" +
                "\n" +
                "Sunny Chinese Buffet\n" +
                "  1703 Philo Rd, Urbana 61802\n" +
                "  Chinese\n" +
                "\n", restaurantsCampaignChineseFull);
    }

    @Test
    public void getAllRestaurantsWithMultipleCuisines() throws Exception {
        assertEquals("Golden Harbor\n" +
                "  505 S Neil St, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "Cravings\n" +
                "  603 S Wright St, Champaign 61820\n" +
                "  Asian, Chinese\n" +
                "\n" +
                "First Wok\n" +
                "  1805 Philo Rd, Urbana 61802\n" +
                "  Chinese\n" +
                "\n" +
                "Rainbow Garden\n" +
                "  1402 S Neil St Ste 3, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "Wok\n" +
                "  703 Eastwood Dr, Mahomet 61853\n" +
                "  Chinese\n" +
                "\n" +
                "Green Jade\n" +
                "  1109 Windsor Rd, Champaign 61821\n" +
                "  Chinese\n" +
                "\n" +
                "Chopstix\n" +
                "  202 E Green st, Champaign 61820\n" +
                "  Asian, Chinese\n" +
                "\n" +
                "Empire\n" +
                "  410 E Green St, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "Peking House Restaurant\n" +
                "  806 E Franklin St, Mahomet 61853\n" +
                "  Chinese\n" +
                "\n" +
                "Ming Garden\n" +
                "  1804 Sangamon Dr, Champaign 61821\n" +
                "  Chinese\n" +
                "\n" +
                "Peking Garden Restaurant\n" +
                "  206 N Randolph St Ste 1, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "Golden Wok\n" +
                "  405 E University Ave, Champaign 61820\n" +
                "  Chinese, Thai\n" +
                "\n" +
                "China Garden\n" +
                "  114 N Vine St, Urbana 61802\n" +
                "  Chinese\n" +
                "\n" +
                "Lai Lai Wok\n" +
                "  402 E Green St, Champaign 61820\n" +
                "  Chinese, Thai\n" +
                "\n" +
                "China King\n" +
                "  2145 S Neil St, Champaign 61820\n" +
                "  Chinese\n" +
                "\n" +
                "China King\n" +
                "  205 W Warren St, St Joseph 61873\n" +
                "  Chinese\n" +
                "\n" +
                "China Express\n" +
                "  1235 E Grove Ave, Rantoul 61866\n" +
                "  Chinese\n" +
                "\n" +
                "Super Wok\n" +
                "  202 N Market St, Paxton 60957\n" +
                "  Chinese\n" +
                "\n" +
                "Home of Gourmet Chinese & Thai Restaurant\n" +
                "  604 E Daniel St, Champaign 61820\n" +
                "  Chinese, Thai\n" +
                "\n" +
                "Sunny Chinese Buffet\n" +
                "  1703 Philo Rd, Urbana 61802\n" +
                "  Chinese\n" +
                "\n" +
                "Dos Reales\n" +
                "  1407 N Prospect Ave, Champaign 61820\n" +
                "  Mexican\n" +
                "\n" +
                "Huaraches Moroleon\n" +
                "  805 S Philo Rd, Urbana 61801\n" +
                "  Mexican\n" +
                "\n" +
                "Maize Mexican Grill\n" +
                "  60 E Green St, Champaign 61820\n" +
                "  Mexican\n" +
                "\n" +
                "El Toro II\n" +
                "  723 S Neil St, Champaign 61820\n" +
                "  Mexican\n" +
                "\n" +
                "Cactus Grill\n" +
                "  1405 S Neil St, Champaign 61820\n" +
                "  Mexican, Southwestern, Tex-Mex\n" +
                "\n" +
                "La Bamba Burritos\n" +
                "  1905 Glen Park Dr, Champaign 61821\n" +
                "  Mexican\n" +
                "\n" +
                "Sol Azteca\n" +
                "  405 S Century Blvd, Rantoul 61866\n" +
                "  Mexican\n" +
                "\n" +
                "Fiesta Cafe\n" +
                "  216 S 1st St, Champaign 61820\n" +
                "  Mexican\n" +
                "\n" +
                "Toro Loco\n" +
                "  1601 N Cunningham Ave, Urbana 61802\n" +
                "  Mexican\n" +
                "\n" +
                "El Charro Mexican Grocery & Taqueria\n" +
                "  55 E Green St, Champaign 61820\n" +
                "  Mexican\n" +
                "\n" +
                "Wedge Bar\n" +
                "  415 N Neil St, Champaign 61820\n" +
                "  Mexican, Tapas\n" +
                "\n" +
                "Los Zarapes\n" +
                "  840 Eastwood Drive, Mahomet 61853\n" +
                "  Mexican\n" +
                "\n" +
                "Los Potros\n" +
                "  208 N Parke St, Tuscola 61953\n" +
                "  Mexican\n" +
                "\n" +
                "Panchero's Mexican Grill\n" +
                "  102 E. Unversity Ave., Urbana 61801\n" +
                "  Mexican\n" +
                "\n" +
                "Burrito King\n" +
                "  408 E Green Street 61820\n" +
                "  Mexican\n" +
                "\n" +
                "Super Taco\n" +
                "  523 W Town Center Blvd, Champaign 61822\n" +
                "  Breakfast, Mexican\n" +
                "\n" +
                "El Toro\n" +
                "  112 Charter Street, Monticello 61856\n" +
                "  Mexican\n" +
                "\n" +
                "Los Toros\n" +
                "  1204 Bear Ln, Monticello 61856\n" +
                "  Mexican\n" +
                "\n" +
                "El Toro Mexican Restaurant\n" +
                "  221 Lincoln Street, St Joseph 61873\n" +
                "  Mexican\n" +
                "\n" +
                "Pueblo Lindo: Authentic Mexican Restaurant\n" +
                "  124 W State St, Paxton 60957\n" +
                "  Mexican, Southwestern\n" +
                "\n", restaurantsCampaignChineseMexicanFull);
    }
}