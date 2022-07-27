package com.e_school.Repository;


import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.e_school.entity.Student;
import com.e_school.entity.Teacher;
import com.e_school.entity.User;




@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
	
	@Query(value="select count( DISTINCT fname) from Student ", nativeQuery = true) // for memorizing
	public int number();
	public List<Student> findByFname(String name);
 	@Query(value="select * from User u inner join Student s on u.id = s.user_id where u.is_enable = 1 " ,nativeQuery = true)
	public List<Student> findAll();
 	@Query(value="select * from User u inner join Student s on u.id = s.user_id where email=?1" ,nativeQuery = true)
 	public Optional<Student> findByEmail(String email);
 	@Query(value="select s.* from Student s inner join Class c on c.id =s.Class_id inner join Grade g on g.id =c.Grade_id where g.id=?1 ",nativeQuery = true)
 	public List<Student> findByGrade(int n);
 	@Query(value="select * from Student s inner join Class c on c.id =s.Class_id where c.id=?1 ",nativeQuery = true)
 	public List<Student> findByClass(int n);
 	@Query(value = "select * from Student s inner join User u on u.id = s.user_id where u.bane_reason !=?1", nativeQuery = true)
 	public List<Student> findBannedStudents(String n); 

 
	
}
