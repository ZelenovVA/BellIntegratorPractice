package ru.bellintegrator.zelenov.practice.view.country;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * View объект гражданства для отправки клиенту
 */
public class CountryView {

    /**
     * Код страны
     */
    @Size(max = 5)
    @NotNull(message = "Данное поле не может быть пустым!")
    private String citizenshipCode;

    /**
     * Название страны
     */
    @Size(max = 100)
    @NotNull(message = "Данное поле не может быть пустым!")
    private String citizenshipName;
}
