# Bell Integrator Practivce API.
Полная документация доступна по адресу: :link: [http://localhost:8888/swagger-ui.html/](http://localhost:8888/swagger-ui.html#/)

Данное приложение позволяет управлять данными организаций, а также данными офисов, принадлежащих данным организациям, 
и данными пользователей, которые закреплены за определенным офисом.
____
## :one: Операции над данными организаций:
____
:black_circle: **Получить список всех организаций по определенному фильтру.**

Данная операция выполняется по адресу */api/organization/list* методом POST. В теле запроса должен быть фильтр (объект JSON), по которому ведется поиск организаций:

![Alt-orgFilterIn](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/organization/OrgListIn.PNG)

:ok: В результате успешного выполнения операции придет ответ от сервера с телом вида:

![Alt-orgFilterOut](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/organization/OrgListOut.PNG)

:x: В результате ошибки придет ответ от сервера с телом вида:

![Alt-error](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)
____

:black_circle: **Получить организацию по уникальному идентификатору(id).**

Данная операция выполняется по адресу */api/organization/{id}* методом GET, где id - уникальный идентификатор организации.

:ok: В результате успешного выполнения операции придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/organization/OrgId.PNG)

:x: В результате ошибки придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)
____

:black_circle: **Изменить данные определенной организации.**

Данная операция выполняется по адресу */api/organization/update* методом POST. В теле запроса должен быть объект изменения данных организации (объект JSON):

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/organization/OrgUpdate.PNG)

:ok: В результате успешного выполнения операции придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Success.PNG)

:x: В результате ошибки придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)
____

:black_circle: **Сохранить новую организацию.**
Данная операция выполняется по адресу */api/organization/save* методом POST. В теле запроса должен быть объект сохранения данных организации (объект JSON):

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/organization/OrgSave.PNG)

:ok: В результате успешного выполнения операции придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Success.PNG)

:x: В результате ошибки придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)


____
## :two: Операции над данными офисов:
____
:black_circle: **Получить список всех офисов по определенному фильтру.**

Данная операция выполняется по адресу */api/office/list* методом POST. В теле запроса должен быть фильтр (объект JSON), по которому ведется поиск офиса:

![Alt-officeFilterIn](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/office/OfficeListIn.PNG)

:ok: В результате успешного выполнения операции придет ответ от сервера с телом вида:

![Alt-officeFilterOut](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/office/OfficeListOut.PNG)

:x: В результате ошибки придет ответ от сервера с телом вида:

![Alt-error](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)
____

:black_circle: **Получить офис по уникальному идентификатору(id).**

Данная операция выполняется по адресу */api/office/{id}* методом GET, где id - уникальный идентификатор офиса. 

:ok: В результате успешного выполнения операции придет ответ от сервера с телом вида:

![Alt-officeId](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/office/OfficeId.PNG)

:x: В результате ошибки придет ответ от сервера с телом вида:

![Alt-error](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)
____

:black_circle: **Изменить данные определенного офиса.**

Данная операция выполняется по адресу */api/office/update* методом POST. В теле запроса должен быть объект изменения данных офиса (объект JSON):

![Alt-officeUpdate](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/office/OfficeUpdateView.PNG)

:ok: В результате успешной выполнении операции придет ответ от сервера с телом вида:

![Alt-success](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Success.PNG)

:x: В результате ошибки придет ответ от сервера с телом вида:

![Alt-error](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)
____

:black_circle: **Сохранить новый офис.**

Данная операция выполняется по адресу */api/office/save* методом POST. В теле запроса должен быть объект сохранения данных офиса (объект JSON).

![Alt-officeSave](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/office/OfficeSave.PNG)

:ok: В результате успешной выполнении операции придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Success.PNG)

:x: В результате ошибки придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)


____
## :three: Операции над данными пользователей:
____
:black_circle: **Получить список всех пользователей по определенному фильтру.**

Данная операция выполняется по адресу */api/user/list* методом POST. В теле запроса должен быть фильтр (объект JSON), по которому ведется поиск пользователя:

![Alt-userFilterIn](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/user/UserListIn.PNG)

:ok: В результате успешной выполнении операции придет ответ от сервера с телом вида:

![Alt-userFilterOut](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/user/UserListOutV2.PNG)

:x: В результате ошибки придет ответ от сервера с телом вида:

![Alt-error](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)
____

:black_circle: **Получить пользователя по уникальному идентификатору(id).**

Данная операция выполняется по адресу */api/user/{id}* методом GET, где id - уникальный идентификатор пользователя. 

:ok: В результате успешного выполнения операции придет ответ от сервера с телом вида:

![Alt-userId](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/user/UserId.PNG)

:x: В результате ошибки придет ответ от сервера с телом вида:

![Alt-error](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)
____

:black_circle: **Изменить данные определенного пользователя.**

Данная операция выполняется по адресу */api/user/update* методом POST. В теле запроса должен быть объект изменения данных пользователя (объект JSON).

![Alt-userUpdate](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/user/UserUpdate.PNG)

:ok: В результате успешного выполнения операции придет ответ от сервера с телом вида:

![Alt-success](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Success.PNG)

:x: В результате ошибки придет ответ от сервера с телом вида:

![Alt-error](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)
____

:black_circle: **Сохранить нового пользователя.**
Данная операция выполняется по адресу */api/user/save* методом POST. В теле запроса должен быть объект сохранения данных пользователя (объект JSON).

![Alt-userSave](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/user/UserSave.PNG)

:ok: В результате успешного выполнения операции придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Success.PNG)

:x: В результате ошибки придет ответ от сервера с телом вида:

![Alt-orgFilter](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/successAndError/Error.PNG)



____
## :four: Справочники.
____

### Справочник гражданств.
Содержит в себе список кодов государств и соответствующих данному коду названий государств. Доступен по адресу */api/office/countries*.

:ok: В результате выполнения операции придет ответ от сервера с телом вида:

![Alt-countries](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/countries/Country.PNG)

### Справочник типов документов, удостоверяющих личность.
Содержит в себе список кодов документов, удостоверяющих личность пользователя и соответствующих данному коду названий документов. Доступен по адресу */api/office/docs*.

:ok: В результате выполнения операции придет ответ от сервера с телом вида:

![Alt-docs](https://github.com/ZelenovVA/BellIntegratorPractice/blob/master/screenshorts/docs/Docs.PNG)
