package fr.babaprog.classicworkout.repositories.exercise;

import fr.babaprog.classicworkout.models.exercise.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    @Query(value = "SELECT * FROM Exercise e WHERE e.french_name = :exerciseName or e.english_name = :exerciseName", nativeQuery = true)
    Optional<Exercise> findByFrenchNameOrEnglishName(String exerciseName);

}
