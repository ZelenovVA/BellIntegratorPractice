-- Таблица гражданств --
CREATE TABLE IF NOT EXISTS Country
(
citizenship_code INTEGER COMMENT 'Код государтсва',
citizenship_name VARCHAR (100) COMMENT 'Название государтсва',

CONSTRAINT PK_country_citizenship_code PRIMARY KEY Country(citizenship_code)
);
COMMENT ON TABLE Country AS 'Гражданство';

-----------------------------------------------------------------------------

-- Таблица типов документов, удостоверяющих личность --
CREATE TABLE IF NOT EXISTS DocumentType
(
doc_code INTEGER COMMENT 'Код документа',
doc_name VARCHAR (100) NOT NULL COMMENT 'Наименование документа',

CONSTRAINT PK_DocumentType_doc_code PRIMARY KEY DocumentType(doc_code)
);
COMMENT ON TABLE DocumentType AS 'Тип документа';

-----------------------------------------------------------------------------

-- Таблица документов, удостоверяющих личность --
CREATE TABLE IF NOT EXISTS Document
(
id IDENTITY COMMENT 'Уникальный идентификатор документа',
version INTEGER NOT NULL COMMENT 'Служебное поле Hibernate',
doc_number varchar(10) COMMENT 'Номер документа',
doc_date DATE COMMENT 'Дата выдачи документа',
doc_type_code INTEGER COMMENT 'Код документа',

CONSTRAINT PK_Document_id PRIMARY KEY Document(id),
CONSTRAINT FK_Document_doc_type_code FOREIGN KEY Document(doc_type_code) REFERENCES ON DocumentType(doc_code)
);
CREATE INDEX UX_Document_id ON Document(id);
CREATE INDEX UX_Document_doc_type_code ON Document(doc_type_code);
COMMENT ON TABLE Document AS 'Документ';

--------------------------------------------------------------------------------------------------------------

-- Таблица пользователей --
CREATE TABLE IF NOT EXISTS User
(
id IDENTITY COMMENT 'Уникальный идентификатор пользователя',
version INTEGER NOT NULL COMMENT 'Служебное поле Hibernate',
first_name VARCHAR (50) NOT NULL COMMENT 'Имя пользователя',
second_name VARCHAR (50) COMMENT 'Фамилия пользователя',
middle_name VARCHAR (50) COMMENT 'Отчество пользователя',
position VARCHAR (100) NOT NULL COMMENT 'Должность',
phone VARCHAR (11) COMMENT 'Контактный номер телефона',
is_identified BOOLEAN default true COMMENT 'Флаг идентификации',
office_id BIGINT COMMENT 'Уникальный идентификатор офиса',
doc_id BIGINT COMMENT 'Документ, удостоверяющий личности',

CONSTRAINT PK_User_id PRIMARY KEY User(id),
CONSTRAINT FK_User_doc_id FOREIGN KEY User(doc_id) REFERENCES ON Document(doc_id),
CONSTRAINT FK_User_office_id FOREIGN KEY User(office_id) REFERENCES ON Office(id)
);
CREATE INDEX UX_User_id ON User(id);
CREATE INDEX IX_User_office_id ON User(office_id);
CREATE INDEX IX_User_first_name ON User(first_name);
CREATE INDEX IX_User_last_name ON User(last_name);
CREATE INDEX IX_User_middle_name ON User(middle_name);
CREATE INDEX IX_User_position ON User(position);
COMMENT ON TABLE User AS 'Пользователь';

-----------------------------------------------------------------------------------------------

-- Таблица офисов --
CREATE TABLE IF NOT EXISTS Office
(
id IDENTITY COMMENT 'Уникальный идентификатор',
version INTEGER NOT NULL COMMENT 'Служебное поле Hibernate',
name VARCHAR (50) NOT NULL UNIQUE COMMENT 'Имя офиса',
address VARCHAR (100) NOT NULL COMMENT 'Адрем офиса',
phone VARCHAR (11) NOT NULL UNIQUE COMMENT 'Номер телефона офиса',
is_active BOOLEAN default true COMMENT 'Флаг активности',
organization_id BIGINT NOT NULL COMMENT 'Уникальный идентификатор организации',

CONSTRAINT PK_Office_id PRIMARY KEY Office(id),
CONSTRAINT FK_Office_organization_id FOREIGN KEY Office(organization_id) REFERENCES ON Organization(id)
);
CREATE INDEX UX_Office_id ON Office(id);
CREATE INDEX IX_Office_organization_id ON Office(organization_id);
CREATE INDEX UX_Office_name ON Office(name);
CREATE INDEX UX_Office_phone ON Office(phone);
CREATE INDEX IX_Office_is_active ON Office(is_active);
COMMENT ON TABLE Office AS 'Офис';

-----------------------------------------------------------------------------------------------

--Таблица организаций --
CREATE TABLE IF NOT EXISTS Organization
(
id IDENTITY COMMENT 'Уникальный идентификатор',
version INTEGER NOT NULL COMMENT 'Служебное поле Hibernate',
name VARCHAR (50) NOT NULL UNIQUE COMMENT 'Имя организации',
full_name VARCHAR (100) NOT NULL COMMENT 'Полное название организации',
inn VARCHAR(12) NOT NULL UNIQUE COMMENT 'ИНН организации',
kpp VARCHAR(9) NOT NULL UNIQUE COMMENT 'КПП организации',
address VARCHAR (100) NOT NULL COMMENT 'Юридический адрес организации',
phone VARCHAR (11) COMMENT 'Номер телефона организации',
is_active BOOLEAN default true COMMENT 'Флаг активности',

CONSTRAINT PK_Organization_id PRIMARY KEY Organization(id),
);
CREATE INDEX UX_Organization_name ON Organization(name);
CREATE INDEX UX_Organization_inn ON Organization(inn);
CREATE INDEX IX_Organization_is_active ON Organization(is_active);
COMMENT ON TABLE Organization AS 'Организация';