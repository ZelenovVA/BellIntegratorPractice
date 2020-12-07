package ru.bellintegrator.zelenov.practice.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
        if (users.isEmpty()) {
            throw new DataNotFoundException("Users with these parameters were not found");
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
        User user = this.userDao.getUserById(id);
        if (user == null) {
            throw new DataNotFoundException("User with this id was not found");
        }
        return mapEntityToViewById(user);
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
            if (user.getUserDocument() != null && user.getUserDocument().getDocType() != null) {
                userListViewOut.setDocCode(user.getUserDocument().getDocType().getDocCode());
            }
            if (user.getCountry() != null) {
                userListViewOut.setCitizenshipCode(user.getCountry().getCitizenshipCode());
            }
            return userListViewOut;
        };
    }

    private User mapUserViewListInToEntity(UserListViewIn userListViewIn) {
        User user = new User();
        Office office = officeDao.getOfficeById(userListViewIn.getOfficeId());
        if (office == null) {
            throw new DataNotFoundException("Office with this id was not found");
        }
        user.setOffice(office);
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
            DocumentType documentType = null;
            try {
                documentTypeDao.getDocTypeByDocCode(userListViewIn.getDocCode());
            } catch (EmptyResultDataAccessException e) {
                throw new DataNotFoundException("Document type with this document code was not found");
            }
            Document document = new Document();
            document.setDocType(documentType);
            user.setUserDocument(document);
            document.setUser(user);
        }
        if (userListViewIn.getCitizenshipCode() != null) {
            Country country = null;
            try {
                countryDao.getCountryByCitizenshipCode(userListViewIn.getCitizenshipCode());
            } catch (EmptyResultDataAccessException e) {
                throw new DataNotFoundException("Country with this citizenship code was not found");
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
            throw new DataNotFoundException("User with this id was not found");
        }
        if (userUpdateView.getOfficeId() != null) {
            Office office = officeDao.getOfficeById(userUpdateView.getOfficeId());
            if (office == null) {
                throw new DataNotFoundException("Office with this id was not found");
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
            Country country = null;
            try {
                countryDao.getCountryByCitizenshipCode(userUpdateView.getCitizenshipCode());
            } catch (EmptyResultDataAccessException e) {
                throw new DataNotFoundException("Country with this citizenship code was not found");
            }
            user.setCountry(country);
        }
        Document document = user.getUserDocument();
        if (document == null) {
            document = new Document();
            user.setUserDocument(document);
            document.setUser(user);
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
            throw new DataNotFoundException("Office with this id was not found");
        }
        user.setOffice(office);
        user.setFirstName(userSaveView.getFirstName());
        if (userSaveView.getSecondName() != null) {
            user.setSecondName(userSaveView.getSecondName());
        }
        if (userSaveView.getMiddleName() != null) {
            user.setMiddleName(userSaveView.getMiddleName());
        }
        user.setPosition(userSaveView.getPosition());
        if (userSaveView.getPhone() != null) {
            user.setPhone(userSaveView.getPhone());
        }
        if (userSaveView.getIsIdentified() != null) {
            user.setIsIdentified(userSaveView.getIsIdentified());
        }
        if (userSaveView.getCitizenshipCode() != null) {
            Country country = null;
            try {
                countryDao.getCountryByCitizenshipCode(userSaveView.getCitizenshipCode());
            } catch (EmptyResultDataAccessException e) {
                throw new DataNotFoundException("Country with this citizenship code was not found");
            }
            user.setCountry(country);
        }
        if (userSaveView.getDocCode() != null) {
            DocumentType documentType = documentTypeDao.getDocTypeByDocCode(userSaveView.getDocCode());
            if (documentType == null) {
                throw new DataNotFoundException("Document type with this document code was not found");
            }
            Document document = new Document();
            document.setDocType(documentType);
            document.setUser(user);
            user.setUserDocument(document);
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
            if (userSaveView.getDocName() != null) {
                newDocument.setDocName(userSaveView.getDocName());
            }
            if (userSaveView.getDocNumber() != null) {
                newDocument.setDocNumber(userSaveView.getDocNumber());
            }
            if (userSaveView.getDocDate() != null) {
                newDocument.setDocDate(userSaveView.getDocDate());
            }
            if (newDocument.getDocNumber() != null || newDocument.getDocName() != null || newDocument.getDocDate() != null) {
                newDocument.setUser(user);
                user.setUserDocument(newDocument);
            }
        }
        return user;
    }
}
