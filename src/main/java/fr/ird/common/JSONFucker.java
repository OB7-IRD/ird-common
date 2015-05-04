/*
 * $Id$
 *
 */
package fr.ird.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Classe utilitaire permettant la conversion d'une Map en objet JSON et
 * inversement.
 *
 * @see {@link https://gist.github.com/sheharyarn/cba56ff154de2cc62fc5}
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 * @since 1.1
 * @date 26 mars 2015
 *
 * $LastChangedDate$
 *
 * $LastChangedRevision$
 *
 */
public class JSONFucker {
    // HashMap > Map
    // ArrayList > List

    /**
     *
     *
     * @param object l'objet à convertir
     * @return le JSON ou l'objet d'entrée
     * @throws JSONException
     */
    public static Object toJSON(Object object) throws JSONException {
        if (object instanceof HashMap) {
            JSONObject json = new JSONObject();
            HashMap map = (HashMap) object;
            for (Object key : map.keySet()) {
                json.put(key.toString(), toJSON(map.get(key)));
            }
            return json;
        } else if (object instanceof Iterable) {
            JSONArray json = new JSONArray();
            for (Object value : ((Iterable) object)) {
                json.put(value);
            }
            return json;
        } else {
            return object;
        }
    }

    public static JSONObject toJSON(Map object) {
        JSONObject o = null;
        try {
            o = (JSONObject) toJSON((Object) object);
        } catch (JSONException ex) {
            Logger.getLogger(JSONFucker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }

    public static String stringify(JSONObject object) {
        if (object == null) {
            return null;
        }
        return object.toString();
    }

    public static boolean isEmptyObject(JSONObject object) {
        return object.names() == null;
    }

    public static HashMap<String, Object> getMap(JSONObject object, String key) throws JSONException {
        return toMap(object.getJSONObject(key));
    }

    public static ArrayList getList(JSONObject object, String key) throws JSONException {
        return toList(object.getJSONArray(key));
    }

    public static HashMap<String, Object> toMap(JSONObject object) throws JSONException {
        HashMap<String, Object> map = new HashMap();
        Iterator keys = object.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            map.put(key, fromJson(object.get(key)));
        }
        return map;
    }

    public static ArrayList toList(JSONArray array) throws JSONException {
        ArrayList list = new ArrayList();
        for (int i = 0; i < array.length(); i++) {
            list.add(fromJson(array.get(i)));
        }
        return list;
    }

    private static Object fromJson(Object json) throws JSONException {
        if (json == JSONObject.NULL) {
            return null;
        } else if (json instanceof JSONObject) {
            return toMap((JSONObject) json);
        } else if (json instanceof JSONArray) {
            return toList((JSONArray) json);
        } else {
            return json;
        }
    }
}
