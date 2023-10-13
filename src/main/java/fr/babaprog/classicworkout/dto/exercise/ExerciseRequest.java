package fr.babaprog.classicworkout.dto.exercise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseRequest {

    private String frenchName;
    private String englishName;
    private List<String> muscularGroup;
    private int weight;
    private LocalDateTime lastTimeDone;
}
