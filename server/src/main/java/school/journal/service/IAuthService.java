package school.journal.service;

import school.journal.entity.User;
import school.journal.service.exception.AuthException;
import school.journal.service.exception.ServiceException;

public interface IAuthService {
    String login(String username, String password) throws AuthException, ServiceException;

    void logout() throws AuthException, ServiceException;

    User checkToken(String token) throws AuthException, ServiceException;
}