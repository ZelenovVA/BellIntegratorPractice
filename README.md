# Bell Integrator Practivce API.
Полная документация доступна по адресу: [http://localhost:8888/swagger-ui.html/](http://localhost:8888/swagger-ui.html#/)

Данное приложение позволяет управлять данными организаций, а также данными офисов, принадллежащих данным организациям, 
и данными пользователей, которые закреплены за определенным офисом.
____
## Операции над данными организаций:
____
* **Получить список всех организаций по определенному фильтру.**
Данная операция выполняется по адресу */api/organization/list* методом POST. В теле запроса должен быть фильтр (объект JSON), по которому ведется поиск организаций:

![Alt-orgFilterIn](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/organization/OrgListIn.PNG)

В результате успешного выполнения операции придет ответ от сервера с телом вида:

![Alt-orgFilterOut](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/organization/OrgListOut.PNG)

В результате ошибки придет ответ от сервера с телом вида:

![Alt-error](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)
____

* **Получить организацию по уникальному идентификатору(id).**
Данная операция выполняется по адресу */api/organization/{id}* методом GET, где id - уникальный идентификатор организации. 
В результате успешного выполнения операции придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/organization/OrgId.PNG)

В результате ошибки придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)
____

* **Изменить данные определенной организации.**
Данная операция выполняется по адресу */api/organization/update* методом POST. В теле запроса должен быть объект изменения данных организации (объект JSON):

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/organization/OrgUpdate.PNG)

В результате успешного выполнения операции придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Success.PNG)

В результате ошибки придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)
____

* **Сохранить новую организацию.**
Данная операция выполняется по адресу */api/organization/save* методом POST. В теле запроса должен быть объект сохранения данных организации (объект JSON):

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/organization/OrgSave.PNG)

В результате успешного выполнения операции придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Success.PNG)

В результате ошибки придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)


____
## Операции над данными офисов:
____
* **Получить список всех офисов по определенному фильтру.**
Данная операция выполняется по адресу */api/office/list* методом POST. В теле запроса должен быть фильтр (объект JSON), по которому ведется поиск офиса:

![Alt-officeFilterIn](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/office/OfficeListIn.PNG)

В результате успешного выполнения операции придет ответ от сервера с телом вида:

![Alt-officeFilterOut](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/office/OfficeListOut.PNG)

В результате ошибки придет ответ от сервера с телом вида:

![Alt-error](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)
____

* **Получить офис по уникальному идентификатору(id).**
Данная операция выполняется по адресу */api/office/{id}* методом GET, где id - уникальный идентификатор офиса. 
В результате успешного выполнения операции придет ответ от сервера с телом вида:

![Alt-officeId](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/office/OfficeId.PNG)

В результате ошибки придет ответ от сервера с телом вида:

![Alt-error](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)
____

* **Изменить данные определенного офиса.**
Данная операция выполняется по адресу */api/office/update* методом POST. В теле запроса должен быть объект изменения данных офиса (объект JSON):
В результате успешного выполнения операции придет ответ от сервера с телом вида:

![Alt-officeUpdate](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/office/OfficeUpdateView.PNG)

В результате успешной выполнении операции придет ответ от сервера с телом вида:

![Alt-success](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Success.PNG)

В результате ошибки придет ответ от сервера с телом вида:

![Alt-error](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)
____

* Сохранить новый офис.
Данная операция выполняется по адресу */api/office/save* методом POST. В теле запроса должен быть объект сохранения данных офиса (объект JSON).

![Alt-officeSave](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/office/OfficeSave.PNG)

В результате успешной выполнении операции придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Success.PNG)

В результате ошибки придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)


____
## Операции над данными пользователей:
____
* **Получить список всех пользователей по определенному фильтру.**
Данная операция выполняется по адресу */api/office/list* методом POST. В теле запроса должен быть фильтр (объект JSON), по которому ведется поиск пользователя:

![Alt-userFilterIn](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/user/UserListOutV2.PNG)

В результате успешной выполнении операции придет ответ от сервера с телом вида:

![Alt-userFilterOut](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/user/UserListOut.PNG)

В результате ошибки придет ответ от сервера с телом вида:

![Alt-error](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)
____

* **Получить пользователя по уникальному идентификатору(id).**
Данная операция выполняется по адресу */api/office/{id}* методом GET, где id - уникальный идентификатор пользователя. 

![Alt-userId](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/user/UserId.PNG)

В результате ошибки придет ответ от сервера с телом вида:

![Alt-error](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)
____

* **Изменить данные определенного пользователя.**
Данная операция выполняется по адресу */api/office/update* методом POST. В теле запроса должен быть объект изменения данных пользователя (объект JSON).

![Alt-userUpdate](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/user/UserUpdate.PNG)

В результате успешного выполнения операции придет ответ от сервера с телом вида:

![Alt-success](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Success.PNG)

В результате ошибки придет ответ от сервера с телом вида:

![Alt-error](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)
____

* **Сохранить нового пользователя.**
Данная операция выполняется по адресу */api/office/save* методом POST. В теле запроса должен быть объект сохранения данных пользователя (объект JSON).

![Alt-userSave](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/user/UserSave.PNG)

В результате успешного выполнения операции придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Success.PNG)

В результате ошибки придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)



____
## Справочники.
____

### Справочник гражданств.
Содержит в себе список кодов государств и соответствующих данному коду названий государств. Доступен по адресу */api/office/countries*.

В результате выполнения операции придет ответ от сервера с телом вида:

![Alt-countries](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/countries/Country.PNG)

### Справочник типов документов, удостоверяющих личность.
Содержит в себе список кодов документов, удостоверяющих личность пользователя и соответствующих данному коду названий документов. Доступен по адресу */api/office/docs*.

В результате выполнения операции придет ответ от сервера с телом вида:

![Alt-docs](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/docs/Docs.PNG)
