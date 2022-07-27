package com.e_school.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.e_school.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>
{

    @Query(value="select s.id from Subject s "
    		+ "inner join Lectures l on s.id = l.subject_id "
    		+ "inner join Teacher t on t.id = l.teacher_id "
    		+ "inner join User u on u.id = t.user_id "
    		+ "where u.email =?1 ",nativeQuery = true)
    public List<Integer> findTeachrSubjects(String i) ;
    @Query(value="select s.name from Subject s where s.id=?1 ",nativeQuery = true)
    public String findSubjectById(int i);
}
