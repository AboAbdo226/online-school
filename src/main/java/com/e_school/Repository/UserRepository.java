package com.e_school.Repository;


import java.util.List;
import java.util.Optional;

import javax.persistence.Convert;
import javax.swing.text.html.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.e_school.entity.Student;
import com.e_school.entity.Teacher;
import com.e_school.entity.User;




@Repository
public interface UserRepository extends JpaRepository<User,Long> {


	public User findUserByemail(String email);
	
	public User findUserByverifications(String code);
	
	public boolean existsByemail(String email);
	public List<User> findUserByTeacher(String no); 
	
     @Query (value="SELECT email,fname FROM user a inner Join student s on a.id = s.user_id", nativeQuery = true )
       List<String> fofo();
     @Query (value="SELECT id,email FROM user ", nativeQuery = true )
     List<String> fofo2();
    // @Modifying
  //   @Transactional
     //@Query(value="delete from User where email =?1",nativeQuery = true)
    public int deleteByEmail(String n);

     
     @Query("select new com.e_school.Repository.teacherAIO(u.email,u.isEnable,u.banedReason,t.fname,t.lname) from user As u , Teacher as t  where u.id = t.user_id  and  u.email=?1 ")
   // @Query(value="select u.email as emailo from user As u ",nativeQuery = true)  fckkkkkkkkk itttttttttttttttttttttttt
    public teacherAIO findMutentTeacher(String n);
//    @Query("select new com.e_school.Repository.teacherAIO(u.email,u.isEnable,u.banedReason,t.fname,t.lname,s.name)"
//    		+ " from user As u , Teacher as t ,Lectures as l , Subject as s "
//    		+ " where u.id = t.user_id  and t.id = l.teacher and s.id = l.subject and u.email=?1 ")
//    public teacherAIO findTheExpertTeacher(String n) ;
    
    @Query(value="select u.id from User u inner join Teacher t on u.id = t.user_id "
    		+ "inner join Lectures l on t.id = l.teacher_id "
    		+ "inner join Subject s on s.id = l.subject_id "
    		+ "where (u.email =?1 and s.id=?2)",nativeQuery = true)
    public int checkTeacherSubject(String n,int i) ;
	
	
	
}
