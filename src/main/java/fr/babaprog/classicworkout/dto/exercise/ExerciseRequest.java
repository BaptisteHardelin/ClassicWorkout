package fr.babaprog.classicworkout.dto.exercise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseRequest {

    private String french_name;
    private String english_name;
    private String muscular_group;
    private int weight;
    private LocalDateTime last_time_done;
}
