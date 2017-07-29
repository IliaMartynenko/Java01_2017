package com.epam.likeit.bean;

import java.util.ListResourceBundle;

/**
 * Created by mts7072572 on 21.07.2017.
 */
public class Message extends ListResourceBundle {
    public Object[][] getContents() {
        return contents;
    }

    static final Object[][] contents = {
            {"main.title", "Musique sans frontiиres"},
            {"main.subhead", "Sons du village global"},
            {"main.addLabel", "Ajouter"},

            {"cd.quantityLabel", "Quantitй"}
    };
}

