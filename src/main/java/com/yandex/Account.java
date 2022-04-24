package com.yandex;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    @Step("Data Validity Check with")
    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
    int spaces =name.length()-name.replace(" ", "").length();
    if (name != null && name.length()>= 3 && name.length()<=19 && !name.startsWith(" ") && !name.endsWith(" ") && spaces==1){
        return true;
        }
        return false;
    }
}
