package ru.bellintegrator.zelenov.practice.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.zelenov.practice.country.dao.CountryDao;
import ru.bellintegrator.zelenov.practice.country.model.Country;
import ru.bellintegrator.zelenov.practice.document.dao.DocumentDao;
import ru.bellintegrator.zelenov.practice.document.model.Document;
import ru.bellintegrator.zelenov.practice.documentType.dao.DocumentTypeDao;
import ru.bellintegrator.zelenov.practice.documentType.model.DocumentType;
import ru.bellintegrator.zelenov.practice.exception.DataNotFoundException;
import ru.bellintegrator.zelenov.practice.office.dao.OfficeDao;
import ru.bellintegrator.zelenov.practice.office.model.Office;
import ru.bellintegrator.zelenov.practice.user.dao.UserDao;
import ru.bellintegrator.zelenov.practice.user.model.User;
import ru.bellintegrator.zelenov.practice.user.view.UserListViewIn;
import ru.bellintegrator.zelenov.practice.user.view.UserListViewOut;
import ru.bellintegrator.zelenov.practice.user.view.UserSaveView;
import ru.bellintegrator.zelenov.practice.user.view.UserUpdateView;
import ru.bellintegrator.zelenov.practice.user.view.UserViewById;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final DocumentDao documentDao;
    private final CountryDao countryDao;
    private final OfficeDao officeDao;
    private final DocumentTypeDao documentTypeDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, DocumentDao documentDao, CountryDao countryDao, OfficeDao officeDao, DocumentTypeDao documentTypeDao) {
        this.userDao = userDao;
        this.documentDao = documentDao;
        this.countryDao = countryDao;
        this.officeDao = officeDao;
        this.documentTypeDao = documentTypeDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserListViewOut> getAllUsers(UserListViewIn filter) {
        List<User> users = userDao.getAllUsers(mapUserViewListInToEntity(filter));
        if (users.isEmpty() || users == null) {
            throw new DataNotFoundException("Пользователей с данными параметрами не существует");
        }
        return users
                .stream()
                .map(mapEntityToViewOut())
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserViewById getUserById(Long id) {
        return mapEntityToViewById(userDao.getUserById(id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUser(UserUpdateView userUpdateView) {
        userDao.updateUser(mapViewUpdateToEntity(userUpdateView));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveUser(UserSaveView userSaveView) {
        userDao.saveUser(mapViewSaveToEntity(userSaveView));
    }

    private Function<User, UserListViewOut> mapEntityToViewOut() {
        return user -> {
            UserListViewOut userListViewOut = new UserListViewOut();
            userListViewOut.setId(user.getId());
            userListViewOut.setFirstName(user.getFirstName());
            userListViewOut.setSecondName(user.getSecondName());
            userListViewOut.setMiddleName(user.getMiddleName());
            userListViewOut.setPosition(user.getPosition());
            return userListViewOut;
        };
    }

    private User mapUserViewListInToEntity(UserListViewIn userListViewIn) {
        User user = new User();
        Office office = officeDao.getOfficeById(userListViewIn.getOfficeId());
        if (office == null) {
            throw new DataNotFoundException("Офиса с данным id не существует");
        }
        if (userListViewIn.getFirstName() != null) {
            user.setFirstName(userListViewIn.getFirstName());
        }
        if (userListViewIn.getSecondName() != null) {
            user.setSecondName(userListViewIn.getSecondName());
        }
        if (userListViewIn.getMiddleName() != null) {
            user.setMiddleName(userListViewIn.getMiddleName());
        }
        if (userListViewIn.getPosition() != null) {
            user.setPosition(userListViewIn.getPosition());
        }
        if (userListViewIn.getDocCode() != null) {
            DocumentType documentType = documentTypeDao.getDocTypeByDocCode(userListViewIn.getDocCode());
            if (documentType == null) {
                throw new DataNotFoundException("Данного типа документа не существует");
            }
            Document document = new Document();
            document.setDocType(documentType);
            user.setUserDocument(document);
        }
        if (userListViewIn.getCitizenshipCode() != null) {
            Country country = countryDao.getCountryByCitizenshipCode(userListViewIn.getCitizenshipCode());
            if (country == null) {
                throw new DataNotFoundException("Данного гражданства не существует");
            }
            user.setCountry(country);
        }
        return user;
    }

    private UserViewById mapEntityToViewById(User user) {
        UserViewById userViewById = new UserViewById();
        userViewById.setId(user.getId());
        userViewById.setFirstName(user.getFirstName());
        userViewById.setSecondName(user.getSecondName());
        userViewById.setMiddleName(user.getMiddleName());
        userViewById.setPosition(user.getPosition());
        userViewById.setPhone(user.getPhone());
        userViewById.setDocName(user.getUserDocument().getDocName());
        userViewById.setDocNumber(user.getUserDocument().getDocNumber());
        userViewById.setDocDate(user.getUserDocument().getDocDate());
        userViewById.setCitizenshipCode(user.getCountry().getCitizenshipCode());
        userViewById.setCitizenshipName(user.getCountry().getCitizenshipName());
        userViewById.setIsIdentified(user.getIsIdentified());
        return userViewById;
    }

    private User mapViewUpdateToEntity(UserUpdateView userUpdateView) {
        User user = userDao.getUserById(userUpdateView.getId());
        if (user == null) {
            throw new DataNotFoundException("Пользователь с данным id не существует");
        }
        if (userUpdateView.getOfficeId() != null) {
            Office office = officeDao.getOfficeById(userUpdateView.getOfficeId());
            if (office == null) {
                throw new DataNotFoundException("Офис с данным id не существует");
            }
            user.setOffice(office);
        }
        user.setFirstName(userUpdateView.getFirstName());
        if (userUpdateView.getFirstName() != null) {
            user.setSecondName(userUpdateView.getSecondName());
        }
        if (userUpdateView.getMiddleName() != null) {
            user.setMiddleName(userUpdateView.getMiddleName());
        }
        user.setPosition(userUpdateView.getPosition());
        if (userUpdateView.getPhone() != null) {
            user.setPhone(userUpdateView.getPhone());
        }
        user.setIsIdentified(userUpdateView.getIsIdentified());
        if (userUpdateView.getCitizenshipCode() != null) {
            Country country = countryDao.getCountryByCitizenshipCode(userUpdateView.getCitizenshipCode());
            if (country == null) {
                throw new DataNotFoundException("Данного гражданства не существует");
            }
            user.setCountry(country);
        }
        Document document = user.getUserDocument();
        if (document == null) {
            throw new DataNotFoundException("Данного документа не существует");
        }
        if (userUpdateView.getDocName() != null) {
            document.setDocName(userUpdateView.getDocName());
        }
        if (userUpdateView.getDocNumber() != null) {
            document.setDocNumber(userUpdateView.getDocNumber());
        }
        if (userUpdateView.getDocDate() != null) {
            document.setDocDate(userUpdateView.getDocDate());
        }
        return user;
    }

    private User mapViewSaveToEntity(UserSaveView userSaveView) {
        User user = new User();
        Office office = officeDao.getOfficeById(userSaveView.getOfficeId());
        if (office == null) {
            throw new DataNotFoundException("Офиса с данным id не существует");
        }
        user.setFirstName(userSaveView.getFirstName());
        if (userSaveView.getSecondName() != null) {
            user.setSecondName(userSaveView.getSecondName());
        }
        if (userSaveView.getMiddleName() != null) {
            user.setMiddleName(userSaveView.getMiddleName());
        }
        user.setPosition(userSaveView.getPosition());
        if (userSaveView.getPosition() != null) {
            user.setPhone(userSaveView.getPhone());
        }
        user.setIsIdentified(userSaveView.getIsIdentified());
        if (userSaveView.getCitizenshipCode() != null) {
            Country country = countryDao.getCountryByCitizenshipCode(userSaveView.getCitizenshipCode());
            if (country == null) {
                throw new DataNotFoundException("Гражданства с данным кодом не существует");
            }
            user.setCountry(country);
        }
        if (userSaveView.getDocCode() != null) {
            DocumentType documentType = documentTypeDao.getDocTypeByDocCode(userSaveView.getDocCode());
            if (documentType == null) {
                throw new DataNotFoundException("Типа документа с данным кодом не существует");
            }
            Document document = new Document();
            document.setDocType(documentType);
        }
        if (user.getUserDocument() != null) {
            Document document = user.getUserDocument();
            if (userSaveView.getDocNumber() != null) {
                document.setDocNumber(userSaveView.getDocNumber());
            }
            if (userSaveView.getDocNumber() != null) {
                document.setDocNumber(userSaveView.getDocNumber());
            }
            if (userSaveView.getDocDate() != null) {
                document.setDocDate(userSaveView.getDocDate());
            }
        } else {
            Document newDocument = new Document();
            if (userSaveView.getDocNumber() != null) {
                newDocument.setDocNumber(userSaveView.getDocNumber());
            }
            if (userSaveView.getDocNumber() != null) {
                newDocument.setDocNumber(userSaveView.getDocNumber());
            }
            if (userSaveView.getDocDate() != null) {
                newDocument.setDocDate(userSaveView.getDocDate());
            }
            user.setUserDocument(newDocument);
        }
        return user;
    }
}
