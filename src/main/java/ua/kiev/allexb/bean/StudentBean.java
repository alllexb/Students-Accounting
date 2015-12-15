package ua.kiev.allexb.bean;

import ua.kiev.allexb.entity.Student;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@Local
public class StudentBean {

    @PersistenceContext(unitName = "StudentManagement")
    private EntityManager em;

    public Student add(Student student) {
        return em.merge(student);
    }

    public Student get(long id) {
        return em.find(Student.class, id);
    }

    public void update(Student student) {
        add(student);
    }

    public void delete(long id) {
        em.remove(get(id));
    }

    public List<Student> getAll(){
        TypedQuery<Student> namedQuery = em.createNamedQuery("Student.getAll", Student.class);
        return namedQuery.getResultList();
    }
}
