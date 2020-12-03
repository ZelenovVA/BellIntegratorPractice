-- Таблица гражданств --
CREATE TABLE IF NOT EXISTS Country (
id               INTEGER                COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
version          INTEGER                COMMENT 'Служебное поле Hibernate',
citizenship_code VARCHAR(5) NOT NULL    COMMENT 'Код государтсва',
citizenship_name VARCHAR (100) NOT NULL COMMENT 'Название государтсва');
CREATE UNIQUE INDEX UX_Country_id ON Country(id);
COMMENT ON TABLE Country IS 'Гражданство';
-----------------------------------------------------------------------------
-- Таблица типов документов, удостоверяющих личность --
CREATE TABLE IF NOT EXISTS Document_Type(
id       INTEGER                COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
version  INTEGER                COMMENT 'Служебное поле Hibernate',
doc_code VARCHAR(5) NOT NULL    COMMENT 'Код документа',
doc_name VARCHAR (150) NOT NULL COMMENT 'Наименование документа');
CREATE UNIQUE INDEX UX_Document_Type_id ON Document_Type(id);
COMMENT ON TABLE Document_Type IS 'Тип документа';
-----------------------------------------------------------------------------
--Таблица организаций --
CREATE TABLE IF NOT EXISTS Organization(
id        INTEGER                COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
version   INTEGER                COMMENT 'Служебное поле Hibernate',
name      VARCHAR (50) NOT NULL  COMMENT 'Имя организации',
full_name VARCHAR (100) NOT NULL COMMENT 'Полное название организации',
inn       VARCHAR(12) NOT NULL   COMMENT 'ИНН организации',
kpp       VARCHAR(9) NOT NULL    COMMENT 'КПП организации',
address   VARCHAR (150) NOT NULL COMMENT 'Юридический адрес организации',
phone     VARCHAR (11)           COMMENT 'Номер телефона организации',
is_active BOOLEAN                COMMENT 'Флаг активности');
CREATE UNIQUE INDEX UX_Organization_id ON        Organization(id);
CREATE INDEX        IX_Organization_name ON      Organization(name);
CREATE INDEX        IX_Organization_inn ON       Organization(inn);
CREATE INDEX        IX_Organization_is_active ON Organization(is_active);
COMMENT ON TABLE Organization IS 'Организация';
-----------------------------------------------------------------------------
-- Таблица офисов --
CREATE TABLE IF NOT EXISTS Office(
id        INTEGER          COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
version   INTEGER          COMMENT 'Служебное поле Hibernate',
name      VARCHAR (50)     COMMENT 'Имя офиса',
address   VARCHAR (150)    COMMENT 'Адрем офиса',
phone     VARCHAR (11)     COMMENT 'Номер телефона офиса',
is_active BOOLEAN          COMMENT 'Флаг активности',
org_id    INTEGER NOT NULL COMMENT 'Уникальный идентификатор организации');
CREATE UNIQUE INDEX UX_Office_id ON        Office(id);
CREATE INDEX        IX_Office_org_id ON    Office(org_id);
CREATE INDEX        IX_Office_name ON      Office(name);
CREATE INDEX        IX_Office_phone ON     Office(phone);
CREATE INDEX        IX_Office_is_active ON Office(is_active);
COMMENT ON TABLE Office IS 'Офис';
-----------------------------------------------------------------------------------------------
-- Таблица пользователей --
CREATE TABLE IF NOT EXISTS User(
id            INTEGER                COMMENT 'Уникальный идентификатор пользователя' PRIMARY KEY AUTO_INCREMENT,
version       INTEGER                COMMENT 'Служебное поле Hibernate',
first_name    VARCHAR (50) NOT NULL  COMMENT 'Имя пользователя',
second_name   VARCHAR (50)           COMMENT 'Фамилия пользователя',
middle_name   VARCHAR (50)           COMMENT 'Отчество пользователя',
position      VARCHAR (100) NOT NULL COMMENT 'Должность',
phone         VARCHAR (11)           COMMENT 'Контактный номер телефона',
is_identified BOOLEAN                COMMENT 'Флаг идентификации',
office_id     INTEGER NOT NULL       COMMENT 'Уникальный идентификатор офиса',
country_id    INTEGER NOT NULL       COMMENT 'Уникальный идентификатор гражданства');
CREATE UNIQUE INDEX UX_User_id ON             User(id);
CREATE INDEX        IX_User_office_id ON      User(office_id);
CREATE INDEX        IX_User_first_name ON     User(first_name);
CREATE INDEX        IX_User_second_name ON    User(second_name);
CREATE INDEX        IX_User_middle_name ON    User(middle_name);
CREATE INDEX        IX_User_position ON       User(position);
COMMENT ON TABLE User IS 'Пользователь';
-----------------------------------------------------------------------------------------------
-- Таблица документов, удостоверяющих личность пользователя--
CREATE TABLE IF NOT EXISTS Document(
user_id     INTEGER          COMMENT 'Уникальный идентификатор пользователя, которому принадлежит документ' PRIMARY KEY,
version     INTEGER          COMMENT 'Служебное поле Hibernate',
doc_name    VARCHAR (50)     COMMENT 'Имя документа',
doc_number  VARCHAR(10)      COMMENT 'Номер документа',
doc_date    VARCHAR(10)      COMMENT 'Дата выдачи документа',
doc_type_id INTEGER NOT NULL COMMENT 'Уникальный идентификатор типа документа');
CREATE INDEX IX_Document_doc_type_id ON Document(doc_type_id);
COMMENT ON TABLE Document IS 'Документ';
-----------------------------------------------------------------------------------------------
-- Назначение вторичных ключей --
ALTER TABLE Office
ADD FOREIGN KEY (org_id) REFERENCES Organization(id);
ALTER TABLE User
ADD FOREIGN KEY (office_id) REFERENCES Office(id);
ALTER TABLE User
ADD FOREIGN KEY (country_id) REFERENCES Country(id);
ALTER TABLE Document
ADD FOREIGN KEY (doc_type_id) REFERENCES Document_Type(id);