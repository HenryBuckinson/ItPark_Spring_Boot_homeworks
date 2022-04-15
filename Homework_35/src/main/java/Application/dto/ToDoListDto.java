package Application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoListDto {

    @NotNull
    private Integer order;

    private String note;

    private Date date;

    private Boolean is_Done;

}
