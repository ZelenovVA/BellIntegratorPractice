package ru.bellintegrator.zelenov.practice.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.zelenov.practice.dao.country.CountryDao;
import ru.bellintegrator.zelenov.practice.dao.document.DocumentDao;
import ru.bellintegrator.zelenov.practice.dao.documentType.DocumentTypeDao;
import ru.bellintegrator.zelenov.practice.dao.office.OfficeDao;
import ru.bellintegrator.zelenov.practice.dao.user.UserDao;
import ru.bellintegrator.zelenov.practice.model.country.Country;
import ru.bellintegrator.zelenov.practice.model.document.Document;
import ru.bellintegrator.zelenov.practice.model.documentType.DocumentType;
import ru.bellintegrator.zelenov.practice.model.user.User;
import ru.bellintegrator.zelenov.practice.view.user.UserListViewIn;
import ru.bellintegrator.zelenov.practice.view.user.UserListViewOut;
import ru.bellintegrator.zelenov.practice.view.user.UserSaveView;
import ru.bellintegrator.zelenov.practice.view.user.UserUpdateView;
import ru.bellintegrator.zelenov.practice.view.user.UserViewById;

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
        return userDao.getAllUsers(mapUserViewListInToEntity(filter))
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

    private Function<User, UserListViewOut> mapEntityToViewOut(){
        return user -> {
            UserListViewOut userListViewOut=new UserListViewOut();
            userListViewOut.setId(user.getId());
            userListViewOut.setFirstName(user.getFirstName());
            userListViewOut.setSecondName(user.getSecondName());
            userListViewOut.setMiddleName(user.getMiddleName());
            userListViewOut.setPosition(user.getPosition());
            return userListViewOut;
        };
    }

    private User mapUserViewListInToEntity(UserListViewIn userListViewIn){
        User user=new User();
        user.setOffice(officeDao.getOfficeById(userListViewIn.getOfficeId()));
        user.setFirstName(userListViewIn.getFirstName());
        user.setSecondName(userListViewIn.getSecondName());
        user.setMiddleName(userListViewIn.getMiddleName());
        user.setPosition(userListViewIn.getPosition());
        DocumentType documentType=documentTypeDao.getDocTypeByDocCode(userListViewIn.getDocCode());
        Document document=new Document();
        if (documentType!=null){
            document.setDocType(documentType);
        }
        if (document!=null){
            user.setUserDocument(document);
        }
        Country country=countryDao.getCountryByCitizenshipCode(userListViewIn.getCitizenshipCode());
        if (country!=null){
            user.setCountry(country);
        }
        return user;
    }

    private UserViewById mapEntityToViewById(User user){
        UserViewById userViewById=new UserViewById();
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

    private User mapViewUpdateToEntity(UserUpdateView userUpdateView){
        User user=new User();
        user.setId(userUpdateView.getId());
        user.setOffice(officeDao.getOfficeById(userUpdateView.getOfficeId()));
        user.setFirstName(userUpdateView.getFirstName());
        user.setSecondName(userUpdateView.getSecondName());
        user.setMiddleName(userUpdateView.getMiddleName());
        user.setPosition(userUpdateView.getPosition());
        user.setPhone(userUpdateView.getPhone());
        user.setIsIdentified(userUpdateView.getIsIdentified());
        Country country=countryDao.getCountryByCitizenshipCode(userUpdateView.getCitizenshipCode());
        if (country!=null){
            user.setCountry(country);
        }
        Document document=new Document();
        document.setDocName(userUpdateView.getDocName());
        document.setDocNumber(userUpdateView.getDocNumber());
        document.setDocDate(userUpdateView.getDocDate());
        if (document!=null){
            user.setUserDocument(document);
        }
        return user;
    }

    private User mapViewSaveToEntity(UserSaveView userSaveView){
        User user=new User();
        user.setOffice(officeDao.getOfficeById(userSaveView.getOfficeId()));
        user.setFirstName(userSaveView.getFirstName());
        user.setSecondName(userSaveView.getSecondName());
        user.setMiddleName(userSaveView.getMiddleName());
        user.setPosition(userSaveView.getPosition());
        user.setPhone(userSaveView.getPhone());
        user.setIsIdentified(userSaveView.getIsIdentified());
        Country country=countryDao.getCountryByCitizenshipCode(userSaveView.getCitizenshipCode());
        if (country!=null){
            user.setCountry(country);
        }
        DocumentType documentType=documentTypeDao.getDocTypeByDocCode(userSaveView.getDocCode());
        Document document=new Document();
        if (documentType!=null){
            document.setDocType(documentType);
        }
        document.setDocName(userSaveView.getDocName());
        document.setDocNumber(userSaveView.getDocNumber());
        document.setDocDate(userSaveView.getDocDate());
        if (document!=null){
            user.setUserDocument(document);
        }
        return user;
    }
}
