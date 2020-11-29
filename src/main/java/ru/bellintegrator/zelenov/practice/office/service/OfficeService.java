package ru.bellintegrator.zelenov.practice.office.service;

import org.springframework.stereotype.Service;
import ru.bellintegrator.zelenov.practice.office.view.OfficeListViewIn;
import ru.bellintegrator.zelenov.practice.office.view.OfficeListViewOut;
import ru.bellintegrator.zelenov.practice.office.view.OfficeSaveView;
import ru.bellintegrator.zelenov.practice.office.view.OfficeUpdateView;
import ru.bellintegrator.zelenov.practice.office.view.OfficeViewById;

import java.util.List;

/**
 * Сервисный слой для работы с офисом
 */
@Service
public interface OfficeService {

    /**
     * ПОлучение списка офисов по входящему фильтру
     *
     * @param filter фильтр
     * @return список офисов
     */
    List<OfficeListViewOut> getAllOffices(OfficeListViewIn filter);

    /**
     * Получение офиса по уникальному идентификатору
     *
     * @param id уникальный идентификатор офиса
     * @return офис, соответствующий уникальному идентификатору
     */
    OfficeViewById getOfficeById(Long id);

    /**
     * Изменение данных офиса
     *
     * @param officeUpdateView офис, данные которого нужно изменить
     */
    void updateOffice(OfficeUpdateView officeUpdateView);

    /**
     * Сохранение офиса
     *
     * @param officeSaveView офис, который трубуется сохранить
     */
    void saveOffice(OfficeSaveView officeSaveView);
}
