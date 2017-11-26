package com.doctoranywhere.app.parsers;



import com.doctoranywhere.app.constants.ParserConstants;
import com.doctoranywhere.app.models.UserResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UserParser {
    private ArrayList<UserResult> mUserResults = new ArrayList<>(50);

    public ArrayList<UserResult> getUserList(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONObject data = jsonObject.getJSONObject(ParserConstants.KEY_DATA);
            JSONArray users = data.getJSONArray(ParserConstants.KEY_USERS);


            for (int i = 0; i < users.length(); i++) {
                String name = users.getJSONObject(i).getString(ParserConstants.KEY_NAME);
                String imageUrl = users.getJSONObject(i).getString(ParserConstants.KEY_IMAGE);
                JSONArray items = users.getJSONObject(i).getJSONArray(ParserConstants.KEY_ITEMS);
                ArrayList<String> itemList = new ArrayList<>(10);
                for (int j = 0; j < items.length() ; j++) {
                    String itemUrl = items.getString(j);
                    itemList.add(itemUrl);
                }
                UserResult userResult = new UserResult(name, imageUrl, itemList);
                mUserResults.add(userResult);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mUserResults;
    }
}
