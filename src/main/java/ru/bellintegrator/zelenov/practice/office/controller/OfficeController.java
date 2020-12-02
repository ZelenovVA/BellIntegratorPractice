package ru.bellintegrator.zelenov.practice.office.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.zelenov.practice.office.service.OfficeService;
import ru.bellintegrator.zelenov.practice.office.view.OfficeListViewIn;
import ru.bellintegrator.zelenov.practice.office.view.OfficeListViewOut;
import ru.bellintegrator.zelenov.practice.office.view.OfficeSaveView;
import ru.bellintegrator.zelenov.practice.office.view.OfficeUpdateView;
import ru.bellintegrator.zelenov.practice.office.view.OfficeViewById;

import javax.validation.Valid;
import java.util.List;

/**
 * Контроллер для работы с офисом
 */
@RestController
@RequestMapping(value = "/api/office/", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Office")
public class OfficeController {
    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    /**
     * Получение списка офисов по фильтру
     *
     * @param officeListViewIn фильтр
     * @return список офисов
     */
    @PostMapping("list")
    @ApiOperation(value = "get all offices", httpMethod = "POST")
    public List<OfficeListViewOut> getAllOffices(@Valid @RequestBody OfficeListViewIn officeListViewIn) {
        return officeService.getAllOffices(officeListViewIn);
    }

    /**
     * Получение офиса по уникальному идентификатору
     *
     * @param id уникальный идентификатор офиса
     * @return офис, соответствующий уникальному идентификатору
     */
    @GetMapping("{id}")
    @ApiOperation(value = "Get office by id", httpMethod = "GET")
    public OfficeViewById getOfficeById(@PathVariable("id") Long id) {
        return officeService.getOfficeById(id);
    }

    /**
     * Изменение данных офиса
     *
     * @param officeUpdateView офис, данные которого требуется изменить
     * @return
     */
    @PostMapping("update")
    @ApiOperation(value = "Update office", httpMethod = "POST")
    public void updateOffice(@Valid @RequestBody OfficeUpdateView officeUpdateView) {
        officeService.updateOffice(officeUpdateView);
    }

    /**
     * Сохранение нового офиса
     *
     * @param officeSaveView офис, который требуется сохранить
     * @return
     */
    @PostMapping("save")
    @ApiOperation(value = "Save new office", httpMethod = "POST")
    public void saveOffice(@Valid @RequestBody OfficeSaveView officeSaveView) {
        officeService.saveOffice(officeSaveView);
    }
}
