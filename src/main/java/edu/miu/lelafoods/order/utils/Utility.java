package edu.miu.lelafoods.order.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Utility {
    public String cartToJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String cartJson = "";
        try {
            cartJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            System.out.println(object.getClass().getSimpleName() + " Object to Json converted: " + cartJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cartJson;
    }
}
