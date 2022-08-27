package com.Hexaware.CMS.Factory;

import com.Hexaware.CMS.Model.Vendor;
import com.Hexaware.CMS.Persistence.VendorDB;

public class VendorFactory {
   
    public static Vendor retrieveById(int id) {
        Vendor sm = VendorDB.getVendorById(id);
        return sm;
    }

    public static Vendor retrieveByEmail(String em) {
        Vendor sm = VendorDB.getVendorByEmail(em);
        return sm;
    }

    public static int updateRating(int id, int rating) {
        int res = VendorDB.updateRating(id, rating);
        return res;
    }
}
