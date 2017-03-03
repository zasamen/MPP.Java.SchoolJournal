package school.journal.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Component;
import school.journal.entity.Pupil;
import school.journal.repository.RepositoryAbstractClass;
import school.journal.repository.exception.RepositoryException;
import school.journal.repository.specification.HibernateSpecification;

import java.util.List;
@Component
public class PupilRepository extends RepositoryAbstractClass<Pupil> {
    @Override
    public Pupil create(Pupil pupil, Session session) throws RepositoryException {
        session.save(pupil);
        return pupil;
    }

    @Override
    public Pupil update(Pupil pupil, Session session) throws RepositoryException {
        session.update(pupil);
        return pupil;
    }

    @Override
    public Pupil delete(Pupil pupil, Session session) throws RepositoryException {
        session.delete(pupil);
        return pupil;
    }

    @Override
    public List<Pupil> query(HibernateSpecification specification, Session session) throws RepositoryException {
        Criteria criteria =  session.createCriteria(Pupil.class);
        Criterion criterion;
        if((specification != null) && ((criterion = specification.toCriteria()) != null)){
            criteria.add(criterion);
        }
        return criteria.list();
    }
}
