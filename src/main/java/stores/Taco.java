package stores;
import java.util.Date;
import java.util.List;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;
@Data
@Table
public class Taco {
@Id
private Long id;
private Date createdAt = new Date();
@NotNull
@Size(min=5, message="Имя должно содержать не менее 5 символов")
private String name;
@NotNull
@Size(min=1, message="Вы должны выбрать хотя бы один ингредиент")
private List<Ingredient> ingredients;
} 