-- Таблица гражданств --
CREATE TABLE IF NOT EXISTS Country
(
id IDENTITY COMMENT 'Уникальный идентификатор',
version INTEGER COMMENT 'Служебное поле Hibernate',
citizenship_code INTEGER COMMENT 'Код государтсва',
citizenship_name VARCHAR (100) COMMENT 'Название государтсва',
user_id BIGINT COMMENT 'Уникальный идентификатор пользователя',

CONSTRAINT PK_country_id PRIMARY KEY Country(id),
CONSTRAINT FK_Country_user_id FOREIGN KEY Country(user_id) REFERENCES ON User(id)
);
CREATE INDEX UX_Country_id ON Country(id);
CREATE INDEX IX_Country_user_id ON Country(user_id);
COMMENT ON TABLE Country AS 'Гражданство';

-----------------------------------------------------------------------------

-- Таблица типов документов, удостоверяющих личность --
CREATE TABLE IF NOT EXISTS DocumentType
(
id IDENTITY COMMENT 'Уникальный идентификатор',
version INTEGER COMMENT 'Служебное поле Hibernate',
doc_code INTEGER COMMENT 'Код документа',
doc_name VARCHAR (150) COMMENT 'Наименование документа',

CONSTRAINT PK_DocumentType_id PRIMARY KEY DocumentType(id)
);
CREATE INDEX UX_DocumentType_id ON DocumentType(id);
COMMENT ON TABLE DocumentType AS 'Тип документа';

-----------------------------------------------------------------------------

-- Таблица документов, удостоверяющих личность --
CREATE TABLE IF NOT EXISTS Document
(
id IDENTITY COMMENT 'Уникальный идентификатор документа',
version INTEGER COMMENT 'Служебное поле Hibernate',
doc_name varchar (50) COMMENT 'Имя документа',
doc_number varchar(10) COMMENT 'Номер документа',
doc_date DATE COMMENT 'Дата выдачи документа',
user_id BIGINT NOT NULL COMMENT 'Уникальный идентификатор пользователя',
doc_type_id BIGINT NOT NULL COMMENT 'Уникальный идентификатор типа документа',

CONSTRAINT PK_Document_id PRIMARY KEY Document(id),
CONSTRAINT FK_Document_user_id FOREIGN KEY Document(user_id) REFERENCES ON User(id),
CONSTRAINT FK_Document_doc_id FOREIGN KEY Document(doc_type_id) REFERENCES ON DocumentType(id)
);
CREATE INDEX UX_Document_id ON Document(id);
CREATE INDEX IX_Document_user_id ON Document(user_id);
CREATE INDEX IX_Document_doc_type_code ON Document(doc_type_code);
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
office_id BIGINT NOT NULL COMMENT 'Уникальный идентификатор офиса',
doc_id BIGINT COMMENT 'Уникальный идентификатор документа',

CONSTRAINT PK_User_id PRIMARY KEY User(id),
CONSTRAINT FK_User_office_id FOREIGN KEY User(office_id) REFERENCES ON Office(id)
CONSTRAINT FK_User_doc_id FOREIGN KEY User(doc_id) REFERENCES ON Document(id)
);
CREATE INDEX UX_User_id User ON User(id);
CREATE INDEX IX_User_doc_id User ON User(doc_id);
CREATE INDEX IX_User_office_id User ON User(office_id);
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
version INTEGER COMMENT 'Служебное поле Hibernate',
name VARCHAR (50) COMMENT 'Имя офиса',
address VARCHAR (150) COMMENT 'Адрем офиса',
phone VARCHAR (11) COMMENT 'Номер телефона офиса',
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
version INTEGER COMMENT 'Служебное поле Hibernate',
name VARCHAR (50) NOT NULL COMMENT 'Имя организации',
full_name VARCHAR (100) NOT NULL COMMENT 'Полное название организации',
inn VARCHAR(12) NOT NULL COMMENT 'ИНН организации',
kpp VARCHAR(9) NOT NULL COMMENT 'КПП организации',
address VARCHAR (150) NOT NULL COMMENT 'Юридический адрес организации',
phone VARCHAR (11) COMMENT 'Номер телефона организации',
is_active BOOLEAN default true COMMENT 'Флаг активности',

CONSTRAINT PK_Organization_id PRIMARY KEY Organization(id),
);
CREATE INDEX UX_Organization_id ON Organization(id);
CREATE INDEX UX_Organization_name ON Organization(name);
CREATE INDEX UX_Organization_inn ON Organization(inn);
CREATE INDEX IX_Organization_is_active ON Organization(is_active);
COMMENT ON TABLE Organization AS 'Организация';