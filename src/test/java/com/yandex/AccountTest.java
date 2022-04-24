package com.yandex;

import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
    public class AccountTest {
        private final String name;
        private final boolean expected;
        private final String discription;

    public AccountTest(String name, boolean expected, String discription) {
        this.name = name;
        this.expected = expected;
        this.discription = discription;
    }

@Parameterized.Parameters
    public static Object[][] getNameValidation(){
        return new Object[][]{
                {"Тимоти Шаламе", true, "Количество символов и пробелов соответствует требованиям"},
                {"Ти", false, "Количество символов не соответствует требованиям"},
                {"Т Ш", true, "Количество символов и пробелов соответствует требованиям"},
                {"ШаламеТимоти ШаламеТимоти", false, "Количество символов не соответствует требованиям"},
                {"Тимоти ШаламеТимоти", true, "Количество символов и пробелов соответствует требованиям"},
                {" Тимоти Шаламе", false, "Количество пробелов не соответствует требованиям"},
                {"Тимоти Шаламе ", false, "Количество пробелов не соответствует требованиям"},
                {"Тимоти  Шаламе", false, "Количество пробелов не соответствует требованиям"},
                {"Тим оти Шаламе", false, "Количество пробелов не соответствует требованиям"},
                {"Тимоти_Шаламе", false, "Количество пробелов не соответствует требованиям"},
                {"ТимотиШаламе", false, "Количество пробелов не соответствует требованиям"},
                {"", false, "Пустая строка не соответствует требованиям"},//
                {null, false, "Отсутствие данных не соответствует требованиям"},//
        };
}
@Test
@DisplayName("Checking the validity of a name when passing different values")
    public void nameShouldBeValidated(){
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        Allure.addAttachment("Имя: ", name);
        Allure.addAttachment("Описание: ", discription);
        assertEquals(expected, actual);
}
}
