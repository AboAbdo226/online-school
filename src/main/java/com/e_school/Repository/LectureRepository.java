package com.e_school.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_school.entity.Lectures;

@Repository
public interface LectureRepository extends JpaRepository<Lectures, Integer>
{

}
