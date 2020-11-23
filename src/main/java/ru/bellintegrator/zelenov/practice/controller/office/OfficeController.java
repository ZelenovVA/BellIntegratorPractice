package ru.bellintegrator.zelenov.practice.controller.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.zelenov.practice.service.office.OfficeService;
import ru.bellintegrator.zelenov.practice.view.office.OfficeListViewIn;
import ru.bellintegrator.zelenov.practice.view.office.OfficeListViewOut;
import ru.bellintegrator.zelenov.practice.view.office.OfficeSaveView;
import ru.bellintegrator.zelenov.practice.view.office.OfficeUpdateView;
import ru.bellintegrator.zelenov.practice.view.office.OfficeViewById;

import java.util.List;

/**
 * Контроллер для работы с офисом
 */
@RestController
@RequestMapping(value = "/api/office/", produces = MediaType.APPLICATION_JSON_VALUE)
public class OfficeController {
    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    /**
     * Получение списка офисов по фильтру
     * @param officeListViewIn фильтр
     * @return список офисов
     */
    @PostMapping("list")
    public List<OfficeListViewOut> getAllOffices(@RequestBody OfficeListViewIn officeListViewIn){
        return officeService.getAllOffices(officeListViewIn);
    }

    /**
     * Получение офиса по уникальному идентификатору
     * @param id уникальный идентификатор офиса
     * @return офис, соответствующий уникальному идентификатору
     */
    @GetMapping("{id}")
    public OfficeViewById getOfficeById(@PathVariable("id") Long id){
        return officeService.getOfficeById(id);
    }

    /**
     * Изменение данных офиса
     * @param officeUpdateView офис, данные которого требуется изменить
     * @return
     */
    @PostMapping("update")
    public void updateOffice(@RequestBody OfficeUpdateView officeUpdateView){
        officeService.updateOffice(officeUpdateView);
    }

    /**
     * Сохранение нового офиса
     * @param officeSaveView офис, который требуется сохранить
     * @return
     */
    @PostMapping("save")
    public void saveOffice(@RequestBody OfficeSaveView officeSaveView){
        officeService.saveOffice(officeSaveView);
    }
}
