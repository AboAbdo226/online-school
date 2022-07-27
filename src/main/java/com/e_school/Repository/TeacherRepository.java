package com.e_school.Repository;


import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.e_school.entity.Teacher;
import com.e_school.entity.User;




@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
	
	@Query(value="select count( DISTINCT fname) from Teacher ", nativeQuery = true) // for memorizing
	public int number();
	public List<Teacher> findByFname(String name);
 	@Query(value="select * from User u inner join Teacher s on u.id = s.user_id where u.is_enable = 1 " ,nativeQuery = true)
	public List<Teacher> findAll();
 	@Query(value="select * from User u inner join Teacher s on u.id = s.user_id where email=?1" ,nativeQuery = true)
 	public Optional<Teacher> findByEmail(String email);
 	@Query(value="select s.* from Teacher s inner join Class c on c.id =s.Class_id inner join Grade g on g.id =c.Grade_id where g.id=?1 ",nativeQuery = true)
 	public List<Teacher> findByGrade(int n);
 	@Query(value="select * from Teacher s inner join Class c on c.id =s.Class_id where c.id=?1 ",nativeQuery = true)
 	public List<Teacher> findByClass(int n);
 	@Query(value = "select * from Teacher s inner join User u on u.id = s.user_id where u.bane_reason !=?1 and u.is_enable = 0", nativeQuery = true)
 	public List<Teacher> findBannedTeachers(String n); 
 	@Query(value = "select * from Teacher s inner join User u on u.id = s.user_id where u.bane_reason =?1 and u.is_enable = 0", nativeQuery = true)
 	public List<Teacher> findNotActivatedTeachers(String n); 
 
	
}
