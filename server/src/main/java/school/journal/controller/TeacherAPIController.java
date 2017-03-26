package school.journal.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.journal.controller.exception.ControllerException;
import school.journal.controller.util.ErrorObject;
import school.journal.service.ITeacherService;
import school.journal.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;
import static school.journal.controller.util.ErrorObject.CRITICAL_ERROR;

@RestController
@RequestMapping(value = "/api/teachers")
public class TeacherAPIController {
    private static final Logger LOGGER = Logger.getLogger(TeacherAPIController.class);

    @Autowired
    @Qualifier("TeacherService")
    private ITeacherService teacherService;

    @GetMapping("/{classId}")
    public ResponseEntity get(HttpServletRequest request, @PathVariable("classId") int classId)
            throws ControllerException {
        ResponseEntity resultResponse = null;
        try {
            resultResponse = new ResponseEntity(teacherService.getListOfTeachersForClass(classId), OK);
        } catch (ServiceException exc) {
            LOGGER.error(exc);
            resultResponse = new ResponseEntity(new ErrorObject("Can't get teacher list for class"), BAD_REQUEST);
        } catch (Exception exc) {
            LOGGER.error(exc);
            resultResponse = new ResponseEntity(CRITICAL_ERROR, INTERNAL_SERVER_ERROR);
        }
        return resultResponse;
    }

    @PostMapping("/{teacherId}/{classId}")
    public ResponseEntity changeClassOfTeacher(HttpServletRequest request, @PathVariable("teacherId") int teacherId, @PathVariable("classId") int classId)
            throws ControllerException {
        ResponseEntity resultResponse = null;
        try {
            resultResponse = new ResponseEntity(teacherService.changeClassOfTeacher(teacherId, classId), OK);
        } catch (ServiceException exc) {
            LOGGER.error(exc);
            resultResponse = new ResponseEntity(new ErrorObject("Can't change class of teacher"), BAD_REQUEST);
        } catch (Exception exc) {
            LOGGER.error(exc);
            resultResponse = new ResponseEntity(CRITICAL_ERROR, INTERNAL_SERVER_ERROR);
        }
        return resultResponse;
    }

    @PostMapping("/{teacherId}")
    public ResponseEntity changeDirectorOfStudiesStatus(HttpServletRequest request, @PathVariable("teacherId") int teacherId, @RequestParam("isDirector") boolean isDirector)
            throws ControllerException {
        ResponseEntity resultResponse = null;
        try {
            resultResponse = new ResponseEntity(teacherService.changeDirectorOfStudies(teacherId, isDirector), OK);
        } catch (ServiceException exc) {
            LOGGER.error(exc);
            resultResponse = new ResponseEntity(new ErrorObject("Can't change director of studies status"), BAD_REQUEST);
        } catch (Exception exc) {
            LOGGER.error(exc);
            resultResponse = new ResponseEntity(CRITICAL_ERROR, INTERNAL_SERVER_ERROR);
        }
        return resultResponse;
    }
}
