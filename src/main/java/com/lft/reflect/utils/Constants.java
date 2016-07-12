package com.lft.reflect.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leapfrog on 7/12/16.
 */
public class Constants {
    public static Map<String, String> pluralSingularMap = new HashMap<String, String>() {{
        put("students",    "student");
        put("behaviours", "behaviours");
        put("fancies",   "fancy");
    }};
}
