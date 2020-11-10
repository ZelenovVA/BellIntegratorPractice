-- Таблица гражданств --
CREATE TABLE IF NOT EXISTS Country (
id INTEGER NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор' ,
version INTEGER COMMENT 'Служебное поле Hibernate',
citizenship_code VARCHAR(5) NOT NULL COMMENT 'Код государтсва',
citizenship_name VARCHAR (100) NOT NULL COMMENT 'Название государтсва',
CONSTRAINT PK_country_id PRIMARY KEY Country(id),
CREATE UNIQUE INDEX UX_Country_id ON Country(id);
COMMENT ON TABLE Country IS 'Гражданство';
-----------------------------------------------------------------------------
-- Таблица типов документов, удостоверяющих личность --
CREATE TABLE IF NOT EXISTS DocumentType(
id INTEGER NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор' ,
version INTEGER COMMENT 'Служебное поле Hibernate',
doc_code VARCHAR(5) NOT NULL COMMENT 'Код документа',
doc_name VARCHAR (150) NOT NULL COMMENT 'Наименование документа',
CONSTRAINT PK_DocumentType_id PRIMARY KEY DocumentType(id));
CREATE UNIQUE INDEX UX_DocumentType_id ON DocumentType(id);
COMMENT ON TABLE DocumentType IS 'Тип документа';
-----------------------------------------------------------------------------
--Таблица организаций --
CREATE TABLE IF NOT EXISTS Organization(
id INTEGER NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
version INTEGER COMMENT 'Служебное поле Hibernate',
name VARCHAR (50) NOT NULL COMMENT 'Имя организации',
full_name VARCHAR (100) NOT NULL COMMENT 'Полное название организации',
inn VARCHAR(12) NOT NULL COMMENT 'ИНН организации',
kpp VARCHAR(9) NOT NULL COMMENT 'КПП организации',
address VARCHAR (150) NOT NULL COMMENT 'Юридический адрес организации',
phone VARCHAR (11) COMMENT 'Номер телефона организации',
is_active BOOLEAN COMMENT 'Флаг активности',
CONSTRAINT PK_Organization_id PRIMARY KEY Organization(id));
CREATE UNIQUE INDEX UX_Organization_id ON Organization(id);
CREATE INDEX IX_Organization_name ON Organization(name);
CREATE INDEX IX_Organization_inn ON Organization(inn);
CREATE INDEX IX_Organization_is_active ON Organization(is_active);
COMMENT ON TABLE Organization IS 'Организация';
-----------------------------------------------------------------------------
-- Таблица офисов --
CREATE TABLE IF NOT EXISTS Office(
id INTEGER NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
version INTEGER COMMENT 'Служебное поле Hibernate',
name VARCHAR (50) COMMENT 'Имя офиса',
address VARCHAR (150) COMMENT 'Адрем офиса',
phone VARCHAR (11) COMMENT 'Номер телефона офиса',
is_active BOOLEAN default true COMMENT 'Флаг активности',
org_id INTEGER NOT NULL COMMENT 'Уникальный идентификатор организации',
CONSTRAINT PK_Office_id PRIMARY KEY Office(id),
CONSTRAINT FK_Office_org_id FOREIGN KEY Office(org_id) REFERENCES ON Organization(id));
CREATE UNIQUE INDEX UX_Office_id ON Office(id);
CREATE INDEX IX_Office_org_id ON Office(org_id);
CREATE INDEX IX_Office_name ON Office(name);
CREATE INDEX IX_Office_phone ON Office(phone);
CREATE INDEX IX_Office_is_active ON Office(is_active);
COMMENT ON TABLE Office IS 'Офис';
-----------------------------------------------------------------------------------------------
-- Таблица пользователей --
CREATE TABLE IF NOT EXISTS User(
id INTEGER NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор пользователя',
version INTEGER COMMENT 'Служебное поле Hibernate',
first_name VARCHAR (50) NOT NULL COMMENT 'Имя пользователя',
second_name VARCHAR (50) COMMENT 'Фамилия пользователя',
middle_name VARCHAR (50) COMMENT 'Отчество пользователя',
position VARCHAR (100) NOT NULL COMMENT 'Должность',
phone VARCHAR (11) COMMENT 'Контактный номер телефона',
is_identified BOOLEAN default true COMMENT 'Флаг идентификации',
office_id INTEGER NOT NULL COMMENT 'Уникальный идентификатор офиса',
country_id INTEGER NOT NULL COMMENT 'Уникальный идентификатор гражданства',
CONSTRAINT PK_User_id PRIMARY KEY User(id),
CONSTRAINT FK_User_office_id FOREIGN KEY User(office_id) REFERENCES ON Office(id)
CONSTRAINT FK_User_country_id FOREIGN KEY User(country_id) REFERENCES ON Country(id)
CREATE UNIQUE INDEX UX_User_id User ON User(id);
CREATE INDEX IX_User_office_id User ON User(office_id);
CREATE INDEX IX_User_first_name ON User(first_name);
CREATE INDEX IX_User_last_name ON User(last_name);
CREATE INDEX IX_User_middle_name ON User(middle_name);
CREATE INDEX IX_User_position ON User(position);
COMMENT ON TABLE User IS 'Пользователь';
-----------------------------------------------------------------------------------------------
-- Таблица документов, удостоверяющих личность пользователя--
CREATE TABLE IF NOT EXISTS Document(
user_id INTEGER NOT NULL COMMENT 'Уникальный идентификатор пользователя, которому принадлежит документ',
version INTEGER COMMENT 'Служебное поле Hibernate',
doc_name VARCHAR (50) COMMENT 'Имя документа',
doc_number VARCHAR(10) COMMENT 'Номер документа',
doc_date VARCHAR(10) COMMENT 'Дата выдачи документа',
doc_type_id INTEGER NOT NULL COMMENT 'Уникальный идентификатор типа документа',
CONSTRAINT PK_Document_user_id PRIMARY KEY Document(user_id),
CONSTRAINT FK_Document_doc_type_id FOREIGN KEY Document(doc_type_id) REFERENCES ON DocumentType(id));
CREATE INDEX IX_Document_doc_type_code ON Document(doc_type_code);
COMMENT ON TABLE Document IS 'Документ';