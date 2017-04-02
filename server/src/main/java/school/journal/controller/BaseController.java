package school.journal.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import school.journal.controller.util.callable.*;
import school.journal.controller.util.ErrorObject;
import school.journal.service.exception.ServiceException;

import java.util.concurrent.Callable;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;
import static school.journal.controller.util.ErrorObject.CRITICAL_ERROR;

public abstract class BaseController<T> {
    ResponseEntity doResponse(CallableWithResultList<T> operation, String errorMessage, Logger logger) {
        ResponseEntity resultResponse = null;
        try {
            resultResponse = createResponseEntity(operation.call(), OK);
        } catch (ServiceException exc) {
            logger.error(exc);
            resultResponse = createResponseEntity(new ErrorObject(errorMessage), BAD_REQUEST);
        } catch (Exception exc) {
            logger.error(exc);
            resultResponse = createResponseEntity(CRITICAL_ERROR, INTERNAL_SERVER_ERROR);
        }
        return resultResponse;
    }

    ResponseEntity doResponse(CallableWithTParam<T> operation, T obj, String errorMessage, Logger logger) {
        ResponseEntity resultResponse = null;
        try {
            resultResponse = createResponseEntity(operation.call(obj), OK);
        } catch (ServiceException exc) {
            logger.error(exc);
            resultResponse = createResponseEntity(new ErrorObject(errorMessage), BAD_REQUEST);
        } catch (Exception exc) {
            logger.error(exc);
            resultResponse = createResponseEntity(CRITICAL_ERROR, INTERNAL_SERVER_ERROR);
        }
        return resultResponse;
    }

    ResponseEntity doResponse(CallableWithResultListWithParamsInt<T> operation, int i, String errorMessage, Logger logger) {
        ResponseEntity resultResponse = null;
        try {
            resultResponse = createResponseEntity(operation.call(i), OK);
        } catch (ServiceException exc) {
            logger.error(exc);
            resultResponse = createResponseEntity(new ErrorObject(errorMessage), BAD_REQUEST);
        } catch (Exception exc) {
            logger.error(exc);
            resultResponse = createResponseEntity(CRITICAL_ERROR, INTERNAL_SERVER_ERROR);
        }
        return resultResponse;
    }

    ResponseEntity doResponse(CallableWithParamsIntInt<T> operation, int a, int b, String errorMessage, Logger logger, boolean _) {
        ResponseEntity resultResponse = null;
        try {
            resultResponse = createResponseEntity(operation.call(a, b), OK);
        } catch (ServiceException exc) {
            logger.error(exc);
            resultResponse = createResponseEntity(new ErrorObject(errorMessage), BAD_REQUEST);
        } catch (Exception exc) {
            logger.error(exc);
            resultResponse = createResponseEntity(CRITICAL_ERROR, INTERNAL_SERVER_ERROR);
        }
        return resultResponse;
    }

    ResponseEntity doResponse(CallableWithParamsIntBoolean<T> operation, int i, boolean f, String errorMessage, Logger logger) {
        ResponseEntity resultResponse = null;
        try {
            resultResponse = createResponseEntity(operation.call(i, f), OK);
        } catch (ServiceException exc) {
            logger.error(exc);
            resultResponse = createResponseEntity(new ErrorObject(errorMessage), BAD_REQUEST);
        } catch (Exception exc) {
            logger.error(exc);
            resultResponse = createResponseEntity(CRITICAL_ERROR, INTERNAL_SERVER_ERROR);
        }
        return resultResponse;
    }

    ResponseEntity doResponse(CallableWithResultListWithParamsIntInt<T> operation, int a, int b, String errorMessage, Logger logger) {
        ResponseEntity resultResponse = null;
        try {
            resultResponse = createResponseEntity(operation.call(a, b), OK);
        } catch (ServiceException exc) {
            logger.error(exc);
            resultResponse = createResponseEntity(new ErrorObject(errorMessage), BAD_REQUEST);
        } catch (Exception exc) {
            logger.error(exc);
            resultResponse = createResponseEntity(CRITICAL_ERROR, INTERNAL_SERVER_ERROR);
        }
        return resultResponse;
    }

    ResponseEntity doResponse(CallableWithParamsInt<T> operation, int i, String errorMessage, Logger logger) {
        ResponseEntity resultResponse = null;
        try {
            resultResponse = createResponseEntity(operation.call(i), OK);
        } catch (ServiceException exc) {
            logger.error(exc);
            resultResponse = createResponseEntity(new ErrorObject(errorMessage), BAD_REQUEST);
        } catch (Exception exc) {
            logger.error(exc);
            resultResponse = createResponseEntity(CRITICAL_ERROR, INTERNAL_SERVER_ERROR);
        }
        return resultResponse;
    }

    ResponseEntity doResponse(CallableWithoutResultWithParamsInt operation, int i, String errorMessage, Logger logger) {
        ResponseEntity resultResponse = null;
        try {
            operation.call(i);
            resultResponse = createResponseEntity(OK);
        } catch (ServiceException exc) {
            logger.error(exc);
            resultResponse = createResponseEntity(new ErrorObject(errorMessage), BAD_REQUEST);
        } catch (Exception exc) {
            logger.error(exc);
            resultResponse = createResponseEntity(CRITICAL_ERROR, INTERNAL_SERVER_ERROR);
        }
        return resultResponse;
    }

    private ResponseEntity createResponseEntity(Object data, HttpStatus status) {
        return new ResponseEntity(data, status);
    }

    private ResponseEntity createResponseEntity(HttpStatus status) {
        return new ResponseEntity(status);
    }
}