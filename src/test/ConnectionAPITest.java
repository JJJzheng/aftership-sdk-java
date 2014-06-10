package test;

import code.*;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class ConnectionAPITest {

    @Test
    public void testGetCouriers() throws Exception {

        ConnectionAPI connection = new ConnectionAPI("");
        List<Courier> couriers = connection.getCouriers();
        //total Couriers returned
        assertEquals("It should return 189 couriers", 189, couriers.size());
        /* First Courier
        {"slug":"india-post-int","name":"India Post International","phone":"+91 1800 11 2011",
        "other_name":"भारतीय डाक, Speed Post & eMO, EMS, IPS Web","web_url":"http://www.indiapost.gov.in/"}
        */
        assertEquals("First courier slug be india-post-int","india-post-int",couriers.get(0).getSlug());
        assertEquals("First courier name be India Post International","India Post International",couriers.get(0).getName());
        assertEquals("First courier phone be +91 1800 11 2011","+91 1800 11 2011",couriers.get(0).getPhone());
        assertEquals("First courier other_name should be भारतीय डाक, Speed Post & eMO, EMS, IPS Web","भारतीय डाक, Speed Post & eMO, EMS, IPS Web",couriers.get(0).getOther_name());
        assertEquals("First courier web_url be http://www.indiapost.gov.in/","http://www.indiapost.gov.in/",couriers.get(0).getWeb_url());
        /* Last Courier
        {"slug":"la-poste-colissimo","name":"La Poste Colissimo","phone":"+33 3631","other_name":"Coliposte",
        "web_url":"http://www.csuivi.courrier.laposte.fr"}
        */
        assertEquals("Last courier slug be la-poste-colissimo","la-poste-colissimo",couriers.get(188).getSlug());
        assertEquals("Last courier name be La Poste Colissimo","La Poste Colissimo",couriers.get(188).getName());
        assertEquals("Last courier phone be +33 3631","+33 3631",couriers.get(188).getPhone());
        assertEquals("Last courier other_name should be Coliposte","Coliposte",couriers.get(188).getOther_name());
        assertEquals("Last courier web_url be http://www.csuivi.courrier.laposte.fr","http://www.csuivi.courrier.laposte.fr",couriers.get(188).getWeb_url());
    }
}